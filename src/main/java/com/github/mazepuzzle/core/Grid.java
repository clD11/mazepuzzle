package com.github.mazepuzzle.core;

public class Grid {

    private final int rows;
    private final int columns;

    private Cell[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        prepareGrid();
        configureGrid();
    }

    protected void prepareGrid() {
        grid = new Cell[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    protected void configureGrid() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                grid[i][j].setNorth(findCell(i - 1, j));
                grid[i][j].setSouth(findCell(i + 1, j));
                grid[i][j].setWest(findCell(i, j - 1));
                grid[i][j].setEast(findCell(i, j + 1));
            }
        }
    }

    private Cell findCell(int row, int column) {
        if (row < 0 || row >= rows) {
            return null;
        }

        if (column < 0 || column >= columns) {
            return null;
        }

        return grid[row][column];
    }

    public int size() {
        return rows * columns;
    }
}
