package com.example.pacman.panel.board;

import com.example.pacman.character.Ghost;
import com.example.pacman.character.Pacman;
import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.util.BoardGenerator;
import com.example.pacman.window.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Board extends JPanel {
  private final BoardType boardType;
  private final BoardSize boardSize;
  private final int numberOfYBlocks;
  private final int numberOfXBlocks;
  private Pacman pacman;
  private List<Ghost> ghosts = new ArrayList<>();
  private char[][] board;
  protected char[][] startingBoard;
  private final GameWindow parent;
  private boolean needsRender = false;

  public Board(BoardSize boardSize, BoardType boardType, int numberOfYBlocks, int numberOfXBlocks, GameWindow parent) {
    this.boardSize = boardSize;
    this.boardType = boardType;
    this.numberOfYBlocks = numberOfYBlocks;
    this.numberOfXBlocks = numberOfXBlocks;
    this.parent = parent;
    setPreferredSize(new Dimension(boardSize.getWidth(), boardSize.getHeight()));
    setLayout(new BorderLayout());
    this.requestFocusInWindow();

    Thread renderThread = new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(16); // Approximately 60 FPS
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if (needsRender) {
          generate();
          needsRender = false;
        }
      }
    });
    renderThread.start();
  }

  @Override
  public GameWindow getParent() {
    return parent;
  }

  public BoardSize getBoardSize() {
    return boardSize;
  }

  public int getNumberOfYBlocks() {
    return numberOfYBlocks;
  }

  public int getNumberOfXBlocks() {
    return numberOfXBlocks;
  }

  public void setBoard(char[][] board) {
    this.board = board;
  }

  public char[][] getBoard() {
    return board;
  }

  public Pacman getPacman() {
    return pacman;
  }

  public void setPacman(Pacman pacman) {
    this.pacman = pacman;
  }

  public void generate() {
    synchronized (this) {
      this.removeAll();
      JPanel gridPanel = BoardGenerator.generateBoard(this);
      this.add(gridPanel, BorderLayout.CENTER);
      gridPanel.setFocusable(true);
      gridPanel.requestFocusInWindow();
      this.revalidate();
    }
  }

  public void requestRender() {
    needsRender = true;
  }

  public void addPointsForEatenFood() {
    getParent().addPoints(10);
  }

  public BoardType getBoardType() {
    return boardType;
  }

  public List<Ghost> getGhosts() {
    return ghosts;
  }

  public void restartMap() {
    synchronized (this) {
      for (Ghost g : ghosts) {g.resetCoordinates();}
      for (int y = 0; y < startingBoard.length; y++) {
        for (int x = 0; x < startingBoard[0].length; x++) {
          board[y][x] = startingBoard[y][x];
        }
      }
      pacman = null;
      generate();  // Ensure board is generated with new instances of Pacman and ghosts
    }
  }

  public void decreaseLives() {
    parent.decreaseLives();
  }
}
