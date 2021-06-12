package in.chris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingGame {
    private List<Integer> rolls;
    private Frame[] frames = new Frame[10];

    public BowlingGame(String input) {
        initRollsList(input.toUpperCase());
        initFramesArr();
    }

    public int totalPoints() {
        return Arrays.stream(frames).mapToInt(Frame::points).sum();
    }

    public Frame getFrame(int frameNum) {
        return frames[frameNum-1];
    }

    private void initFramesArr() {
        Frame[] framesArray = new Frame[10];
        int rollNum = 0;
        int frameNum = 0;
        while (frameNum<10) {
            framesArray[frameNum] = new Frame(rolls, rollNum);
            rollNum = framesArray[frameNum].getNextFrameRollNum();
            frameNum ++;
        }
        frames = framesArray;
    }

    private void initRollsList(String input) {
        List<Integer> rollsList = new ArrayList<>();
        int frameCount = 1;
        for (String frameStr : framesArrFromInput(input)) {
            for (int i : frameArr(frameStr, frameCount++)) {
                rollsList.add(i);
            }
        }
        this.rolls = rollsList;
    }

    private String[] framesArrFromInput(String input) {
        String[] inputArray = input.split(" ");
        if ((inputArray.length < 10 || inputArray.length > 12) ||
                (inputArray.length == 11 && !inputArray[9].endsWith("/")) ||
                (inputArray.length == 12 && !inputArray[9].endsWith("X")) ||
                (inputArray.length == 10 && (inputArray[9].endsWith("X") || inputArray[9].endsWith("/")))) {
            throw new IllegalArgumentException("Bad input: incorrect number of tries");
        }
        return inputArray;
    }

    private int[] frameArr(String frameStr, int frameNum) {
        String[] frameStrArr = frameStr.replace("-", "0").split("");
        if (frameNum == 10) {

        }
        int length = frameStrArr.length;
        if (length > 2) {
            throw new IllegalArgumentException("Bad input: frame number " + frameNum + " has an incorrect number of tries");
        }
        if ("X".equals(frameStrArr[0])) {
            int[] frameIntArr = new int[1];
            frameIntArr[0] = 10;
            return frameIntArr;
        } else {
            int[] frameIntArr = new int[2];
            frameIntArr[0] = Integer.parseInt(frameStrArr[0]);
            if ("/".equals(frameStrArr[1])) {
                frameIntArr[1] = 10 - frameIntArr[0];
            } else {
                frameIntArr[1] = Integer.parseInt(frameStrArr[0]);
            }
            return frameIntArr;
        }
    }

}
