package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.util.BoardGenerator;
import java.awt.*;

public class ClassicBoard extends Board {
  public ClassicBoard(BoardSize boardSize) {
    super(boardSize, BoardType.CLASSIC);
    setLayout(new BorderLayout());

    int numberOfYBlocks = 15;
    int numberOfXBlocks = 15;

    char[] board = {
      WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL,
      WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, FOOD, WALL, WALL, FOOD, WALL, WALL, FOOD, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, FOOD, WALL, WALL, WALL, WALL, WALL, FOOD, WALL, WALL, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, FOOD, FOOD, FOOD, WALL, WALL, WALL, WALL, WALL, FOOD, FOOD, FOOD, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL,
      WALL, FOOD, WALL, WALL, WALL, FOOD, WALL, WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL,
      WALL, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, WALL, FOOD, FOOD, WALL, FOOD, FOOD, FOOD, WALL,
      WALL, FOOD, WALL, WALL, WALL, WALL, FOOD, WALL, FOOD, WALL, WALL, WALL, WALL, FOOD, WALL,
      WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL,
      WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL
    };
    add(
        BoardGenerator.generateBoard(
            board, numberOfYBlocks, numberOfXBlocks, boardSize, Color.BLUE),
        BorderLayout.CENTER);
  }
}
