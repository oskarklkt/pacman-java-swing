package com.example.pacman.window;

import com.example.pacman.entity.HighScore;
import com.example.pacman.util.HighScoreUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoresWindow extends JFrame {
  public HighScoresWindow() {
    List<HighScore> highScores = new ArrayList<>();
    HighScoreUtil.readHighScores();
    highScores.addAll(HighScoreUtil.getHighScores());


    JLabel titleLabel = new JLabel("HIGHSCORES", SwingConstants.CENTER);
    titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setBackground(Color.BLUE);
    titleLabel.setOpaque(true);


    JList<String> jList =
        new JList<>(highScores.stream().map(HighScore::toString).toArray(String[]::new));
    jList.setBackground(Color.BLUE);
    jList.setForeground(Color.WHITE);
    jList.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

    JScrollPane jScrollPane = new JScrollPane(jList);


    setLayout(new BorderLayout());
    add(titleLabel, BorderLayout.NORTH);
    add(jScrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setSize(400, 600);
  }
}