package com.example.pacman.enumeration;

public enum BoardType {
  CLASSIC("Classic"),
  LABYRINTH("Labyrinth"),
  FORTRESS("Fortress"),
  DUNGEON("Dungeon"),
  CASTLE("Castle");

  private final String name;

  BoardType(String label) {
    this.name = label;
  }

  @Override
  public String toString() {
    return name;
  }
}
