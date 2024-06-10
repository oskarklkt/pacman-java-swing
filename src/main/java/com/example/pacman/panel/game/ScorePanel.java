package com.example.pacman.panel.game;

import com.example.pacman.font.TopPanelFont;

import javax.swing.*;

public class ScorePanel extends JPanel implements Runnable {
    private static int multiplier = 1;
    private final JLabel scoreCounter;
    private static volatile int score;
    private static volatile Boolean stop;
    public ScorePanel() {
        stop = false;
        score = 0;
        scoreCounter = new JLabel("Score: " + score);
        scoreCounter.setFont(new TopPanelFont());
        add(scoreCounter);
        startScore();
    }

    public static void setMultiplier(int multiplier) {
        ScorePanel.multiplier = multiplier;
    }

    @Override
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
        score+=(multiplier * addition);
        updateScoreCounter();
    }

    public synchronized void updateScoreCounter() {
        scoreCounter.setText("Score: " + score);
    }

    public static void stopScore() {
        stop = true;
    }

    public static int getScore() {
        return score;
    }
}
