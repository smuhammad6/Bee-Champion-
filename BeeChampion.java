import java.util.ArrayList;
import java.util.Scanner;

public class BeeChampion {
    private static final String[] AI_NAMES = {"Ava", "Ben", "Chloe", "Dev", "Emma"};
    private static final double[] AI_SKILLS = {0.97, 0.93, 0.88, 0.82, 0.75};

    private final ArrayList<Player> players = new ArrayList<>();
    private final WordBank bank = new WordBank();

    public static void main(String[] args) {
        new BeeChampion().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("          BEE CHAMPION");
        System.out.println("=====================================");

        System.out.print("Enter your name: ");
        String name = in.hasNextLine() ? in.nextLine().trim() : "";
        if (name.isEmpty()) name = "Player";

        int opponents = askOpponents(in);
        players.add(new HumanPlayer(name, in));
        for (int i = 0; i < opponents; i++) {
            players.add(new AIPlayer(AI_NAMES[i], AI_SKILLS[i]));
        }

        System.out.println("\nThe bee begins with " + players.size() + " spellers. Good luck!");
        playBee();
    }

    private int askOpponents(Scanner in) {
        while (true) {
            try {
                System.out.print("How many AI opponents (1-" + AI_NAMES.length + ")? ");
                int n = Integer.parseInt(in.nextLine().trim());
                if (n < 1 || n > AI_NAMES.length) {
                    System.out.println("Pick a number between 1 and " + AI_NAMES.length + ".");
                } else {
                    return n;
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a number. Try again.");
            } catch (java.util.NoSuchElementException e) {
                return 3; // no input available; use a default
            }
        }
    }

    private void playBee() {
        int round = 1;
        while (players.size() > 1) {
            int level = Math.min(3, (round + 1) / 2); // rounds 1-2 easy, 3-4 medium, 5+ hard
            System.out.println("\n--- Round " + round + " (difficulty " + level + "/3) ---");

            ArrayList<Player> missed = new ArrayList<>();
            for (Player p : players) {
                Word word = bank.draw(level);
                System.out.println("\n" + p.getName() + "'s turn:");
                String attempt = p.spell(word);
                if (p instanceof AIPlayer) {
                    System.out.println("   " + p.getName() + " spells: " + attempt);
                }
                if (word.isCorrect(attempt)) {
                    p.addPoint();
                    System.out.println("   Correct!");
                } else {
                    System.out.println("   Incorrect. The word was \"" + word.getText() + "\".");
                    missed.add(p);
                }
            }

            if (missed.size() == players.size()) {
                System.out.println("\nEveryone missed, so nobody is eliminated this round.");
            } else {
                for (Player p : missed) {
                    p.eliminate();
                    players.remove(p);
                    System.out.println("\n" + p.getName() + " has been eliminated!");
                }
            }
            round++;
        }

        Player winner = players.get(0);
        System.out.println("\n=====================================");
        System.out.println(winner.getName() + " is the Bee Champion with "
                + winner.getScore() + " correct words!");
        System.out.println("=====================================");
    }
}
