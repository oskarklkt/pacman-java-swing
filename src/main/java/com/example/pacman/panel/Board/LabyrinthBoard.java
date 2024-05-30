package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import java.awt.*;

public class LabyrinthBoard extends Board {

    public LabyrinthBoard(BoardSize boardSize) {
        super(boardSize, BoardType.LABYRINTH);
    }
}
