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

    public void addLink(Cell cell) {
        this.linkedCells.put(cell, true);
        if (!cell.hasLink(this)) {
            cell.addLink(this);
        }
    }

    public void removeLink(Cell cell) {
        this.linkedCells.remove(cell);
        if (cell.hasLink(this)) {
            cell.removeLink(this);
        }
    }

    public boolean hasLink(Cell cell) {
        return this.linkedCells.containsKey(cell);
    }

    public Set<Cell> allLinkedCells() {
        return unmodifiableSet(linkedCells.keySet());
    }

    public List<Cell> neighbours() {
        List<Cell> neighbours = new ArrayList<>();

        if (north != null) {
            neighbours.add(north);
        }

        if (south != null) {
            neighbours.add(south);
        }

        if (east != null) {
            neighbours.add(east);
        }

        if (west != null) {
            neighbours.add(west);
        }

        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && column == cell.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}