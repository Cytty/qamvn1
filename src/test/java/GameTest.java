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
        int[] speed = {-1, 0, 10};
        Game.trafficGreenLight = true;
        int expected = 0;
        int actual = Game.moves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void movesShouldCountNegativeRed() {
        int[] speed = {-1, 0, 10};
        Game.trafficGreenLight = false;
        int expected = 2;
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

    @Test
    public void playerMovesShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int expected = 2;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int expected = 0;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesShouldCountNegativeRed() {
        int[] speed = {-7, 5, 6, 10};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int expected = 2;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesShouldCountNegativeGreen() {
        int[] speed = {-7, 5, 6, 10};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int expected = 0;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesShouldJobNegativeMaxSpeedRed() {
        int[] speed = {7, 5, 6, 10};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int expected = 2;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {7, 5, 6, 10};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int expected = 0;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int expected = 2;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerMovesNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int expected = 0;
        int actual = Game.playerMoves(speed);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {7, 2_147_483_647};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldCountNegativeRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {10, -7};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldCountNegativeGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldJobNegativeMaxSpeedRed() {
        int[] speed = {0, 5, 10, 4, 13, 7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {10, 13, 7};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {0, 5, 10, 4, 13, 7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {7, -7};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerLosersNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {7, -5, 6, -7, 0, 5, -6};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {};
        int[] actual = Game.playerLosers(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldJobBigNumberRed() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {5, 6};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldJobBigNumberGreen() {
        int[] speed = {7, 5, 6, 2_147_483_647};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {7, 5, 6, 2_147_483_647};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldCountNegativeRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = 6;
        int[] expected = {0, 5, 4, -3};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldCountNegativeGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = 6;
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldJobNegativeMaxSpeedRed() {
        int[] speed = {0, 5, 10, 4, 3, 7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 4, 3};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersShouldJobNegativeMaxSpeedGreen() {
        int[] speed = {0, 5, 10, 4, 3, 7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 10, 4, 3, 7};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersNegativeMaxSpeedAndNegativeSpeedRed() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = false;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 4, -3};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void playerWinnersNegativeMaxSpeedAndNegativeSpeedGreen() {
        int[] speed = {0, 5, 10, 4, -3, -7};
        Game.trafficGreenLight = true;
        Game.maxSpeed = -6;
        int[] expected = {0, 5, 10, 4, -3, -7};
        int[] actual = Game.playerWinners(speed);
        Assertions.assertArrayEquals(expected, actual);
    }

}
