package no.finntech.kata;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.table.TableStringConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.fest.assertions.Assertions.assertThat;


public final class GameOfLifeTest {

    private GameOfLife game;

    @Before
    public void init() {
        game = new GameOfLife(5, 5);
    }

    @Test
     public void should_get_a_grid_with_expected_dimensions() {
        assertNotNull(game);
    }

    @Test
    public void addOneLiveCell() {
        String expectedValue =  "10000\n" +
                                "00000\n" +
                                "00000\n" +
                                "00000\n" +
                                "00000\n" +

        game.setAlive(0,0);
        assertEquals(expectedValue, game.getBoard());

    }

    @Ignore
    public void fewerThanTwoNeighboursDies() {
        game.setAlive(0,0);

    }
}
