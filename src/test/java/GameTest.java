import my.first.code.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void movesShouldJobBigNumberRed() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = false;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldJobBigNumberGreen() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = true;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesNoShouldCountNull() {
        int[] speed = {0, 0, 0};
        Game.trafficGreenLight = true;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeGreen() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = true;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeRed() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = false;
        int expected = 2;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesDiffSizeArraysRed() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = false;
        int expected = 6;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesDiffSizeArraysGreen() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = true;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void losersShouldJobBigNumberRed() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = false;
        int[] expected = {1, 2_147_483_647};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void losersShouldJobBigNumberGreen() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = true;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void losersNoShouldCountNull() {
        int[] speed = {0, 0, 0};
        Game.trafficGreenLight = false;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void losersShouldCountNegativeRed() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = false;
        int[] expected = {-1, 5};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersShouldCountNegativeGreen() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = true;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersDiffSizeArraysGreen() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = true;
        int[] expected = {};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void losersDiffSizeArraysRed() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = false;
        int[] expected = {1, 5, 10, 67, 29, 53};
        int[] actual = Game.losers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberRed() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = false;
        int[] expected = {0};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldJobBigNumberGreen() {
        int[] speed = {1, 0, 2_147_483_647};
        Game.trafficGreenLight = true;
        int[] expected = {1, 0, 2_147_483_647};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNullGreen() {
        int[] speed = {0, 0, 0};
        Game.trafficGreenLight = true;
        int[] expected = {0, 0, 0};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNullRed() {
        int[] speed = {0, 0, 0};
        Game.trafficGreenLight = false;
        int[] expected = {0, 0, 0};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeRed() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = false;
        int[] expected = {0};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersShouldCountNegativeGreen() {
        int[] speed = {-1, 0, 5};
        Game.trafficGreenLight = true;
        int[] expected = {-1, 0, 5};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersDiffSizeArraysRed() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = false;
        int[] expected = {0, 0, 0, 0};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void winnersDiffSizeArraysGreen() {
        int[] speed = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        Game.trafficGreenLight = true;
        int[] expected = {1, 0, 5, 10, 0, 0, 67, 0, 29, 53};
        int[] actual = Game.winners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }
}
