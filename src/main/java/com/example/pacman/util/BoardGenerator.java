package com.example.pacman.util;

import com.example.pacman.character.Pacman;
import com.example.pacman.panel.Board;

import javax.swing.*;
import java.awt.*;

public class BoardGenerator {
    public static JPanel generateBoard(Board board, Color wallsColor) {
        JPanel gridPanel = new JPanel(new GridLayout(board.getNumberOfYBlocks(), board.getNumberOfXBlocks()));
        gridPanel.setFocusable(true); // Ensure the panel is focusable
        gridPanel.requestFocusInWindow(); // Request focus to receive key events

        for (int y = 0; y < board.getNumberOfYBlocks(); y++) {
            for (int x = 0; x < board.getNumberOfXBlocks(); x++) {
                JLabel label = new JLabel();
                label.setOpaque(true);

                switch (board.getBoard()[y][x]) {
                    case 'W':
                        label.setBackground(wallsColor);
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        break;
                    case 'F':
                        label.setBackground(Color.BLACK);
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setVerticalAlignment(JLabel.CENTER);
                        ImageIcon pizzaIcon = new ImageIcon(board.getBoardSize().getPhotosUrl() + "/food.png");
                        label.setIcon(pizzaIcon);
                        break;
                    case 'P':
                        Pacman pacman = new Pacman(board, x, y);
                        gridPanel.addKeyListener(pacman); // Register Pacman as a KeyListener
                        label.setLayout(new BorderLayout());
                        label.add(pacman, BorderLayout.CENTER);
                        label.setBackground(Color.BLACK);
                        break;
                    default:
                        label.setBackground(Color.BLACK);
                        break;
                }
                gridPanel.add(label);
            }
        }
        return gridPanel;
    }
}
