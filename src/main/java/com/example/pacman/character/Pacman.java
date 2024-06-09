package com.example.pacman.character;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.Boost;
import com.example.pacman.enumeration.Direction;
import com.example.pacman.panel.board.Board;
import com.example.pacman.panel.game.LivesPanel;
import com.example.pacman.panel.game.ScorePanel;
import com.example.pacman.panel.game.TimePanel;
import com.example.pacman.util.HighScoreUtil;
import com.example.pacman.window.MenuWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Pacman extends JLabel implements KeyListener, Runnable {

  private final BoardSize boardSize;
  private final Board parent;
  private final char[][] board;
  private Direction currentDirection;
  private boolean isMouthOpened;
  private boolean isAnimationStopped;
  private int x, y;

  public Pacman(Board parent, int startX, int startY) {
    this.boardSize = parent.getBoardSize();
    this.parent = parent;
    this.board = parent.getBoard();
    this.x = startX;
    this.y = startY;

    this.setBackground(Color.BLACK);
    currentDirection = Direction.RIGHT;
    isMouthOpened = true;
    isAnimationStopped = false;
    setIcon(new ImageIcon(boardSize.getPhotosUrl() + currentDirection.getOpenedPhotoPath()));

    // Centering Pacman within the JLabel
    setHorizontalAlignment(JLabel.CENTER);
    setVerticalAlignment(JLabel.CENTER);

    Thread animation = new Thread(this);
    animation.start();
  }

  @Override
  public void run() {
    while (!isAnimationStopped) {
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      isMouthOpened = !isMouthOpened;
      updateImage();
    }
  }

  private void updateImage() {
    String imagePath =
        boardSize.getPhotosUrl()
            + (isMouthOpened
                ? currentDirection.getOpenedPhotoPath()
                : currentDirection.getClosedPhotoPath());
    setIcon(new ImageIcon(imagePath));
  }

  public void stopAnimation() {
    isAnimationStopped = true;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int newX = x, newY = y;
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        currentDirection = Direction.UP;
        newY--;
        break;
      case KeyEvent.VK_DOWN:
        currentDirection = Direction.DOWN;
        newY++;
        break;
      case KeyEvent.VK_LEFT:
        currentDirection = Direction.LEFT;
        newX--;
        break;
      case KeyEvent.VK_RIGHT:
        currentDirection = Direction.RIGHT;
        newX++;
        break;
      case KeyEvent.VK_ESCAPE:
        parent.getParent().dispose();
        SwingUtilities.invokeLater(MenuWindow::new);
        break;
    }

    updateImage();

    boolean moved = false;
    synchronized (board) {
      if (newX >= 0
          && newX < board[0].length
          && newY >= 0
          && newY < board.length
          && board[newY][newX] != 'W') {
        if (board[newY][newX] == 'F') {
          parent.addPoints(10);
          board[newY][newX] = 'E';
        } else if (board[newY][newX] == 'G') {
          if (!Boost.EDIBLE_GHOSTS.getTurnedOn()) {
            parent.decreaseLives();
            parent.restartMap();
            if (LivesPanel.getLives() == 0) {
              parent.getGhosts().forEach(g -> g.setStopped(true));
              ScorePanel.stopScore();
              int score = ScorePanel.getScore();
              String nickname = JOptionPane.showInputDialog(parent, "Enter your nickname:", "Game Over", JOptionPane.PLAIN_MESSAGE);
              if (nickname != null && !nickname.trim().isEmpty()) {
                HighScoreUtil.readHighScores();
                HighScoreUtil.addHighScore(nickname, score);
              }
              parent.getParent().dispose();
              SwingUtilities.invokeLater(MenuWindow::new);

            }
            Arrays.stream(Boost.values()).forEach(Boost::turnOff);
          } else {
            Ghost ghost = Ghost.getGhostByPosition(newX, newY);
            if (ghost != null) {
              ghost.resetCoordinates();
              board[ghost.getY()][ghost.getX()] = 'G';
            }
            board[newY][newX] = 'E';
            parent.addPoints(100);
          }
        } else if (board[newY][newX] == '0') {
          Boost.EDIBLE_GHOSTS.turnOn();
        } else if (board[newY][newX] == '1') {
          Boost.DOUBLE_POINTS.turnOn();
        } else if (board[newY][newX] == '2') {
          Boost.SLOWER_GHOSTS.turnOn();
        } else if (board[newY][newX] == '3') {
          Boost.FROZEN_GHOSTS.turnOn();
        } else if (board[newY][newX] == '4') {
          Boost.ADDITIONAL_LIVE.turnOn();
        }
        board[y][x] = 'E';
        x = newX;
        y = newY;
        board[y][x] = 'P';
        moved = true;
      }
    }
    if (moved) {
      parent.requestRender();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}
}
