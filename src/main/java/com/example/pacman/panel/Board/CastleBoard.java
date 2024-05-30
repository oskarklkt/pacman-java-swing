package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import java.awt.*;

public class CastleBoard extends Board {

    public CastleBoard(BoardSize boardSize) {
        super(boardSize, BoardType.CASTLE);
    }
}
