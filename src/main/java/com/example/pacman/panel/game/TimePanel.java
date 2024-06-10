package com.example.pacman.panel.game;

import com.example.pacman.font.TopPanelFont;

import javax.swing.*;

public class TimePanel extends JPanel implements Runnable {
    private static int seconds;
    private final JLabel timer;

    private static Boolean stop = false;

    public TimePanel () {
        timer = new JLabel("Time: 00:00");
        timer.setFont(new TopPanelFont());
        add(timer);
        startTimer();
    }

    public static int getSeconds() {
        return seconds;
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
}
