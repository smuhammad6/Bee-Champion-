import java.util.Random;

/** Computer opponent. Higher skill means fewer mistakes; harder words trip it up more. */
public class AIPlayer extends Player {
    private final double skill; // base chance (0-1) of spelling an easy word correctly
    private final Random random = new Random();

    public AIPlayer(String name, double skill) {
        super(name);
        this.skill = skill;
    }

    @Override
    public String spell(Word word) {
        double chance = skill - (word.getDifficulty() - 1) * 0.12;
        if (random.nextDouble() < chance) {
            return word.getText();
        }
        return misspell(word.getText());
    }

    private String misspell(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = random.nextInt(s.length() - 1);
        switch (random.nextInt(3)) {
            case 0: // swap two neighboring letters
                char t = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(i + 1));
                sb.setCharAt(i + 1, t);
                break;
            case 1: // double a letter
                sb.insert(i, sb.charAt(i));
                break;
            default: // drop a letter
                sb.deleteCharAt(i);
        }
        // Guarantee the result is actually wrong (e.g. swapping "ll" changes nothing).
        return sb.toString().equalsIgnoreCase(s) ? s.substring(1) : sb.toString();
    }
}
