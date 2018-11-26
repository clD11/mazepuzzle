package com.github.mazepuzzle.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CellTest {

    private final Cell cell = new Cell(0, 0);

    @Test
    void shouldLinkCellBidirectional() {
        Cell linkedCell = new Cell(1, 1);
        cell.linkCell(linkedCell);
        assertThat(cell.containsCell(linkedCell), is(true));
        assertThat(linkedCell.containsCell(cell), is(true));
    }

    @Test
    void shouldNotLinkCellWhenAlreadyLinked() {
        Cell linkedCell = mock(Cell.class);
        when(linkedCell.containsCell(cell)).thenReturn(true);
        cell.linkCell(linkedCell);
        verify(linkedCell, never()).linkCell(cell);
    }

    @Test
    void shouldNotHaveLinkedCell() {
        Cell linkedCell = mock(Cell.class);
        assertThat(cell.containsCell(linkedCell), is(false));
    }

    // TODO finish test
}