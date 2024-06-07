package com.example.pacman.panel.board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.util.BoardGenerator;
import com.example.pacman.character.Pacman;
import com.example.pacman.window.GameWindow;

import javax.swing.*;
import java.awt.*;

public abstract class Board extends JPanel {
  private final BoardType boardType;
  private final BoardSize boardSize;
  private final int numberOfYBlocks;
  private final int numberOfXBlocks;

  private Pacman pacman;

  private char[][] board;

    private final GameWindow parent;

  public Board(BoardSize boardSize, BoardType boardType, int numberOfYBlocks, int numberOfXBlocks, GameWindow parent) {
    this.boardSize = boardSize;
    this.boardType = boardType;
    this.numberOfYBlocks = numberOfYBlocks;
    this.numberOfXBlocks = numberOfXBlocks;
    this.parent = parent;
    setPreferredSize(new Dimension(boardSize.getWidth(), boardSize.getHeight()));
    setLayout(new BorderLayout());
    this.requestFocusInWindow();
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
    this.removeAll();
    JPanel gridPanel = BoardGenerator.generateBoard(this);
    this.add(gridPanel, BorderLayout.CENTER);
    gridPanel.setFocusable(true);
    gridPanel.requestFocusInWindow();
    this.revalidate();
  }

  public void addPointsForEatenFood() {
    getParent().addPoints(10);
  }

  public BoardType getBoardType() {
    return boardType;
  }
}
