package ships;

public class DoubleDeckShip extends Ship {
    public DoubleDeckShip() {
        super(2);
    }

    @Override
    public void sink(int shipsLeft) {
        System.out.println("You've just sunk Double-Deck ship, " + shipsLeft + " more ship(s) left!");
    }
}
