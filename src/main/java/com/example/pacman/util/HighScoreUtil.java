package com.example.pacman.util;

import com.example.pacman.entity.HighScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighScoreUtil {

    private static final String PATH = "src/main/resources/highScores.txt";
    private static List<HighScore> highScores;


    public static void readHighScores() {
        List<HighScore> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                HighScore highScore = mapToHighScore(line);
                if (highScore != null) {
                    scores.add(highScore);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        highScores = scores;
    }


    private static void saveHighScores() {
        highScores.sort(Comparator.comparingInt(HighScore::getScore).reversed());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for (HighScore highScore : highScores) {
                writer.write(highScore.getNickname() + "," + highScore.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHighScore(String nickname, int score) {
        highScores.add(new HighScore(nickname, score));
        saveHighScores();
    }


    private static HighScore mapToHighScore(String line) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
            try {
                String nickname = parts[0];
                int score = Integer.parseInt(parts[1]);
                return new HighScore(nickname, score);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<HighScore> getHighScores() {
        return highScores;
    }
}
