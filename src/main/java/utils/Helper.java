package utils;

import java.util.List;
import java.util.Scanner;

public class Helper {
    public static String getUserInput(String prompt, List<String> successfulGuesses) {
        boolean success = false;
        String userInput = "";
        while (!success) {
            System.out.print(prompt);
            try {
                userInput = readInput();
                checkTheString(userInput, successfulGuesses);
            } catch (IncorrectInputException ex) {
                ex.message();
                continue;
            }
            success = true;
        }
        return userInput;
    }

    private static String readInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine().toLowerCase();
    }

    private static void checkTheString(String userInput, List<String> successfulGuesses) throws IncorrectInputException {
        if (userInput.isEmpty()) {
            throw new IncorrectInputException("You have to put some data here!");
        }
        if (userInput.length() > 3) {
            throw new IncorrectInputException("Too many letters, put valid guess!");
        }
        if (successfulGuesses.contains(userInput)){
            throw new IncorrectInputException("You've already hit something here, try another spot!");
        }
    }
}
