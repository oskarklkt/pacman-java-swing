package com.example.pacman.panel.board;

import com.example.pacman.character.Pacman;
import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.window.GameWindow;

import java.awt.*;

public class LabyrinthBoard extends Board {

    public LabyrinthBoard(BoardSize boardSize, GameWindow parent) {
    super(boardSize, BoardType.LABYRINTH, 20, 15, parent);
    setLayout(new BorderLayout());

        char[][] board = {
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'G', 'F', 'G', 'F', 'F', 'G', 'F', 'F', 'G', 'W'},
                {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
                {'W', 'F', 'F', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'W', 'F', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'F', 'F', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W'},
                {'W', 'F', 'W', 'F', 'F', 'W', 'F', 'W', 'W', 'W', 'W', 'F', 'W', 'F', 'W'},
                {'W', 'F', 'W', 'W', 'W', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'W', 'W', 'F', 'W'},
                {'W', 'F', 'W', 'W', 'W', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'F', 'W', 'W', 'W', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'P', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };
        setBoard(board);
        generate();
  }
}
