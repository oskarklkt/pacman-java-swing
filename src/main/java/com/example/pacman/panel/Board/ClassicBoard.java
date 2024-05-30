package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import javax.swing.*;
import java.awt.*;

public class ClassicBoard extends Board {
    public ClassicBoard(BoardSize boardSize) {
            super(boardSize, BoardType.CLASSIC);
            setLayout(new BorderLayout());


            JPanel gridPanel = new JPanel(new GridLayout(31, 28));
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 28; j++) {
                    JLabel label = new JLabel();
                    label.setOpaque(true);
                    if (i % 2 == 0 && j % 2 == 0) {
                        label.setBackground(Color.BLACK);
                    } else {
                        label.setBackground(Color.YELLOW);
                    }
                    gridPanel.add(label);
                }
            }

            add(gridPanel, BorderLayout.CENTER);
        }
}

