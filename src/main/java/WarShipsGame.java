import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarShipsGame {
    public static int[][] battleFieldArray = new int[10][10];
    public static HashMap<Integer, String> lettersMap = new HashMap<>();
    private static List<Ship> shipsList = new ArrayList<>();

    public static List<Ship> shipsList() {
        return shipsList;
    }

    public static void main(String[] args) {
        generateShipsList();
    }

    private static void generateShipsList() {
        shipsList.add(new QuadDeckShip());
        shipsList.add(new TripleDeckShip());
        shipsList.add(new TripleDeckShip());
        shipsList.add(new DoudleDeckShip());
        shipsList.add(new DoudleDeckShip());
        shipsList.add(new DoudleDeckShip());
        shipsList.add(new SingleDeckShip());
        shipsList.add(new SingleDeckShip());
        shipsList.add(new SingleDeckShip());
        shipsList.add(new SingleDeckShip());
    }
}
