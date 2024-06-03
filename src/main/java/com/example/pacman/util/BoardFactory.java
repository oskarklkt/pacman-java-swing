package com.example.pacman.util;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.BoardType;
import com.example.pacman.panel.*;

public class BoardFactory {
  public static Board createBoard(BoardSize size, BoardType type) {
    return switch (type) {
      case LABYRINTH -> new LabyrinthBoard(size);
      case FORTRESS -> new FortressBoard(size);
      case DUNGEON -> new DungeonBoard(size);
      case CASTLE -> new CastleBoard(size);
      default -> new ClassicBoard(size);
    };
  }
}
