package com.example.pacman.button;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.Board.Board;
import com.example.pacman.panel.BoardFactory;
import com.example.pacman.window.MenuWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JButton implements ActionListener {
    private final JFrame parentWindow;
    public NewGameButton(JFrame parentWindow) {
        super("New Game");
        setBackground(Color.BLUE);
        this.parentWindow = parentWindow;
        setForeground(Color.WHITE);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BoardSize[] sizeOptions = BoardSize.values();
        BoardSize boardSize = (BoardSize) JOptionPane.showInputDialog(parentWindow, "Select Board Size:",
                "Board Size", JOptionPane.QUESTION_MESSAGE, null, sizeOptions, sizeOptions[0]);

        if (boardSize != null) {
            BoardType[] boardOptions = BoardType.values();
            BoardType boardType = (BoardType) JOptionPane.showInputDialog(parentWindow, "Select Board Type:",
                    "Board Type", JOptionPane.QUESTION_MESSAGE, null, boardOptions, boardOptions[0]);

            if (boardType != null) {
                parentWindow.dispose();
                JFrame gameWindow = new JFrame("Pacman Game");
                gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel board = BoardFactory.createBoard(boardSize, boardType);
                gameWindow.add(board);
                gameWindow.pack();


                gameWindow.setLocationRelativeTo(null);
                gameWindow.setVisible(true);

                gameWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        SwingUtilities.invokeLater(MenuWindow::new);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(parentWindow, "Please, choose a board type.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(parentWindow, "Please, choose a size.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
