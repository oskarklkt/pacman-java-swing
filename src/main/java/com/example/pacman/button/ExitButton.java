package com.example.pacman.button;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ExitButton extends Button {
  private final JFrame parentWindow;

  public ExitButton(JFrame parentWindow) {
    super("Exit");
    this.parentWindow = parentWindow;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    parentWindow.dispose();
  }
}
