import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Ship {
    private int shipSize;
    private ShipDirection shipDirection;
    private List<String> shipCells = new ArrayList<>();
    private List<String> surroundingCells = new ArrayList<>();

    public void createShip(int shipSize) {
        this.shipSize = shipSize;
        chooseShipLayout();
        this.shipCells = generateShipCells();
    }

    public void chooseShipLayout() {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.shipDirection = ShipDirection.HORIZONTAL;
        } else {
            this.shipDirection = ShipDirection.VERTICAL;
        }
    }

    public List<String> generateShipCells() {
        boolean shipGenerated = false;
        List<String> tempShipCells = new ArrayList<>();
        while (!shipGenerated) {
            int initialRow = 0;
            int initialColumn = 0;
            char columnLetter;
            switch (shipDirection) {
                case VERTICAL:
                    initialRow = (int) (Math.random() * (10 - shipSize)) + 1;
                    initialColumn = (int) (Math.random() * 10) + 1;
                    columnLetter = getColumnLetter(initialColumn);
                    for (int i = 0; i < shipSize; i++) {
                        tempShipCells.add(columnLetter + String.valueOf(initialRow + i));
                    }
                    break;
                case HORIZONTAL:
                    initialRow = (int) (Math.random() * 10) + 1;
                    initialColumn = (int) (Math.random() * (10 - shipSize)) + 1;
                    for (int i = 0; i < shipSize; i++) {
                        columnLetter = getColumnLetter(initialColumn + i);
                        tempShipCells.add(columnLetter + String.valueOf(initialRow));
                    }
                    break;
            }
            if (shipCellsAvailable(tempShipCells)) {
                shipGenerated = true;
                this.surroundingCells = generateSurrondingCells(initialRow, initialColumn);
            } else {
                tempShipCells.clear();
                continue;
            }
        }
        return tempShipCells;
    }

    private char getColumnLetter(Integer columnNumber) {
        return (char) (columnNumber - 1 + 'a');
    }

    private boolean shipCellsAvailable(List<String> generatedCells) {
        boolean available = true;
        for (Ship ship : WarShipsGame.shipsList()) {
            for (String cell : generatedCells) {
                if (ship.shipCells.contains(cell) || ship.surroundingCells.contains(cell)) {
                    available = false;
                    break;
                }
            }
            if (!available) {
                break;
            }
        }
        return available;
    }

    private List<String> generateSurrondingCells(int initialRow, int initialColumn) {
        List<String> surroundingCellsList = new ArrayList<>();
        switch (shipDirection) {
            case VERTICAL:
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (initialRow - 1));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn)) + (initialRow - 1));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + 1)) + (initialRow - 1));
                for (int i = initialRow; i < initialRow + shipSize; i++) {
                    surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (i));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + 1)) + (i));
                }
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (initialRow + shipSize));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn)) + (initialRow + shipSize));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + 1)) + (initialRow + shipSize));
                break;
            case HORIZONTAL:
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (initialRow + 1));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (initialRow));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (initialRow - 1));
                for (int i = initialColumn; i < initialColumn + shipSize; i++) {
                    surroundingCellsList.add(String.valueOf(getColumnLetter(i)) + (initialRow - 1));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(i)) + (initialRow + 1));
                }
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + shipSize)) + (initialRow + 1));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + shipSize)) + (initialRow));
                surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + shipSize)) + (initialRow - 1));
                break;
        }
        return surroundingCellsList;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public int shipSize() {
        return shipSize;
    }
}
