package com.example.pacman.panel.game;

import javax.swing.*;

public class TopPanel extends JPanel {
  private final ScorePanel scorePanel;
    private final LivesPanel livesPanel;

    public TopPanel() {
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    scorePanel = new ScorePanel();
    TimePanel timePanel = new TimePanel();
    livesPanel = new LivesPanel();
    BoostPanel boostPanel = new BoostPanel();
    add(scorePanel);
    add(timePanel);
    add(livesPanel);
    add(boostPanel);
  }

  public void increaseScore(int points) {
    scorePanel.increaseScore(points);
  }

  public void decreaseLives() {
    livesPanel.decreaseLives();
  }
}
