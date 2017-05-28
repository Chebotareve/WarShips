package utils;

import java.util.Scanner;

public class Helper {
    public static String getUserInput(String prompt) {
        boolean loopTrigger = false;
        String userInput = "";
        while (!loopTrigger) {
            System.out.print(prompt);
            try {
                userInput = readInput();
            } catch (IncorrectInputException ex) {
                ex.message();
                continue;
            }
            loopTrigger = true;
        }
        return userInput;
    }

    private static String readInput() throws IncorrectInputException {
        String tempInputString = "";
        Scanner reader = new Scanner(System.in);
        tempInputString = reader.nextLine();
        if (tempInputString.isEmpty()) {
            throw new IncorrectInputException("You have to put some data here!");
        }
        return tempInputString;
    }
}
