package com.example.pacman.panel.game;


import com.example.pacman.font.TopPanelFont;

import javax.swing.*;

public class BoostPanel extends JPanel {
    private static JLabel boostLabel;

    public BoostPanel() {
        boostLabel = new JLabel();
        boostLabel.setText("Current Boost: None");
        boostLabel.setFont(new TopPanelFont());
        add(boostLabel);
    }


    public static void setBoostLabel(String label) {
        boostLabel.setText(label);
    }

}
