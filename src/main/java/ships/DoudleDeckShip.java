package ships;

public class DoudleDeckShip extends Ship {
    public DoudleDeckShip() {
        createShip(2);
    }

    @Override
    public void sink(int shipsLeft) {
        System.out.println("You've just sunk Double-Deck ship, " + shipsLeft + " more ship(s) left!");
    }
}
