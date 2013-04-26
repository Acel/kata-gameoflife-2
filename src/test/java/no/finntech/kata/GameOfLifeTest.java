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
     public void shouldGetAGridWithExpectedDimensions() {
        assertNotNull(game);
    }

    @Test
    public void addOneLiveCell() {
        String expectedValue =
            "10000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n";

        game.setAlive(0,0);
        assertEquals(expectedValue, game.getBoard());

    }

    @Test
    public void fewerThanTwoNeighboursDies() {
        String expectedValue =
            "00000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n";

        game.setAlive(0,0);
        game.nextGeneration();
        assertEquals(expectedValue, game.getBoard());

    }

    @Test
    public void numberOfNeigors() {
        assertEquals(3, game.numberOfNeigors(0,0));
        assertEquals(3, game.numberOfNeigors(4,4));
        assertEquals(5, game.numberOfNeigors(1,0));
        assertEquals(3, game.numberOfNeigors(0,0));

    }
}
