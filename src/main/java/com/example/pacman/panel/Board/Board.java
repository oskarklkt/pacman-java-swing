package com.example.pacman.panel.Board;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;

import javax.swing.*;
import java.awt.*;

public abstract class Board extends JPanel {
    BoardType boardType;
    BoardSize boardSize;

    public Board(BoardSize boardSize, BoardType boardType) {
        this.boardSize = boardSize;
        this.boardType = boardType;
        setPreferredSize(new Dimension(boardSize.getWidth(), boardSize.getHeight()));
        setLayout(new BorderLayout());
    }
}
