package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.util.BoardGenerator;

import java.awt.*;

public class LabyrinthBoard extends Board {

    public LabyrinthBoard(BoardSize boardSize) {
    super(boardSize, BoardType.LABYRINTH, 20, 15);
    setLayout(new BorderLayout());

        char[] board = {
                WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL,
                FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, WALL, FOOD,
                FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, WALL, FOOD, WALL,
                FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, WALL, FOOD, WALL, FOOD,
                FOOD, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, FOOD, WALL, WALL, WALL, WALL, WALL, FOOD,
                WALL, WALL, WALL, WALL, FOOD, WALL, WALL, WALL, FOOD, WALL, WALL, FOOD, FOOD, FOOD, WALL, FOOD,
                FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL,
                FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD,
                FOOD, FOOD, WALL, FOOD, FOOD, FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL,
                FOOD, FOOD, FOOD, WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, FOOD,
                WALL, FOOD, WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL,
                FOOD, WALL, FOOD, WALL, WALL, FOOD, FOOD, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, FOOD,
                WALL, FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, FOOD,
                FOOD, WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD,
                WALL, WALL, FOOD, WALL, FOOD, WALL, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL,
                WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, WALL, WALL,
                FOOD, WALL, FOOD, WALL, FOOD, WALL, FOOD, FOOD, FOOD, WALL, FOOD, WALL, FOOD, WALL, WALL, FOOD,
                FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, FOOD, WALL, WALL, WALL, WALL,
                WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL
        };
        add(
        BoardGenerator.generateBoard(
                board, getNumberOfYBlocks(), getNumberOfXBlocks(), boardSize, Color.GREEN),
        BorderLayout.CENTER);
  }
}
