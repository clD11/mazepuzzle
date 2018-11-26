package com.github.mazepuzzle.core;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    private final int row;
    private final int column;
    private final Map<Cell, Boolean> linkedCells;

    public Cell(int column, int row) {
        this.row = row;
        this.column = column;
        this.linkedCells = new HashMap<>();
    }

    public void linkCell(Cell cell) {
        this.linkedCells.put(cell, true);
        if (!cell.containsCell(this)) {
            cell.linkCell(this);
        }
    }

    public void unlinkCell(Cell cell) {
        this.linkedCells.remove(cell);
    }

    public boolean containsCell(Cell cell) {
        return this.linkedCells.containsKey(cell);
    }

    // add equals and hash so remove works
}
