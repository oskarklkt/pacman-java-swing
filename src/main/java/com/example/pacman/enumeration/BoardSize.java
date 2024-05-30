package com.example.pacman.enumeration;

public enum BoardSize {
    SMALL("Small", 400, 400),
    MEDIUM("Medium", 600, 600),
    LARGE("Large", 800, 800);


    private final String name;
    private final int width;
    private final int height;

    BoardSize(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
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

    @Override
    public String toString() {
        return name;
    }
}
