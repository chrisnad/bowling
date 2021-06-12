package in.chris;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTests {

    @Test
    public void test1() {
        BowlingGame game = new BowlingGame("x x x x x x x x x x x x");
        assertEquals(300, game.totalPoints());
    }

    @Test
    public void test2() {
        BowlingGame game = new BowlingGame("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        assertEquals(150, game.totalPoints());
    }
}
