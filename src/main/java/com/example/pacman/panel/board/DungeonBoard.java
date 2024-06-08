package com.example.pacman.panel.board;

import com.example.pacman.character.Pacman;
import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.window.GameWindow;

import java.awt.*;

public class DungeonBoard extends Board {
  public DungeonBoard(BoardSize boardSize, GameWindow parent) {
    super(boardSize, BoardType.DUNGEON, 15, 30, parent);
    setLayout(new BorderLayout());

    char[][] board = {
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'G', 'F', 'F', 'F', 'W', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'W', 'F', 'F', 'W', 'W', 'F', 'F', 'W', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'W', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'G', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'P', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'G', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'W', 'W', 'F', 'F', 'F', 'F', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'F', 'F', 'G', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'W', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
    };
    startingBoard = new char[board.length][board[0].length];
    for (int y = 0; y < board.length; y++) {
      System.arraycopy(board[y], 0, startingBoard[y], 0, board[0].length);
    }
    setBoard(board);
    generate();

  }
}
