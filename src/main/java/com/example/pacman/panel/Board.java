package com.example.pacman.panel;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.util.BoardGenerator;

import javax.swing.*;
import java.awt.*;

public abstract class Board extends JPanel {
  protected final char WALL = 'W';
  protected final char EMPTY = 'E';
  protected final char PACMAN = 'P';
  protected final char FOOD = 'F';
  private final BoardType boardType;
  private final BoardSize boardSize;
  private final int numberOfYBlocks;
  private final int numberOfXBlocks;

  private char[][] board;
  private JPanel gridPanel;

  public Board(BoardSize boardSize, BoardType boardType, int numberOfYBlocks, int numberOfXBlocks) {
    this.boardSize = boardSize;
    this.boardType = boardType;
    this.numberOfYBlocks = numberOfYBlocks;
    this.numberOfXBlocks = numberOfXBlocks;
    setPreferredSize(new Dimension(boardSize.getWidth(), boardSize.getHeight()));
    setLayout(new BorderLayout());
    this.requestFocusInWindow();
  }

  public BoardType getBoardType() {
    return boardType;
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

  public void generate() {
    this.removeAll();
    gridPanel = BoardGenerator.generateBoard(this, Color.DARK_GRAY);
    this.add(gridPanel, BorderLayout.CENTER);
    gridPanel.setFocusable(true);
    gridPanel.requestFocusInWindow();
    this.revalidate();
  }

  public void updateCell(int x, int y) {
    if (x >= 0 && x < numberOfXBlocks && y >= 0 && y < numberOfYBlocks) {
      Component[] components = gridPanel.getComponents();
      int index = y * numberOfXBlocks + x;
      JLabel label = (JLabel) components[index];
      switch (board[y][x]) {
        case 'W':
          label.setBackground(Color.DARK_GRAY);
          label.setIcon(null);
          break;
        case 'F':
          label.setBackground(Color.BLACK);
          ImageIcon foodIcon = new ImageIcon(boardSize.getPhotosUrl() + "/food.png");
          label.setIcon(foodIcon);
          break;
        case 'P':
          label.setBackground(Color.BLACK);
          ImageIcon pacmanIcon = new ImageIcon(boardSize.getPhotosUrl() + "/pacman_right_open.png"); // This will be updated by Pacman class
          label.setIcon(pacmanIcon);
          break;
        case 'E':
          label.setBackground(Color.BLACK);
          label.setIcon(null);
          break;
        default:
          label.setBackground(Color.BLACK);
          label.setIcon(null);
          break;
      }
      System.out.println("Updated cell (" + x + ", " + y + ") to " + board[y][x]); // Debug statement
    }
  }
}
