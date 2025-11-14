package com.github.makikawasaki.conwaylifegame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CellTest {

    // cell with 3 alive neighbours should be alive
    @Test
    public void cellWith3AliveNeighboursTest() {
        Cell aliveCell = new Cell(true);
        aliveCell.setAliveNext(3);
        aliveCell.goNext();
        Assertions.assertTrue(aliveCell.isAlive());

        Cell deadCell = new Cell(false);
        deadCell.setAliveNext(3);
        deadCell.goNext();
        Assertions.assertTrue(deadCell.isAlive());
    }

    // alive cell with 2 alive neighbours should stay alive
    @Test
    public void aliveCellWith2AliveNeighboursTest() {
        Cell cell = new Cell(true);
        cell.setAliveNext(2);
        cell.goNext();
        Assertions.assertTrue(cell.isAlive());

    }

    // dead cell should stay dead
    @Test
    public void deadCellStaysDeadTest() {
        Cell cell = new Cell(false);
        cell.setAliveNext(0);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(1);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(2);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(4);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(5);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(6);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(7);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell.setAliveNext(8);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());
    }

    // alive cell should die
    @Test
    public void aliveCellShouldDieTest() {
        Cell cell = new Cell(true);
        cell.setAliveNext(0);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(1);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(4);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(5);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(6);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(7);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());

        cell = new Cell(true);
        cell.setAliveNext(8);
        cell.goNext();
        Assertions.assertFalse(cell.isAlive());
    }
}
