/** A spelling word with a clue and a difficulty level (1 = easy, 3 = hard). */
public class Word {
    private final String text;
    private final String definition;
    private final int difficulty;

    public Word(String text, String definition, int difficulty) {
        this.text = text;
        this.definition = definition;
        this.difficulty = difficulty;
    }

    public String getText() { return text; }
    public String getDefinition() { return definition; }
    public int getDifficulty() { return difficulty; }

    public boolean isCorrect(String attempt) {
        return attempt != null && text.equalsIgnoreCase(attempt.trim());
    }
}
