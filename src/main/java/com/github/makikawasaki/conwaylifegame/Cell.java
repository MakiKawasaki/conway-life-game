package com.github.makikawasaki.conwaylifegame;

public class Cell {

    private boolean alive;
    private Boolean aliveNext;

    public Cell(boolean alive) {
        this.alive = alive;
        aliveNext = null;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAliveNext(int aliveNeighbours) {
        if (aliveNeighbours == 3) {
            aliveNext = true;
        } else if (alive == true && aliveNeighbours == 2) {
            aliveNext = true;
        } else {
            aliveNext = false;
        }
    }

    public void goNext() {
        if (aliveNext != null) {
            alive = aliveNext;
        }

        aliveNext = null;
    }
}
