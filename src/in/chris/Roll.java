package in.chris;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class
 */
public class Roll {

    private Roll(){}

    /**
     * Gets rolls from string.
     *
     * @param input the input
     * @return the rolls from string
     */
    public static List<Integer> getRollsFromString(String input) {
        List<Integer> rollsList = new ArrayList<>();
        int frameCount = 1;
        for (String frameStr : splitStringIntoFrames(input)) {
            try {
                rollsList.addAll(getFrameArray(frameStr, frameCount++));
            } catch (Exception e) {
                throw new IllegalArgumentException("Bad input: incorrect input on frame number " + (frameCount - 1));
            }
        }
        return rollsList;
    }

    /**
     * Get frames from rolls frame [ ].
     *
     * @param rolls the rolls
     * @return the frame [ ]
     */
    public static Frame[] getFramesFromRolls(List<Integer> rolls) {
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

    private static String[] splitStringIntoFrames(String input) {
        String[] inputArray = input.split(" ");
        if (inputArray.length != 10) {
            throw new IllegalArgumentException("Bad input: incorrect number of frames");
        }
        return input.toUpperCase().split(" ");
    }

    private static List<Integer> getFrameArray(String frameStr, int frameNum) {
        String[] frameStrArr = frameStr.replace("", " ").trim()
                .replace("X", "10")
                .replace("-", "0")
                .split(" ");
        int frameLength = frameStrArr.length;
        List<Integer> frameIntArr = new ArrayList<>();
        if (frameNum == 10) {
            frameIntArr.add(Integer.parseInt(frameStrArr[0]));
            if (frameIntArr.get(0) == 10 && frameLength == 3) {
                frameIntArr.add(Integer.parseInt(frameStrArr[1]));
                frameIntArr.add(Integer.parseInt(frameStrArr[2]));
            } else if ("/".equals(frameStrArr[1]) && frameLength == 3) {
                frameIntArr.add(10 - frameIntArr.get(0));
                frameIntArr.add(Integer.parseInt(frameStrArr[2]));
            } else if (frameLength == 2){
                frameIntArr.add(Integer.parseInt(frameStrArr[1]));
            } else {
                throw new IllegalArgumentException("Bad input: Illegal number of tries on frame number " + frameNum);
            }
        } else {
            if (frameLength > 2) {
                throw new IllegalArgumentException("Bad input: Illegal number of tries on frame number " + frameNum);
            }
            frameIntArr.add(Integer.parseInt(frameStrArr[0]));
            if (frameIntArr.get(0) != 10) {
                if ("/".equals(frameStrArr[1])) {
                    frameIntArr.add(10 - frameIntArr.get(0));
                } else {
                    frameIntArr.add(Integer.parseInt(frameStrArr[1]));
                }
            }
        }
        return frameIntArr;
    }

}
