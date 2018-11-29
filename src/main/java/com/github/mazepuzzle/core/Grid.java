package com.github.mazepuzzle.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public void markCell(int row, int column) {
        Cell cell = findCell(row, column);
        if (cell != null) {
            cell.mark();
        }
    }

    public boolean canMove(int[] currentPosition, int[] nextPosition) {
        Cell currentCell = findCell(currentPosition[0], currentPosition[1]);
        Cell nextCell = findCell(nextPosition[0], nextPosition[1]);
        return currentCell.hasLink(nextCell);
    }

    public Cell findCell(int row, int column) {
        if (row < 0 || row >= rows) {
            return null;
        }

        if (column < 0 || column >= columns) {
            return null;
        }

        return grid[row][column];
    }

    public Set<Cell> allCells() {
        Set<Cell> cells = new HashSet<>();
        for (int i = 0; i < rows; ++i) {
            cells.addAll(Arrays.asList(grid[i])
                    .subList(0, columns));
        }
        return cells;
    }

    public int size() {
        return rows * columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n+");

        for (int column = 0; column < columns; ++column) {
            sb.append("---+");
        }

        sb.append("\n");

        for (int row = 0; row < rows; ++row) {

            StringBuilder top = new StringBuilder();
            top.append("|");

            StringBuilder bottom = new StringBuilder();
            bottom.append("+");

            for (int column = 0; column < columns; ++column) {
                Cell cell = grid[row][column];

                String marked = " * ";

                String eastBoundary = cell.hasLink(cell.getEast()) ? " " : "|";
                top.append( ((cell.isMarked()) ? marked : "   ") + eastBoundary);

                String southBoundary = cell.hasLink(cell.getSouth()) ? "   " : "---";
                bottom.append(southBoundary + "+");
            }

            sb.append(top.toString() + "\n");
            sb.append(bottom.toString() + "\n");
        }

        return sb.toString();
    }
}
