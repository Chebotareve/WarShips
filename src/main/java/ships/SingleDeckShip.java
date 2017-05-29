package ships;

public class SingleDeckShip extends Ship {
    public SingleDeckShip() {
        super(1);
    }

    @Override
    public void sink(int shipsLeft) {
        System.out.println("You've just sunk Single-Deck ship, " + shipsLeft + " more ship(s) left!");
    }
}
