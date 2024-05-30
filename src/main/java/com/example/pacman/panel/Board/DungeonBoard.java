package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import java.awt.*;

public class DungeonBoard extends Board {

    public DungeonBoard(BoardSize boardSize) {
        super(boardSize, BoardType.DUNGEON);
    }
}
