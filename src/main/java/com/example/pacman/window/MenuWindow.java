package com.example.pacman.window;

import com.example.pacman.button.ExitButton;
import com.example.pacman.button.HighScoresButton;
import com.example.pacman.button.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame {
    public MenuWindow() {
        LayoutManager layout = new GridLayout(3, 1);

        setTitle("Pacman Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(layout);
        setVisible(true);


        JButton newGameButton = new NewGameButton(this);
        JButton highScoresButton = new HighScoresButton();
        JButton exitButton = new ExitButton(this);


        add(newGameButton);
        add(highScoresButton);
        add(exitButton);
    }
}
