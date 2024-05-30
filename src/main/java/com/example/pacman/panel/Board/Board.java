package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import javax.swing.*;
import java.awt.*;

public abstract class Board extends JPanel {
  protected final char WALL = 'W';
  protected final char EMPTY = 'E';
  protected final char FOOD = 'F';
  private final BoardType boardType;
  private final BoardSize boardSize;

  public Board(BoardSize boardSize, BoardType boardType) {
    this.boardSize = boardSize;
    this.boardType = boardType;
    setPreferredSize(new Dimension(boardSize.getWidth(), boardSize.getHeight()));
    setLayout(new BorderLayout());
  }

  public BoardType getBoardType() {
    return boardType;
  }

  public BoardSize getBoardSize() {
    return boardSize;
  }
}
