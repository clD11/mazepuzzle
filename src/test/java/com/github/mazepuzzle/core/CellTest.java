package com.github.mazepuzzle.core;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

class CellTest {

    private final Random random = new Random();

    private final Cell cell = new Cell(random.nextInt(), random.nextInt());

    @Test
    void shouldReturnTrueWhenCellHasLink() {
        Cell expected = new Cell(random.nextInt(), random.nextInt());
        cell.addLink(expected);
        assertThat(cell.hasLink(expected), is(true));
    }

    @Test
    void shouldAddAndRemoveBidirectionalLink() {
        Cell expected = new Cell(random.nextInt(), random.nextInt());

        cell.addLink(expected);
        assertThat(cell.hasLink(expected), is(true));
        assertThat(expected.hasLink(cell), is(true));

        cell.removeLink(expected);
        assertThat(cell.hasLink(expected), is(false));
        assertThat(expected.hasLink(cell), is(false));
    }

    @Test
    void shouldReturnAllLinkedCells() {
        Set<Cell> expected = new HashSet<>();
        expected.add(mock(Cell.class));
        expected.add(mock(Cell.class));
        expected.add(mock(Cell.class));
        expected.add(mock(Cell.class));

        for (Cell cell : expected) {
            this.cell.addLink(cell);
        }

        Set<Cell> actual = cell.getAllLinks();

        assertThat(actual, is(expected));
    }

    @Test
    void shouldReturnAllNeighbours() {
        Cell north = mock(Cell.class);
        cell.setNorth(north);

        Cell south = mock(Cell.class);
        cell.setSouth(south);

        Cell east = mock(Cell.class);
        cell.setEast(east);

        Cell west = mock(Cell.class);
        cell.setWest(west);

        assertThat(cell.getNeighbours(), contains(north, south, east, west));
    }

    @Test
    void shouldNotReturnAnyNeighboursWhenNonSet() {
        assertThat(cell.getNeighbours(), is(empty()));
    }
}