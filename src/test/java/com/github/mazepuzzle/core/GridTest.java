package com.github.mazepuzzle.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GridTest {

    private final Grid grid = new Grid(6, 6);

    @Test
    void shouldCreateGrid() {
        grid.prepareGrid();
        assertThat(true, is(true));
    }

}