package com.example.pacman.character;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.Direction;
import com.example.pacman.panel.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends JLabel implements KeyListener, Runnable {

    private final BoardSize boardSize;
    private Direction currentDirection;
    private boolean isMouthOpened;
    private boolean isAnimationStopped;
    private char[][] board;
    private final Board parent;
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
        String imagePath = boardSize.getPhotosUrl() + (isMouthOpened ? currentDirection.getOpenedPhotoPath() : currentDirection.getClosedPhotoPath());
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
        }

        updateImage();

        boolean moved = false;
        synchronized (board) {
            if (newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length && board[newY][newX] != 'W') {
                if (board[newY][newX] == 'F') {
                    parent.addPointsForEatenFood();
                    board[newY][newX] = 'E';
                } else if (board[y][x] == 'G' || board[newY][x] == 'G') {
                    parent.decreaseLives();
                    parent.restartMap();
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
