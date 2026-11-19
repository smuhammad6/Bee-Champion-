import java.util.NoSuchElementException;
import java.util.Scanner;

/** The person at the keyboard. Invalid input is caught and re-prompted instead of crashing. */
public class HumanPlayer extends Player {
    private final Scanner in;

    public HumanPlayer(String name, Scanner in) {
        super(name);
        this.in = in;
    }

    @Override
    public String spell(Word word) {
        System.out.println("   Your word: " + word.getText().charAt(0) + "..."
                + "  (" + word.getText().length() + " letters)");
        System.out.println("   Definition: " + word.getDefinition());
        while (true) {
            try {
                System.out.print("   Spell it, " + getName() + ": ");
                return validate(in.nextLine());
            } catch (InvalidInputException e) {
                System.out.println("   " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("   No input detected. Counting that as a miss.");
                return "";
            }
        }
    }

    private String validate(String raw) throws InvalidInputException {
        String answer = raw.trim();
        if (answer.isEmpty()) {
            throw new InvalidInputException("Please type an answer.");
        }
        if (!answer.matches("[A-Za-z]+")) {
            throw new InvalidInputException("Letters only, please (no spaces, numbers, or symbols).");
        }
        return answer;
    }
}
