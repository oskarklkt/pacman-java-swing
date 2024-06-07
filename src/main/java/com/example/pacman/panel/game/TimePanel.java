package com.example.pacman.panel.game;

import javax.swing.*;
import java.awt.*;

public class TimePanel extends JPanel implements Runnable {
    private int seconds;
    private final JLabel timer;

    private Boolean stop = false;

    public TimePanel () {
        timer = new JLabel("Time: 00:00");
        timer.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        add(timer);
        startTimer();
    }
    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(1000);
                increaseSeconds();
                updateTimer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    private void startTimer() {
        Thread timer = new Thread(this);
        timer.start();
    }

    private void updateTimer() {
        timer.setText(String.format("Time: %02d:%02d", seconds/60 , seconds%60));
    }

    private synchronized void increaseSeconds() {
        seconds++;
    }

    public void stopTimer() {
        stop = true;
    }
}
