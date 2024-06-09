package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements Runnable {
    private volatile int score;
    private final JLabel scoreCounter;
    private volatile Boolean stop;
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
                increaseScore(1);
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
        score+=addition;
        updateScoreCounter();
    }

    public synchronized void updateScoreCounter() {
        scoreCounter.setText("Score: " + score);
    }

    public void stopScore() {
        stop = true;
    }
}