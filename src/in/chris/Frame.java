package in.chris;

public class Frame {

    private final int[] rolls;
    private final int nextFrameRollNum;
    private final int firstTry;
    private int secondTry;

    public Frame(int[] rolls, int currentRollNumber) {
        this.rolls = rolls;
        firstTry = rolls[currentRollNumber];
        if (!isStrike()) {
            secondTry = rolls[currentRollNumber+1];
            nextFrameRollNum = currentRollNumber+2;
        } else {
            nextFrameRollNum = currentRollNumber+1;
        }
    }

    public int points() {
        if (isStrike()) {
            return sumOfTries() + strikeBonus();
        }
        if (isSpare()) {
            return sumOfTries() + spareBonus();
        }
        return sumOfTries();
    }

    public int getNextFrameRollNum() {
        return nextFrameRollNum;
    }

    public int[] validateFrame(String[] tries) {

        return null;
    }

    private boolean isStrike() {
        return firstTry == 10;
    }

    private boolean isSpare() {
        return !isStrike() && firstTry + secondTry == 10;
    }

    private int strikeBonus() {
        return rolls[nextFrameRollNum] + rolls[nextFrameRollNum +1];
    }

    private int spareBonus() {
        return rolls[nextFrameRollNum];
    }

    private int sumOfTries() {
        return firstTry + secondTry;
    }

}
