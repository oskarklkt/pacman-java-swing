package com.example.pacman.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    private final JFrame parentWindow;
    public ExitButton(JFrame parentWindow) {
        super("Exit");
        setBackground(Color.RED);
        this.parentWindow = parentWindow;
        setForeground(Color.WHITE);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        parentWindow.dispose();
    }
}
