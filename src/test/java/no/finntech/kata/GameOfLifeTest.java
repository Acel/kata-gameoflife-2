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
    public void numberOfNeighbours() {
        game.setAlive(0,0);
        assertEquals(1, game.numberOfNeighbours(0, 1));

        game.setAlive(1,0);
        assertEquals(2, game.numberOfNeighbours(0,1));

        game.setAlive(2, 0);
        assertEquals(3, game.numberOfNeighbours(1, 1));

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
    public void twoOrThreeNeighborsSurvivesToNextGeneration() {
        String expectedValue =
            "01000\n" +
            "10000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n";
        game.setAlive(0,0);
        game.setAlive(1,0);
        game.setAlive(0,1);
        game.nextGeneration();
        assertEquals(expectedValue, game.getBoard());

        expectedValue =
            "11000\n" +
            "11000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n";

        game.setAlive(0,0);
        game.setAlive(1,1);
        game.nextGeneration();
        assertEquals(expectedValue, game.getBoard());
    }

    @Ignore
    public void runTheGame() {
        game.setAlive(0,0);
        game.nextGeneration();
        assertEquals(0, game.numberOfNeighbours(0,1));

        System.out.println(game.getBoard());

        game.setAlive(0,0);
        game.setAlive(1, 0);
        game.nextGeneration();
        assertEquals(0, game.numberOfNeighbours(0, 1));

        System.out.println(game.getBoard());

        game.setAlive(0,0);
        game.setAlive(1, 0);
        game.setAlive(2, 0);
        game.nextGeneration();
        assertEquals(3, game.numberOfNeighbours(1, 1));

        System.out.println(game.getBoard());

    }
}
