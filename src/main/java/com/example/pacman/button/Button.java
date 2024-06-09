package com.example.pacman.button;

import javax.swing.*;
import java.awt.*;

public abstract class Button extends JButton {
  public Button(String text) {
    super(text);
    setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
    setBackground(Color.BLUE);
    setForeground(Color.WHITE);
  }
}
