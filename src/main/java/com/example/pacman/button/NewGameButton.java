package com.example.pacman.button;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.game.ScorePanel;
import com.example.pacman.panel.game.TimePanel;
import com.example.pacman.window.GameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends Button implements ActionListener {
  private final JFrame parentWindow;

  public NewGameButton(JFrame parentWindow) {
    super("New Game");
    this.parentWindow = parentWindow;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    BoardSize boardSize = pickBoardSize();
    if (boardSize == null) {
      JOptionPane.showMessageDialog(
              parentWindow, "Please, choose a size.", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }

    BoardType boardType = pickBoardType();
    if (boardType == null) {
      JOptionPane.showMessageDialog(
              parentWindow, "Please, choose a board type.", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }

    parentWindow.dispose();
    TimePanel.reset();
    new GameWindow(boardSize, boardType);
  }

  private BoardSize pickBoardSize() {
    BoardSize[] sizeOptions = BoardSize.values();
    return (BoardSize) JOptionPane.showInputDialog(
            parentWindow,
            "Select Board Size:",
            "Board Size",
            JOptionPane.QUESTION_MESSAGE,
            null,
            sizeOptions,
            sizeOptions[0]);
  }

  private BoardType pickBoardType() {
    BoardType[] boardOptions = BoardType.values();
    return (BoardType) JOptionPane.showInputDialog(
            parentWindow,
            "Select Board Type:",
            "Board Type",
            JOptionPane.QUESTION_MESSAGE,
            null,
            boardOptions,
            boardOptions[0]);
  }
}