package in.chris;

public class Main {

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame(args[0]);
        System.out.println("Total points: " + game.totalPoints());
        if (args.length > 1) {
            int frameNum = Integer.parseInt(args[1]);
            System.out.println("Frame number " + frameNum + " points: " + game.getFrame(frameNum).points());
        }
    }
}
