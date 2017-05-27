package game;

import ships.*;

import java.util.ArrayList;
import java.util.List;

public class WarShipsGame {
    private static List<Ship> shipList = new ArrayList<>();

    public static List<Ship> shipList() {
        return shipList;
    }

    public static void main(String[] args) {
        generateShipsList();
        Player player = new Player();
        player.play();
        player.showSessionStats();
    }

    private static void generateShipsList() {
        shipList.add(new QuadDeckShip());
        shipList.add(new TripleDeckShip());
        shipList.add(new TripleDeckShip());
        shipList.add(new DoudleDeckShip());
        shipList.add(new DoudleDeckShip());
        shipList.add(new DoudleDeckShip());
        shipList.add(new SingleDeckShip());
        shipList.add(new SingleDeckShip());
        shipList.add(new SingleDeckShip());
        shipList.add(new SingleDeckShip());
    }

    static void destroyShip(Ship ship){
        shipList.remove(ship);
        ship.sink(shipList.size());
    }
}
