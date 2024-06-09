package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements Runnable {
    private static int multiplier = 1;
    private final JLabel scoreCounter;
    private static volatile int score;
    private static volatile Boolean stop;
    public ScorePanel() {
        stop = false;
        score = 0;
        scoreCounter = new JLabel("Score: " + score);
        scoreCounter.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        add(scoreCounter);
        startScore();
    }

    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        ScorePanel.multiplier = multiplier;
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

    public static void stopScore() {
        stop = true;
    }


    public JLabel getScoreCounter() {
        return scoreCounter;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        ScorePanel.score = score;
    }

    public static Boolean getStop() {
        return stop;
    }

    public static void setStop(Boolean stop) {
        ScorePanel.stop = stop;
    }
}
