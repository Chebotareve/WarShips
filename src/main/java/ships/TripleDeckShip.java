package ships;

public class TripleDeckShip extends Ship {
    public TripleDeckShip() {
        createShip(3);
    }

    @Override
    public void sink(int shipsLeft) {
        System.out.println("You've just sunk Triple-Deck ship, " + shipsLeft + " more ship(s) left!");
    }
}
