package utils;

public class IncorrectInputException extends Exception {
    private String message;

    IncorrectInputException(String message) {
        this.message = message;
    }

    public void message() {
        System.out.println(message);
    }
}
