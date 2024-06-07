package com.example.pacman.button;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.Board;
import com.example.pacman.util.BoardFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends Button implements ActionListener {
  private final JFrame parentWindow;

  public NewGameButton(JFrame parentWindow) {
    super("New Game");

    this.parentWindow = parentWindow;
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    BoardSize[] sizeOptions = BoardSize.values();
    BoardSize boardSize =
        (BoardSize)
            JOptionPane.showInputDialog(
                parentWindow,
                "Select Board Size:",
                "Board Size",
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizeOptions,
                sizeOptions[0]);

    if (boardSize != null) {
      BoardType[] boardOptions = BoardType.values();
      BoardType boardType =
          (BoardType)
              JOptionPane.showInputDialog(
                  parentWindow,
                  "Select Board Type:",
                  "Board Type",
                  JOptionPane.QUESTION_MESSAGE,
                  null,
                  boardOptions,
                  boardOptions[0]);

      if (boardType != null) {
        parentWindow.dispose();
        JFrame gameWindow = new JFrame("Pacman Game");

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = BoardFactory.createBoard(boardSize, boardType);

        // some calculations to make game window sizing correct
        float xRatio =
            (float) board.getNumberOfXBlocks()
                / (board.getNumberOfYBlocks() + board.getNumberOfXBlocks());
        float yRatio =
            (float) board.getNumberOfYBlocks()
                / (board.getNumberOfYBlocks() + board.getNumberOfXBlocks());

        int width = Math.round((boardSize.getWidth() + boardSize.getHeight()) * xRatio);
        int height = Math.round((boardSize.getWidth() + boardSize.getHeight()) * yRatio);

        gameWindow.setSize(width, height);
        gameWindow.add(board);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
      } else {
        JOptionPane.showMessageDialog(
            parentWindow, "Please, choose a board type.", "Warning", JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(
          parentWindow, "Please, choose a size.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }
}
