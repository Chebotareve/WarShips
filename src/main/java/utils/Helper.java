package utils;

import java.util.Scanner;

public class Helper {
    public static String getUserInput(String prompt) {
        boolean success = false;
        String userInput = "";
        while (!success) {
            System.out.print(prompt);
            try {
                userInput = readInput();
                checkTheString(userInput);
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
        return reader.nextLine();
    }

    private static void checkTheString(String userInput) throws IncorrectInputException {
        if (userInput.isEmpty()) {
            throw new IncorrectInputException("You have to put some data here!");
        } else if (userInput.length() > 3) {
            throw new IncorrectInputException("Too many letters, put valid guess!");
        }
    }
}
