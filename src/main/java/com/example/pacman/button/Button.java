package com.example.pacman.button;

import com.example.pacman.font.ButtonFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Button extends JButton implements ActionListener {
  public Button(String text) {
    super(text);
    setFont(new ButtonFont());
    setBackground(Color.BLUE);
    setForeground(Color.WHITE);
    addActionListener(this);
  }
}
