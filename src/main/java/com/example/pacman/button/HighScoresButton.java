package com.example.pacman.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoresButton extends JButton implements ActionListener {
    public HighScoresButton(){
        super("High Scores");
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
