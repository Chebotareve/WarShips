import java.util.ArrayList;

public class DotComBust
{
    static GameHelper helper = new GameHelper();
    static int randomLimit;
    static int numberOfGuesses;
    static boolean loopTrigger;
    static ArrayList<DotCom> shipsList = new ArrayList<>();
    static ArrayList<String> successfulGuesses = new ArrayList<String>();

    public static void main(String[] args)
    {
       /* SimpleDotComTestDrive test = new SimpleDotComTestDrive();
        test.main();*/
        setUpGame();
        startPlaying();
    }

    public static void setUpGame()
    {
        loopTrigger = false;
        while (!loopTrigger)
        {
            try
            {
                randomLimit = Integer.parseInt(helper.getUserInput("Grid limit is: "));
            } catch (NumberFormatException exc)
            {
                System.out.println("Incorrect input! You have to input numbers only! Exception is: " + exc);
                continue;
            }
            loopTrigger = true;
        }

        for (int i = 0; i < 3; i++)
        {
            shipsList.add(new DotCom());
            shipsList.get(i).setShipName("Ship" + Integer.toString(i));
            shipsList.get(i).setShipDirection(GameHelper.generateShipDirection());
            shipsList.get(i).setShipLocation(GameHelper.generateRandomCells(randomLimit, shipsList.get(i).getShipDirection()));
        }
    }

    public static void startPlaying()
    {
        //guessResult = "miss";
        numberOfGuesses = 0;
        String playerGuessString;
        while (!shipsList.isEmpty())
        {
            playerGuessString= helper.getUserInput("Your guess is: ");
            numberOfGuesses++;
            if (successfulGuesses.contains(playerGuessString))
            {
                System.out.println("You've already tried this! Do not cheat!");
                continue;
            }
            checkUserGuess(playerGuessString);
        }
        finishGame(numberOfGuesses);
    }

    public static void checkUserGuess(String playerGuessString)
    {
        String guessResult = "miss";
        for (int i = 0; i < shipsList.size(); i++)
        {
            guessResult = shipsList.get(i).checkYourself(playerGuessString);
            if (guessResult == "kill")
            {
                guessResult = String.format("You've just sunk %s", shipsList.get(i).getShipName());
                shipsList.remove(i);
                break;
            } else if (guessResult.equals("hit")){
                break;
            }
        }
        System.out.println(guessResult);
    }

    public static void finishGame(int numberOfGuesses)
    {
        System.out.println("The game took " + numberOfGuesses + " attempts");
    }
}
