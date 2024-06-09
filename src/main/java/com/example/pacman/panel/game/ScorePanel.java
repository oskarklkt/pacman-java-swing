package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements Runnable {
    private volatile int score;
    private final JLabel scoreCounter;
    private volatile Boolean stop;
    private static int multiplier = 1;
    public ScorePanel() {
        stop = false;
        score = 0;
        scoreCounter = new JLabel("Score: " + score);
        scoreCounter.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        add(scoreCounter);
        startScore();
    }

    @Override
    // every one second we get 1 point
    public void run() {
        while (!stop)
            try {
                Thread.sleep(1000);
                increaseScore(multiplier);
                updateScoreCounter();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    }

    private void startScore() {
        Thread score = new Thread(this);
        score.start();
    }

    public synchronized void increaseScore(int addition) {
        score+=(multiplier * addition);
        updateScoreCounter();
    }

    public synchronized void updateScoreCounter() {
        scoreCounter.setText("Score: " + score);
    }

    public void stopScore() {
        stop = true;
    }

    public void setMultiplier(int multiplier) {
        ScorePanel.multiplier = multiplier;
    }
}
