package com.example.pacman.panel.game;

import javax.swing.*;

public class TopPanel extends JPanel {
    private ScorePanel scorePanel;
    private TimePanel timePanel;
    private LivesPanel livesPanel;
    public TopPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        scorePanel = new ScorePanel();
        timePanel = new TimePanel();
        livesPanel = new LivesPanel();
        add(scorePanel);
        add(timePanel);
        add(livesPanel);
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public TimePanel getTimePanel() {
        return timePanel;
    }

    public LivesPanel getLivesPanel() {
        return livesPanel;
    }

    public void increaseScore(int points) {
        scorePanel.increaseScore(points);
    }
}
