package com.example.pacman.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends Button implements ActionListener {
  private final JFrame parentWindow;

  public ExitButton(JFrame parentWindow) {
    super("Exit");
    this.parentWindow = parentWindow;
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    parentWindow.dispose();
  }
}
