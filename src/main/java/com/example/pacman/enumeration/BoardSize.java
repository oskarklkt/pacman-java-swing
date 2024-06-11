package com.example.pacman.enumeration;

public enum BoardSize {
  VERY_SMALL("Very Small", 500, 500, "src/main/resources/images/16px"),
  SMALL("Small", 600, 600, "src/main/resources/images/16px"),
  MEDIUM("Medium", 800, 800, "src/main/resources/images/16px"),
  LARGE("Large", 1000, 1000, "src/main/resources/images/32px"),
  VERY_LARGE("Very Large", 1200, 1200, "src/main/resources/images/32px");

  private final String name;
  private final int width;
  private final int height;
  private final String photosUrl;

  BoardSize(String name, int width, int height, String photosUrl) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.photosUrl = photosUrl;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public String getPhotosUrl() {
    return photosUrl;
  }

  @Override
  public String toString() {
    return name;
  }
}
