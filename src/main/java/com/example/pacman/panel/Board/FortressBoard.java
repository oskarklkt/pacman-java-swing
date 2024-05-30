package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import java.awt.*;

public class FortressBoard extends Board {
  public FortressBoard(BoardSize boardSize) {
    super(boardSize, BoardType.FORTRESS);
  }
}
