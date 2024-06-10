package com.example.pacman.enumeration;

import com.example.pacman.character.Ghost;
import com.example.pacman.panel.game.BoostPanel;
import com.example.pacman.panel.game.LivesPanel;
import com.example.pacman.panel.game.ScorePanel;

import java.util.Arrays;

public enum Boost {
    EDIBLE_GHOSTS("Ghost killer!", '0', "/boost/edible.png"),
    DOUBLE_POINTS("2x Points!",'1', "/boost/double.png"),
    SLOWER_GHOSTS("Slower Ghosts!", '2', "/boost/slower.png"),
    FROZEN_GHOSTS("Frozen ghosts!", '3', "/boost/frozen.png" ),
    ADDITIONAL_LIVE("Additional live!",'4', "/boost/live.png");

    private final String name;
    private final char sign;
    private final String pathToPng;
    private Boolean isTurnedOn;

    Boost(String name, char sign, String pathToPng) {
        this.name = name;
        this.sign = sign;
        this.pathToPng = pathToPng;
        this.isTurnedOn = false;
    }

    public static Boost getByChar(char c) {
        return Arrays.stream(values())
                .filter(b -> b.getSign() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Boost found for character: " + c));
    }

    public void turnOn() {
        for (Boost b : Boost.values()) {
            b.turnOff();
        }
        isTurnedOn = true;

        if (this.equals(DOUBLE_POINTS)) {
            ScorePanel.setMultiplier(2);
        }

        if (this.equals(SLOWER_GHOSTS)) {
            Ghost.setSleepTime(500);
        }

        if (this.equals(FROZEN_GHOSTS)) {
            Ghost.setSleepTime(2000);
        }

        if (this.equals(ADDITIONAL_LIVE)) {
            LivesPanel.addLive();
        }

        BoostPanel.setBoostLabel("Current Boost: " + this.getName());
    }

  public void turnOff() {
        this.isTurnedOn = false;

        if (this.equals(DOUBLE_POINTS)) {
          ScorePanel.setMultiplier(1);
        }

        if (this.equals(SLOWER_GHOSTS)) {
          Ghost.setSleepTime(300);
        }

      if (this.equals(FROZEN_GHOSTS)) {
          Ghost.setSleepTime(300);
      }

      BoostPanel.setBoostLabel("Current Boost: None");

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

    public String getName() {
        return name;
    }
}
