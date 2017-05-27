package ships;

public class QuadDeckShip extends Ship {
    public QuadDeckShip() {
        createShip(4);
    }

    @Override
    public void sink(int shipsNumber) {
        System.out.println("You've just sunk Quadruple-Deck ship, " + shipsNumber + " more ship(s) left!");
    }
}
