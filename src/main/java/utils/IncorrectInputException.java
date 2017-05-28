package utils;

public class IncorrectInputException extends Exception {
    private String message;

    IncorrectInputException(String message) {
        this.message = message;
    }

    void message() {
        System.out.println(message);
    }
}
