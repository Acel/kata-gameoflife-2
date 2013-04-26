package no.finntech.kata;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public final class GameOfLifeTest {
    @Test
     public void should_get_a_grid_with_expected_dimensions() {
        GameOfLife gol = new GameOfLife(20, 20);
        assertThat(gol).isNot(null);
    }
}
