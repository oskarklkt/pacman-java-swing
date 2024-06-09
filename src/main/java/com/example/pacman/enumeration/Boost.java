package com.example.pacman.enumeration;

import java.util.Arrays;

public enum Boost {
    EDIBLE_GHOSTS('0', "/boost/edible.png"),
    DOUBLE_POINTS('1', "/boost/double.png"),
    SLOWER_GHOSTS('2', "/boost/slower.png"),
    FROZEN_GHOSTS('3', "/boost/frozen.png" ),
    ADDITIONAL_LIVE('4', "/boost/live.png");

    private final char sign;
    private final String pathToPng;
    private Boolean isTurnedOn;

    Boost(char sign, String pathToPng) {
        this.sign = sign;
        this.pathToPng = pathToPng;
        this.isTurnedOn = false;
    }

    public void turnOn(Boost boost) {
        for (Boost b : Boost.values()) {
            b.turnOff(b);
        }
        boost.isTurnedOn = true;
    }

    public void turnOff(Boost boost) {
        boost.isTurnedOn = false;
    }

    public static Boost getByChar(char c) {
        return Arrays.stream(values())
                .filter(b -> b.getSign() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Boost found for character: " + c));
    }

    public char getSign() {
        return sign;
    }

    public String getPathToPng() {
        return pathToPng;
    }

    public Boolean getTurnedOn() {
        return isTurnedOn;
    }
}
