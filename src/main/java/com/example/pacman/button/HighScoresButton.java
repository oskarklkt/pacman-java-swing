package com.example.pacman.button;

import com.example.pacman.window.HighScoresWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresButton extends Button implements ActionListener {
  public HighScoresButton() {
    super("High Scores");
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    SwingUtilities.invokeLater(HighScoresWindow::new);
  }
}
