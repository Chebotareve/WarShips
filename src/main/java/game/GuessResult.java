package game;

public enum GuessResult {
    HIT("hit!"),
    MISS("miss"),
    KILL("kill");

    private String message;

    GuessResult(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
