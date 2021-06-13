package in.chris;

import java.util.Arrays;
import java.util.List;

/**
 * The type Bowling game.
 */
public class BowlingGame {
    private Frame[] frames = new Frame[10];

    /**
     * Instantiates a new Bowling game.
     *
     * @param input the input
     */
    public BowlingGame(String input) {
        List<Integer> rolls = Roll.getRollsFromString(input);
        frames = Roll.getFramesFromRolls(rolls);
    }

    /**
     * Instantiates a new Bowling game.
     */
    public BowlingGame() {
    }

    /**
     * Run game.
     *
     * @param rolls the rolls
     */
    public void runGame(List<Integer> rolls) {
        frames = Roll.getFramesFromRolls(rolls);
    }

    /**
     * Total points int.
     *
     * @return the int
     */
    public int totalPoints() {
        return Arrays.stream(frames).mapToInt(Frame::points).sum();
    }

    /**
     * Gets frame.
     *
     * @param frameNum the frame num
     * @return the frame
     */
    public Frame getFrame(int frameNum) {
        return frames[frameNum-1];
    }

}
