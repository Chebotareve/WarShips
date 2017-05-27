package ships;

public class TripleDeckShip extends Ship {
    public TripleDeckShip() {
        createShip(3);
    }

    @Override
    public void sink(int shipsNumber) {
        System.out.println("You've just sunk Triple-Deck ship, " + shipsNumber + " more ship(s) left!");
    }
}
