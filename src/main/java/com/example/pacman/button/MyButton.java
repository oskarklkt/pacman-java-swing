package com.example.pacman.button;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
}
