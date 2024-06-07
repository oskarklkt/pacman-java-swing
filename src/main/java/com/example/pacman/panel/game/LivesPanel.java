package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class LivesPanel extends JPanel {
    private int lives;

    public LivesPanel() {
        lives = 3;
        JLabel livesLabel = new JLabel(getLivesLabel());
        livesLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        add(livesLabel);
    }

    private String getLivesLabel() {
        return lives == 3 ? "❤ ❤ ❤" : lives == 2 ? "❤ ❤" : lives == 1 ? "❤" : "Dead";
    }

    public void decreaseLives() {
        if (lives > 0) {
            lives--;
        } else {
            //TODO game over logic
        }
    }

}
