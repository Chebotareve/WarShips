import java.util.ArrayList;

public class DotCom
{
    private String shipName;
    private String shipDirection;
    private ArrayList<String> shipLocation;

    public void setShipName(String name)
    {
        shipName = name;
    }

    public String getShipName()
    {
        return shipName;
    }

    public void setShipLocation(ArrayList<String> locs)
    {
        shipLocation = locs;
    }

    public void setShipDirection(String direct)
    {
        shipDirection = direct;
    }

    public String getShipDirection()
    {
        return shipDirection;
    }

    public String checkYourself(String stringGuess)
    {
        String result = "miss";
        if (shipLocation.size() > 1)
        {
            if (shipLocation.contains(stringGuess))
            {
                result = "hit";
                shipLocation.remove(shipLocation.indexOf(stringGuess));
                DotComBust.successfulGuesses.add(stringGuess);
            }
        } else if (shipLocation.size() == 1)
        {
            if (shipLocation.contains(stringGuess))
            {
                result = "kill";
                shipLocation.remove(shipLocation.indexOf(stringGuess));
                DotComBust.successfulGuesses.add(stringGuess);
            }
        }
        return result;

    }

}