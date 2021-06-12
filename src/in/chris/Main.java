package in.chris;

public class Main {

    public static void main(String[] args) {
        int[] rolls = rollsFromInput(args[0]);
        if (rolls != null) {
            BowlingGame game = new BowlingGame(rolls);
            System.out.println("Total points: " + game.totalPoints());
            if (args[1] != null) {
                int frameNum = Integer.parseInt(args[1]);
                System.out.println("Frame " + frameNum + " points: " + game.getFrame(frameNum).points());
            }
        }
    }

    public static String[] validateInput(String input) {
        String[] inputArray = input.split(" ");
        if ((inputArray.length < 10 || inputArray.length > 12) ||
                (inputArray.length == 11 && !inputArray[9].endsWith("/")) ||
                (inputArray.length == 12 && !inputArray[9].endsWith("X")) ||
                (inputArray.length == 10 && (inputArray[9].endsWith("X") || inputArray[9].endsWith("/")))) {
            throw new IllegalArgumentException("Bad input: incorrect number of frames");
        }
        return inputArray;
    }

    private static int[] rollsFromInput(String input) {
        try {
            return rollsFromArray(input.replace(" ", "").split(""));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static int[] rollsFromArray(String[] str) {
        int[] rolls = new int[21];
        int length = str.length;
        for(int i = 0; i < length; i++) {
            if("X".equals(str[i])) {
                rolls[i] = 10;
            } else if("-".equals(str[i])) {
                rolls[i] = 0;
            } else if("/".equals(str[i])) {
                rolls[i] = 10-rolls[i-1];
            } else {
                rolls[i] = Integer.parseInt(str[i]);
            }
        }
        return rolls;
    }
}
