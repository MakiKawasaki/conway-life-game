package com.github.makikawasaki.conwaylifegame;

import java.util.Random;

public class Game {
    private Cell[][] grid;

    public Game(int maxX, int maxY) {
        grid = new Cell[maxX][maxY];

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                Random random = new Random();
                grid[i][j] = new Cell(random.nextBoolean());
            }
        }
    }

    public void playRound() {
        calculateNextGrid();
        goNext();
    }

    public void calculateNextGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                setCellAliveNext(grid[i][j], i, j);
            }
        }

    }

    public void goNext() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.goNext();
            }
        }
    }

    private void setCellAliveNext(Cell cell, int x, int y) {
        int aliveNeighbours = countAliveNeighbours(x, y);
        cell.setAliveNext(aliveNeighbours);
    }

    private int countAliveNeighbours(int x, int y) {
        int maxX = grid.length - 1;
        int maxY = grid[0].length - 1;
        int count = 0;

        if (x > 0 && y > 0 && grid[x-1][y-1] != null) {
            if (grid[x-1][y-1].isAlive()) {
                count++;
            }
        }

        if (x > 0 && grid[x-1][y] != null) {
            if (grid[x-1][y].isAlive()) {
                count++;
            }
        }

        if (x > 0 && y < maxY && grid[x-1][y+1] != null) {
            if (grid[x-1][y+1].isAlive()) {
                count++;
            }
        }

        if (y < maxY && grid[x][y+1] != null) {
            if (grid[x][y+1].isAlive()) {
                count++;
            }
        }

        if (x < maxX && y < maxY && grid[x+1][y+1] != null) {
            if (grid[x+1][y+1].isAlive()) {
                count++;
            }
        }

        if (x < maxX && grid[x+1][y] != null) {
            if (grid[x+1][y].isAlive()) {
                count++;
            }
        }

        if (x < maxX && y > 0 && grid[x+1][y-1] != null) {
            if (grid[x+1][y-1].isAlive()) {
                count++;
            }
        }

        if (y > 0 && grid[x][y-1] != null) {
            if (grid[x][y-1].isAlive()) {
                count++;
            }
        }

        return count;
    }
}
