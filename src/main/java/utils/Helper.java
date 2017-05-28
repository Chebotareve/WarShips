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
            } catch (IncorrectInputException ex) {
                ex.message();
                continue;
            }
            success = true;
        }
        return userInput;
    }

    private static String readInput() throws IncorrectInputException {
        Scanner reader = new Scanner(System.in);
        String tempInputString = reader.nextLine();
        if (tempInputString.isEmpty()) {
            throw new IncorrectInputException("You have to put some data here!");
        } else if (tempInputString.length()>3){
            throw new IncorrectInputException("Too many letters, put valid guess!");
        }
        return tempInputString;
    }
}
