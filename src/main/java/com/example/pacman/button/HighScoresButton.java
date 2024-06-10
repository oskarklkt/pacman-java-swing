package com.example.pacman.button;

import com.example.pacman.window.HighScoresWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HighScoresButton extends Button {
  public HighScoresButton() {
    super("High Scores");
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    SwingUtilities.invokeLater(HighScoresWindow::new);
  }
}
