package com.example.pacman.character;

import com.example.pacman.enumeration.Boost;
import com.example.pacman.panel.board.Board;
import com.example.pacman.panel.game.TimePanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Ghost extends JLabel implements Runnable {

    private static final List<Ghost> ghosts = new ArrayList<>();
    private static int sleepTime = 300;
    private final Board parent;
    private final char[][] board;
    private final int startX, startY;
    private final Random random = new Random();
    boolean isStopped;
    private int x, y;

    public Ghost(Board parent, int startX, int startY) {
        isStopped = false;
        this.parent = parent;
        this.board = parent.getBoard();
        this.x = startX;
        this.y = startY;
        this.startX = startX;
        this.startY = startY;
        ghosts.add(this);
        setBackground(Color.BLACK);
        setIcon(new ImageIcon(parent.getBoardSize().getPhotosUrl() + "/ghost/ghost.png"));
        startGhost();
    }

    public static Ghost getGhostByPosition(int x, int y) {
        return ghosts.stream().filter(g -> g.getX() == x && g.getY() == y).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public static int getSleepTime() {
        return sleepTime;
    }

    public static void setSleepTime(int sleepTime) {
        Ghost.sleepTime = sleepTime;
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
            if (board[newY][newX] == 'P') {
                if (!Boost.EDIBLE_GHOSTS.getTurnedOn()) {
                    parent.decreaseLives();
                    parent.restartMap();
                    Arrays.stream(Boost.values()).forEach(Boost::turnOff);
                } else {
                    resetCoordinates();
                    board[y][x] = 'E';
                    parent.addPoints(100);
                }
            } else {
                Random random = new Random();
                if (TimePanel.getSeconds() != 0 && TimePanel.getSeconds() % 20 == 0 && random.nextInt(4) == 0) {
                    int boostNumber = random.nextInt(5);
                    board[y][x] = Character.forDigit(boostNumber, 10);
                    Arrays.stream(Boost.values()).forEach(Boost::turnOff);
                } else {
                    char c = board[newY][newX];
                    if (c == 'G') c = 'F';
                    board[y][x] = c;
                }
                x = newX;
                y = newY;
                board[y][x] = 'G';
            }
        }
    }

    public void resetCoordinates() {
        synchronized (board) {
            board[y][x] = 'E'; // Mark current ghost position as empty
            this.x = startX;
            this.y = startY;
            board[y][x] = 'G'; // Reset ghost position on board
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Board getParent() {
        return parent;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public Random getRandom() {
        return random;
    }


}
