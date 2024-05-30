package com.example.pacman.enumeration;

public enum BoardSize {
  SMALL("Small", 400, 400, "src/main/resources/images/16px"),
  MEDIUM("Medium", 600, 600, "src/main/resources/images/16px"),
  LARGE("Large", 800, 800, "src/main/resources/images/32px");

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

  public String getName() {
    return name;
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
