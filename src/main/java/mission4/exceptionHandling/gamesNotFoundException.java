package mission4.exceptionHandling;

public class gamesNotFoundException extends RuntimeException {
    public gamesNotFoundException(String id) {
        super("Game ID : " + id + " not found!");
    }

    public gamesNotFoundException() {
    }
}