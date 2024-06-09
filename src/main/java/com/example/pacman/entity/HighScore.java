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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return nickname + ": " + score;
    }
}
