package com.example.pacman.character;

import com.example.pacman.panel.board.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghost extends JLabel implements Runnable {

    private final Board parent;
    private final char[][] board;
    private int x, y;
    private final int startX, startY;
    boolean isStopped;
    private static int sleepTime = 200;
    private final Random random = new Random();

    public Ghost(Board parent, int startX, int startY) {
        isStopped = false;
        this.parent = parent;
        this.board = parent.getBoard();
        this.x = startX;
        this.y = startY;
        this.startX = startX;
        this.startY = startY;
        setBackground(Color.BLACK);
        setIcon(new ImageIcon(parent.getBoardSize().getPhotosUrl() + "/ghost/ghost.png"));
        startGhost();
    }

    private void startGhost() {
        Thread ghost = new Thread(this);
        ghost.start();
    }

    @Override
    public void run() {
        while (!isStopped) {
            if (parent.getPacman() == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                run();
            }
            moveGhost();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveGhost() {
        int[][] possibleMoves = {
                {x + 1, y}, // right
                {x - 1, y}, // left
                {x, y + 1}, // down
                {x, y - 1}  // up
        };

        int[] moveOrder = random.ints(0, 4).distinct().limit(4).toArray();

        for (int i = 0; i < moveOrder.length; i++) {
            int[] move = possibleMoves[moveOrder[i]];
            int newX = move[0];
            int newY = move[1];
            if (canMove(newX, newY) && !isOccupiedByAnotherGhost(newX, newY)) {
                updatePosition(newX, newY);
                parent.requestRender();
                return;
            }
        }
    }

    private boolean canMove(int newX, int newY) {
        return newX >= 0 && newX < board[0].length &&
                newY >= 0 && newY < board.length &&
                board[newY][newX] != 'W';
    }

    private boolean isOccupiedByAnotherGhost(int newX, int newY) {
        return parent.getGhosts().stream()
                .anyMatch(ghost -> ghost != this && ghost.getX() == newX && ghost.getY() == newY);
    }

    private void updatePosition(int newX, int newY) {
        synchronized (board) {
            if (board[newY][newX] == 'P' || board[y][x] == 'P') {
                parent.decreaseLives();
                parent.restartMap();
            } else {
                char c = board[newY][newX];
                if (c == 'G') c = 'F';
                board[y][x] = c;
                x = newX;
                y = newY;
                board[y][x] = 'G';
            }
        }
    }

    public void resetCoordinates() {
        this.x = startX;
        this.y = startY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
