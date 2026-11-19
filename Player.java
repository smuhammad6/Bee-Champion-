/** Base class for every competitor. Subclasses decide how a spelling attempt is produced. */
public abstract class Player {
    private final String name;
    private boolean eliminated;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    /** Polymorphic turn: each player type spells in its own way. */
    public abstract String spell(Word word);

    public String getName() { return name; }
    public boolean isEliminated() { return eliminated; }
    public int getScore() { return score; }

    public void eliminate() { eliminated = true; }
    public void addPoint() { score++; }
}
