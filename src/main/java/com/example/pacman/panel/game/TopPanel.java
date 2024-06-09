package com.example.pacman.panel.game;

import javax.swing.*;

public class TopPanel extends JPanel {
  private final ScorePanel scorePanel;
  private final TimePanel timePanel;
  private final LivesPanel livesPanel;

  public TopPanel() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    scorePanel = new ScorePanel();
    timePanel = new TimePanel();
    livesPanel = new LivesPanel();
    add(scorePanel);
    add(timePanel);
    add(livesPanel);
  }

  public void increaseScore(int points) {
    scorePanel.increaseScore(points);
  }

  public void decreaseLives() {
    livesPanel.decreaseLives();
  }
}
