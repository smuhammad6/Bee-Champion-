import java.util.ArrayList;
import java.util.Collections;

/** Holds the words in an ArrayList and deals them out by difficulty without repeats. */
public class WordBank {
    private final ArrayList<Word> all = new ArrayList<>();
    private final ArrayList<Word> pool = new ArrayList<>();

    public WordBank() {
        // Level 1
        add("balloon", "A colorful rubber bag filled with air or gas", 1);
        add("library", "A place where books are kept for borrowing", 1);
        add("whisper", "To speak very softly", 1);
        add("kitchen", "The room where food is cooked", 1);
        add("blanket", "A soft covering used for warmth on a bed", 1);
        add("journey", "A long trip from one place to another", 1);
        add("pillow", "A cushion for your head when you sleep", 1);
        add("rainbow", "An arc of colors seen after rain", 1);
        // Level 2
        add("necessary", "Needed; required", 2);
        add("rhythm", "A repeating pattern of beats in music", 2);
        add("separate", "To divide or keep apart", 2);
        add("beautiful", "Pleasing to look at", 2);
        add("exercise", "Physical activity done to stay healthy", 2);
        add("temperature", "How hot or cold something is", 2);
        add("embarrass", "To make someone feel awkward or ashamed", 2);
        add("calendar", "A chart showing the days, weeks, and months of a year", 2);
        // Level 3
        add("conscientious", "Careful and thorough about doing what is right", 3);
        add("surveillance", "Close observation of a person or place", 3);
        add("pharaoh", "A ruler of ancient Egypt", 3);
        add("silhouette", "A dark outline of a shape against a light background", 3);
        add("bureaucracy", "A system of government run by many officials and rules", 3);
        add("onomatopoeia", "A word that imitates a sound, like 'buzz'", 3);
        add("quarantine", "A period of isolation to stop disease from spreading", 3);
        add("entrepreneur", "A person who starts a business", 3);
    }

    private void add(String text, String def, int level) {
        all.add(new Word(text, def, level));
    }

    /** Returns a random word of the given difficulty, refilling the pool when it runs out. */
    public Word draw(int level) {
        for (int attempt = 0; attempt < 2; attempt++) {
            ArrayList<Word> matches = new ArrayList<>();
            for (Word w : pool) {
                if (w.getDifficulty() == level) matches.add(w);
            }
            if (!matches.isEmpty()) {
                Collections.shuffle(matches);
                Word chosen = matches.get(0);
                pool.remove(chosen);
                return chosen;
            }
            pool.addAll(all); // refill and try again
        }
        throw new IllegalStateException("No words for level " + level);
    }
}
