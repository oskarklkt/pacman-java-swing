package com.example.pacman.entity;

import java.io.Serializable;

public class HighScore implements Serializable {
    String nickname;
    int score;

    public HighScore(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return nickname + ": " + score;
    }
}
