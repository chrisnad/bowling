package in.chris;

import java.util.List;

/**
 * The type Frame.
 */
public class Frame {

    private final List<Integer> rolls;
    private final int nextFrameRollNum;
    private final int firstTry;
    private int secondTry;

    /**
     * Instantiates a new Frame.
     *
     * @param rolls             the rolls
     * @param currentRollNumber the current roll number
     */
    public Frame(List<Integer> rolls, int currentRollNumber) {
        this.rolls = rolls;
        firstTry = rolls.get(currentRollNumber);
        if (!isStrike()) {
            secondTry = rolls.get(currentRollNumber+1);
            nextFrameRollNum = currentRollNumber+2;
        } else {
            nextFrameRollNum = currentRollNumber+1;
        }
    }

    /**
     * Points int.
     *
     * @return the int
     */
    public int points() {
        if (isStrike()) {
            return sumOfTries() + strikeBonus();
        }
        if (isSpare()) {
            return sumOfTries() + spareBonus();
        }
        return sumOfTries();
    }

    /**
     * Gets next frame roll num.
     *
     * @return the next frame roll num
     */
    public int getNextFrameRollNum() {
        return nextFrameRollNum;
    }

    private boolean isStrike() {
        return firstTry == 10;
    }

    private boolean isSpare() {
        return !isStrike() && firstTry + secondTry == 10;
    }

    private int strikeBonus() {
        return rolls.get(nextFrameRollNum) + rolls.get(nextFrameRollNum +1);
    }

    private int spareBonus() {
        return rolls.get(nextFrameRollNum);
    }

    private int sumOfTries() {
        return firstTry + secondTry;
    }

}
