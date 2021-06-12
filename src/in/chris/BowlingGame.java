package in.chris;

import java.util.Arrays;

public class BowlingGame {
    int[] rolls = new int[21];
    int currentRoll;

    public BowlingGame() {
    }

    public BowlingGame(int[] rolls) {
        this.rolls = rolls;
    }

    public int totalPoints() {
        return Arrays.stream(framesFromRolls()).mapToInt(Frame::points).sum();
    }

    public Frame getFrame(int frameNum) {
        return framesFromRolls()[frameNum-1];
    }

    public Frame[] framesFromRolls() {
        Frame[] framesArray = new Frame[10];
        int rollNum = 0;
        int frameNum = 0;
        while (frameNum<10) {
            framesArray[frameNum] = new Frame(rolls, rollNum);
            rollNum = framesArray[frameNum].getNextFrameRollNum();
            frameNum ++;
        }
        return framesArray;
    }

    public void roll(int knockedPins) {
        rolls[currentRoll++] = knockedPins;
    }

}
