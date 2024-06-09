package com.example.pacman.button;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.window.GameWindow;

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
                sizeOptions[3]);

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
        new GameWindow(boardSize, boardType);
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
