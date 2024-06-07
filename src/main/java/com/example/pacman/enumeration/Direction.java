package com.example.pacman.enumeration;

public enum Direction {
    UP("/pacman/pacman_up_open.png", "/pacman/pacman_left_closed.png"),
    DOWN("/pacman/pacman_down_open.png", "/pacman/pacman_down_closed.png"),
    LEFT("/pacman/pacman_left_open.png", "/pacman/pacman_left_closed.png"),
    RIGHT("/pacman/pacman_right_open.png", "/pacman/pacman_right_closed.png");

    private final String openedPhotoPath;
    private final String closedPhotoPath;

    Direction(String openedPhotoPath, String closedPhotoPath) {
        this.openedPhotoPath = openedPhotoPath;
        this.closedPhotoPath = closedPhotoPath;
    }

    public String getOpenedPhotoPath() {
        return openedPhotoPath;
    }

    public String getClosedPhotoPath() {
        return closedPhotoPath;
    }
}
