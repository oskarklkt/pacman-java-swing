package com.example.pacman.enumeration;

public enum Direction {
    UP("/pacman/pacman_up_open.png", "/pacman/pacman_up_closed.png", 0, -1),
    DOWN("/pacman/pacman_down_open.png", "/pacman/pacman_down_closed.png", 0, 1),
    LEFT("/pacman/pacman_left_open.png", "/pacman/pacman_left_closed.png", -1, 0),
    RIGHT("/pacman/pacman_right_open.png", "/pacman/pacman_right_closed.png", 1, 0);

    private final String openedPhotoPath;
    private final String closedPhotoPath;
    private final int deltaX;
    private final int deltaY;

    Direction(String openedPhotoPath, String closedPhotoPath, int deltaX, int deltaY) {
        this.openedPhotoPath = openedPhotoPath;
        this.closedPhotoPath = closedPhotoPath;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public String getOpenedPhotoPath() {
        return openedPhotoPath;
    }

    public String getClosedPhotoPath() {
        return closedPhotoPath;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
