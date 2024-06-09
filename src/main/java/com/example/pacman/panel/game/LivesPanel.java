package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class LivesPanel extends JPanel {
    private static int lives;
    private static JLabel livesLabel;

    public LivesPanel() {
        lives = 3;
        livesLabel = new JLabel(getLivesLabel());
        livesLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(livesLabel);
    }

    private static String getLivesLabel() {
        return lives == 3 ? "❤ ❤ ❤" : lives == 2 ? "❤ ❤" : lives == 1 ? "❤" : "Dead";
    }

    private static void updateLabel() {
        livesLabel.setText(getLivesLabel());
    }

    public static void addLive() {
        if (lives < 3) {
            lives++;
            updateLabel();
        }
    }

    public void decreaseLives() {
        if (lives > 0) {
            lives--;
            updateLabel();
        }
    }
}
