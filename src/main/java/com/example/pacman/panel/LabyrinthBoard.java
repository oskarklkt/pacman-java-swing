package com.example.pacman.panel;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.util.BoardGenerator;

import java.awt.*;

public class LabyrinthBoard extends Board {

    public LabyrinthBoard(BoardSize boardSize) {
    super(boardSize, BoardType.LABYRINTH, 20, 15);
    setLayout(new BorderLayout());

        char[][] board = {
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'W', 'F', 'F', 'F', 'F', 'F'},
                {'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'F', 'W', 'W', 'W', 'W', 'W'},
                {'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'F'},
                {'F', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'W', 'W', 'W', 'W', 'W', 'F', 'W', 'F', 'W', 'F'},
                {'W', 'W', 'W', 'W', 'F', 'W', 'W', 'W', 'F', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'W', 'W'},
                {'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'W', 'W', 'F', 'W'},
                {'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'F', 'W'},
                {'F', 'F', 'W', 'F', 'F', 'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'F'},
                {'F', 'F', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'F'},
                {'W', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'W'},
                {'F', 'W', 'F', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'F', 'W'},
                {'W', 'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'W', 'W', 'W', 'W'},
                {'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'F'},
                {'W', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'W', 'W', 'W'}
        };
        setBoard(board);
        generate();
  }
}
