package com.example.pacman.util;

import com.example.pacman.character.Ghost;
import com.example.pacman.character.Pacman;
import com.example.pacman.enumeration.Boost;
import com.example.pacman.panel.board.Board;

import javax.swing.*;
import java.awt.*;

public class BoardGenerator {
  public static JPanel generateBoard(Board board) {
    JPanel gridPanel =
        new JPanel(new GridLayout(board.getNumberOfYBlocks(), board.getNumberOfXBlocks()));
    gridPanel.setFocusable(true);
    gridPanel.requestFocusInWindow();

    for (int y = 0; y < board.getNumberOfYBlocks(); y++) {
      for (int x = 0; x < board.getNumberOfXBlocks(); x++) {
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (board.getBoard()[y][x]) {
          case 'W':
            label.setBackground(Color.BLUE);
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
            Pacman pacman;
            if (board.getPacman() == null) {
              pacman = new Pacman(board, x, y);
              board.setPacman(pacman);
            } else {
              pacman = board.getPacman();
            }
            gridPanel.addKeyListener(pacman);
            label.setLayout(new BorderLayout());
            label.add(pacman, BorderLayout.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBackground(Color.BLACK);
            break;
          case 'G':
            if (board.getGhosts().size() < 5) {
              Ghost ghost = new Ghost(board, x, y);
              board.getGhosts().add(ghost);
              label.setLayout(new BorderLayout());
              label.add(ghost);
              label.setHorizontalAlignment(JLabel.CENTER);
              label.setVerticalAlignment(JLabel.CENTER);
              label.setBackground(Color.BLACK);
            } else {
              label.setLayout(new BorderLayout());
              label.setIcon(
                  new ImageIcon(board.getBoardSize().getPhotosUrl() + "/ghost/ghost.png"));
              label.setBackground(Color.BLACK);
            }
            break;
          case '0', '1', '2', '3', '4':
            label.setBackground(Color.BLACK);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            ImageIcon icon =
                new ImageIcon(
                    board.getBoardSize().getPhotosUrl()
                        + Boost.getByChar(board.getBoard()[y][x]).getPathToPng());
            label.setIcon(icon);
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
