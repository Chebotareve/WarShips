package ships;

public class SingleDeckShip extends Ship {
    public SingleDeckShip() {
        createShip(1);
    }

    @Override
    public void sink(int shipsNumber) {
        System.out.println("You've just sunk Single-Deck ship, " + shipsNumber + " more ship(s) left!");
    }
}
