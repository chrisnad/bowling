package in.chris;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTests {

    private BowlingGame game;

    void rollMany(int n, int knockedPins, BowlingGame game) {
        for (int i = 0; i < n; i++) game.roll(knockedPins);
    }

    @Before
    public void setUp() {
        this.game = new BowlingGame();
    }

    @Test
    public void testZero() {
        rollMany(20, 0, game);
        assertEquals(0, game.totalPoints());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1, game);
        assertEquals(20, game.totalPoints());
    }

    @Test
    public void testOneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0, game);
        assertEquals(16, game.totalPoints());
    }

    @Test
    public void testOneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0, game);
        assertEquals(24, game.totalPoints());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10, game);
        assertEquals(300, game.totalPoints());
    }
}
