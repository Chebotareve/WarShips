package ships;

public class QuadDeckShip extends Ship {
    public QuadDeckShip() {
        super(4);
    }

    @Override
    public void sink(int shipsLeft) {
        System.out.println("You've just sunk Quadruple-Deck ship, " + shipsLeft + " more ship(s) left!");
    }
}
