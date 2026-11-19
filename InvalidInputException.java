/** Thrown when a player's typed answer is empty or contains non-letters. */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
