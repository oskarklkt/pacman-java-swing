package com.example.pacman.util;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.board.*;
import com.example.pacman.window.GameWindow;

public class BoardFactory {
  public static Board createBoard(BoardSize size, BoardType type, GameWindow parent) {
    return switch (type) {
      case LABYRINTH -> new LabyrinthBoard(size, parent);
      case FORTRESS -> new FortressBoard(size, parent);
      case DUNGEON -> new DungeonBoard(size, parent);
      case CASTLE -> new CastleBoard(size, parent);
      default -> new ClassicBoard(size, parent);
    };
  }
}
