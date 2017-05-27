package ships;

public class DoudleDeckShip extends Ship {
    public DoudleDeckShip() {
        createShip(2);
    }

    @Override
    public void sink(int shipsNumber) {
        System.out.println("You've just sunk Double-Deck ship, " + shipsNumber + " more ship(s) left!");
    }
}
