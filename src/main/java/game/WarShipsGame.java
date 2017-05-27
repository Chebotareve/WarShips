package game;

import ships.*;

import java.util.ArrayList;
import java.util.List;

public class WarShipsGame {
    private static List<Ship> shipsList = new ArrayList<>();

    public static List<Ship> shipList() {
        return shipsList;
    }

    public static void main(String[] args) {
        generateShipsList();
        Player player = new Player();
        player.play();
        player.showStats();
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
