package com.github.mazepuzzle.core;

import java.util.*;

import static java.util.Collections.unmodifiableSet;

public class Cell {

    private final int row;
    private final int column;
    private final Map<Cell, Boolean> linkedCells;

    private Cell north;
    private Cell south;
    private Cell east;
    private Cell west;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.linkedCells = new HashMap<>();
    }

    public Cell getNorth() {
        return north;
    }

    public void setNorth(Cell north) {
        this.north = north;
    }

    public Cell getSouth() {
        return south;
    }

    public void setSouth(Cell south) {
        this.south = south;
    }

    public Cell getEast() {
        return east;
    }

    public void setEast(Cell east) {
        this.east = east;
    }

    public Cell getWest() {
        return west;
    }

    public void setWest(Cell west) {
        this.west = west;
    }

    public void linkCell(Cell cell) {
        this.linkedCells.put(cell, true);
        if (!cell.containsCell(this)) {
            cell.linkCell(this);
        }
    }

    public void unlinkCell(Cell cell) {
        this.linkedCells.remove(cell);
        if (cell.containsCell(this)) {
            cell.unlinkCell(this);
        }
    }

    public boolean containsCell(Cell cell) {
        return this.linkedCells.containsKey(cell);
    }

    public Set<Cell> cells() {
        return unmodifiableSet(linkedCells.keySet());
    }

    public List<Cell> neighbours() {
        List<Cell> neighbours = new ArrayList<>();

        if (north != null) {
            neighbours.add(north);
        }

        if (south != null) {
            neighbours.add(north);
        }

        if (east != null) {
            neighbours.add(north);
        }

        if (west != null) {
            neighbours.add(north);
        }

        return neighbours;
    }

    // TODO add equals and hash so remove works
}
