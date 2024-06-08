package com.example.pacman.window;

import com.example.pacman.button.ExitButton;
import com.example.pacman.button.HighScoresButton;
import com.example.pacman.button.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame {
  public MenuWindow() {

    setTitle("Pacman Game");
    setIconImage(new ImageIcon("src/main/resources/images/16px/ghost/ghost.png").getImage());
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(3, 1));
    setVisible(true);

    JButton newGameButton = new NewGameButton(this);
    JButton highScoresButton = new HighScoresButton();
    JButton exitButton = new ExitButton(this);

    add(newGameButton);
    add(highScoresButton);
    add(exitButton);
  }
}
