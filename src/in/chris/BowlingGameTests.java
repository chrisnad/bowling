package in.chris;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BowlingGameTests {

    private BowlingGame game;

    @Before
    public void init() {
        game = new BowlingGame();
    }

    @Test
    public void test1() {
        game.runGame(Roll.getRollsFromString("x x x x x x x x x xxx"));
        assertEquals(300, game.totalPoints());
    }

    @Test
    public void test2() {
        game.runGame(Roll.getRollsFromString("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
        assertEquals(150, game.totalPoints());
    }

    @Test
    public void test3() {
        game.runGame(Roll.getRollsFromString("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
        assertEquals(90, game.totalPoints());
    }

    @Test
    public void test4() {
        game.runGame(Arrays.asList(1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6));
        assertEquals(133, game.totalPoints());
    }

    // non passants

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        game.runGame(Roll.getRollsFromString("/- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        game.runGame(Roll.getRollsFromString("9- 9- 9- 9- 9- 9- 9- 9- 9- 9- 99"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        game.runGame(Roll.getRollsFromString("9 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() {
        game.runGame(Roll.getRollsFromString("x x x x x x x x x x"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test9() {
        game.runGame(Roll.getRollsFromString("x x x x x x x x x x x"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test10() {
        game.runGame(Roll.getRollsFromString("x x x x x x x x x /1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test11() {
        game.runGame(Roll.getRollsFromString("x x x x x x x x x 123"));
    }
}
