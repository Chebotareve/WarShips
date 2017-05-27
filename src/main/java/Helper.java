import java.util.Scanner;

public class Helper {
    public String getUserInput(String prompt) {
        boolean loopTrigger = false;
        String tempInputString = "";
        Scanner reader = new Scanner(System.in);
        while (loopTrigger == false) {
            System.out.print(prompt);
            tempInputString = reader.nextLine();
            if (tempInputString.isEmpty()) {
                System.out.println("You have to put some data here!");
                continue;
            } else
                loopTrigger = true;
        }
        return tempInputString;
    }
}
