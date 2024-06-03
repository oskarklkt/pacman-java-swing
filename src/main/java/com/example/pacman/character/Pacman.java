package com.example.pacman.character;

import com.example.pacman.enumeration.BoardSize;
import com.example.pacman.enumeration.Direction;
import com.example.pacman.panel.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends JLabel implements KeyListener, Runnable {

    private final BoardSize boardSize;
    private Direction currentDirection;
    private boolean isMouthOpened;
    private boolean isAnimationStopped;
    private char[][] board;
    private final Board parent;
    private int x, y;

    public Pacman(Board parent, int startX, int startY) {
        this.boardSize = parent.getBoardSize();
        this.parent = parent;
        this.board = parent.getBoard();
        this.x = startX;
        this.y = startY;

        this.setBackground(Color.BLACK);
        currentDirection = Direction.RIGHT;
        isMouthOpened = true;
        isAnimationStopped = false;
        setIcon(new ImageIcon(boardSize.getPhotosUrl() + currentDirection.getOpenedPhotoPath()));

        // Centering Pacman within the JLabel
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);

        Thread animation = new Thread(this);
        animation.start();
    }

    @Override
    public void run() {
        while (!isAnimationStopped) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isMouthOpened = !isMouthOpened;
            updateImage();
        }
    }

    private void updateImage() {
        String imagePath = boardSize.getPhotosUrl() + (isMouthOpened ? currentDirection.getOpenedPhotoPath() : currentDirection.getClosedPhotoPath());
        setIcon(new ImageIcon(imagePath));
    }

    public void stopAnimation() {
        isAnimationStopped = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int newX = x, newY = y;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentDirection = Direction.UP;
                newY--;
                break;
            case KeyEvent.VK_DOWN:
                currentDirection = Direction.DOWN;
                newY++;
                break;
            case KeyEvent.VK_LEFT:
                currentDirection = Direction.LEFT;
                newX--;
                break;
            case KeyEvent.VK_RIGHT:
                currentDirection = Direction.RIGHT;
                newX++;
                break;
        }
        System.out.println("Trying to move Pacman to (" + newX + ", " + newY + ")"); // Debug statement
        if (newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length && board[newY][newX] != 'W') {
            if (board[newY][newX] == 'F') {
                board[newY][newX] = 'E';
            }
            board[y][x] = 'E';  // Clear the current position
            parent.updateCell(x, y);  // Update the old cell
            x = newX;
            y = newY;
            board[y][x] = 'P';  // Update Pacman's new position
            parent.updateCell(newX, newY); // Update the new cell
            parent.movePacman(this, newX, newY); // Move Pacman to the new cell on the board
            System.out.println("Moved Pacman to (" + x + ", " + y + ")"); // Debug statement
        }
        updateImage(); // Ensure image updates on direction change
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public int getPacmanX() {
        return x;
    }

    public int getPacmanY() {
        return y;
    }
}