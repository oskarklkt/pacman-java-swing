package com.example.pacman.window;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.board.Board;
import com.example.pacman.panel.game.TopPanel;
import com.example.pacman.util.BoardFactory;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

  private final Board board;
  private final TopPanel topPanel;

  public GameWindow(BoardSize boardSize, BoardType boardType) {

    board = BoardFactory.createBoard(boardSize, boardType, this);

    float xRatio =
        (float) board.getNumberOfXBlocks()
            / (board.getNumberOfYBlocks() + board.getNumberOfXBlocks());
    float yRatio =
        (float) board.getNumberOfYBlocks()
            / (board.getNumberOfYBlocks() + board.getNumberOfXBlocks());

    int width = Math.round((boardSize.getWidth() + boardSize.getHeight()) * xRatio);
    int height = Math.round((boardSize.getWidth() + boardSize.getHeight()) * yRatio);
    setTitle("Pacman Game");
    setSize(width, height);
    setLayout(new BorderLayout());
    topPanel = new TopPanel();
    add(topPanel, BorderLayout.NORTH);
    add(board, BorderLayout.CENTER);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void addPoints(int points) {
    topPanel.increaseScore(points);
  }

  public void decreaseLives() {
    topPanel.decreaseLives();
  }
}
