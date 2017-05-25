import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GameHelper
{
    Scanner reader = new Scanner(System.in);
    static Random rand = new Random();
    static private ArrayList<String> boundCells = new ArrayList<>();
    private String tempInputString;
    private boolean loopTrigger;
    static int columnNumber;
    static int rowNumber;


    public String getUserInput(String prompt)
    {
        loopTrigger = false;
        while (loopTrigger == false)
        {
            System.out.print(prompt);
            tempInputString = reader.nextLine();
            if (tempInputString.isEmpty())
            {
                System.out.println("You have to put some data here!");
                continue;
            } else
                loopTrigger = true;
        }
        return tempInputString;
    }

    //method generated random cell and 2 additional besides of it. Returns result as int array.
    public static ArrayList<String> generateRandomCells(int randomLimit, String direction)
    {
        boolean shipSettled = false;
        ArrayList<String> tempList = new ArrayList<>();
        if (direction == "horizontal")
        {
            while (!shipSettled)
            {
                generatePosition(randomLimit);
                char lineLetter = (char) (rowNumber + 'a');
                tempList.add(lineLetter + Integer.toString(columnNumber - 1));
                tempList.add(lineLetter + Integer.toString(columnNumber));
                tempList.add(lineLetter + Integer.toString(columnNumber + 1));
                if (Collections.disjoint(tempList, boundCells))
                {
                    shipSettled = true;
                    boundCells.addAll(tempList);
                } else
                {
                    tempList.clear();
                    continue;
                }
            }
        } else //vertically
        {
            while (!shipSettled)
            {
                generatePosition(randomLimit);
                tempList.add((char) ((rowNumber - 1) + 'a') + Integer.toString(columnNumber));
                tempList.add((char) (rowNumber + 'a') + Integer.toString(columnNumber));
                tempList.add((char) ((rowNumber + 1) + 'a') + Integer.toString(columnNumber));
                if (Collections.disjoint(tempList, boundCells))
                {
                    shipSettled = true;
                    boundCells.addAll(tempList);
                } else
                {

                    tempList.clear();
                    continue;
                }
            }
        }
        return tempList;
    }

    private static void generatePosition(int randomLimit)
    {
        columnNumber = rand.nextInt(((randomLimit - 2) - 1) + 1) + 1;
        rowNumber = rand.nextInt(((randomLimit - 2) - 1) + 1) + 1;
    }

    public static String generateShipDirection()
    {
        if (rand.nextBoolean())
            return "horizontal";
        else
            return "vertical";
    }
}