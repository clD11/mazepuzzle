package com.github.mazepuzzle.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

class CellTest {

    private final Cell cell = new Cell(0, 0);

    @Test
    void shouldLinkCellBidirectional() {

    }

    @Test
    void shouldNotContainCell() {
        Cell linkedCell = mock(Cell.class);
        cell.linkCell(linkedCell);
        assertThat(cell.containsCell(linkedCell), is(true));
    }
}