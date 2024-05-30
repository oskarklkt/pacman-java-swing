package com.example.pacman.panel.util;

import com.example.pacman.enumeration.BoardSize;

import javax.swing.*;
import java.awt.*;
public class BoardGenerator {
    public static JPanel generateBoard(char[] board, int numberOfYBlocks, int numberOfXBlocks, BoardSize boardSize, Color wallsColor) {
        JPanel gridPanel = new JPanel(new GridLayout(numberOfYBlocks, numberOfXBlocks));

        for (int i = 0; i < numberOfYBlocks * numberOfXBlocks; i++) {

            JLabel label = new JLabel();
            label.setOpaque(true);

            switch (board[i]) {
                case 'W':
                    label.setBackground(wallsColor);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    break;
                case 'F':
                    label.setBackground(Color.BLACK);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setVerticalAlignment(JLabel.CENTER);
                    ImageIcon pizzaIcon = new ImageIcon(boardSize.getPhotosUrl() + "/food.png");
                    label.setIcon(pizzaIcon);
                    break;
                default:
                    label.setBackground(Color.BLACK);
                    break;
            }
            gridPanel.add(label);
        }

        return gridPanel;
    }
}
