package com.example.pacman.panel.board;

import com.example.pacman.character.Pacman;
import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.window.GameWindow;

import java.awt.*;

public class CastleBoard extends Board {

  public CastleBoard(BoardSize boardSize, GameWindow parent) {
    super(boardSize, BoardType.CASTLE, 15, 20, parent);
    setLayout(new BorderLayout());

    char[][] board = {
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'W', 'F', 'G', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'W', 'F', 'G', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'W', 'F', 'G', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'F', 'G', 'W'},
            {'W', 'F', 'W', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'W', 'W', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'W', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'W', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'F', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'F', 'W', 'P', 'F', 'F', 'F', 'W', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
    };
    startingBoard = new char[board.length][board[0].length];
    for (int y = 0; y < board.length; y++) {
      System.arraycopy(board[y], 0, startingBoard[y], 0, board[0].length);
    }
    setBoard(board);
    generate();
  }
}
