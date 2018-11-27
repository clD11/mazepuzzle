package com.github.mazepuzzle.core.algorithm;

import com.github.mazepuzzle.core.Cell;
import com.github.mazepuzzle.core.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree {

    private static final Random random = new Random();

    public Grid execute(Grid grid) {
        List<Cell> neighbours;
        for (Cell cell : grid.allCells()) {

            neighbours = new ArrayList<>();

            if (cell.getNorth() != null) {
                neighbours.add(cell.getNorth());
            }

            if (cell.getEast() != null) {
                neighbours.add(cell.getEast());
            }

            if (!neighbours.isEmpty()) {
                Cell randomNeighbour = neighbours.get(random.nextInt(neighbours.size()));
                cell.linkCell(randomNeighbour);
            }

        }

        return grid;
    }

}