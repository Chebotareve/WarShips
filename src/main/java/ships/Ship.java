package ships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.WarShipsGame;

public abstract class Ship {
    private int shipSize;
    private ShipDirection shipDirection;
    private List<String> shipCells = new ArrayList<>();
    private List<String> surroundingCells = new ArrayList<>();

    public List<String> shipCells() {
        return shipCells;
    }

    public abstract void sink(int shipsLeft);

    void createShip(int shipSize) {
        this.shipSize = shipSize;
        chooseShipLayout();
        this.shipCells = deployShip();
    }

    private void chooseShipLayout() {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.shipDirection = ShipDirection.HORIZONTAL;
        } else {
            this.shipDirection = ShipDirection.VERTICAL;
        }
    }

    private List<String> deployShip() {
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
                this.surroundingCells = generateSurroundingCells(initialRow, initialColumn, tempShipCells);
            } else {
                tempShipCells.clear();
            }
        }
        return tempShipCells;
    }

    private char getColumnLetter(Integer columnNumber) {
        return (char) (columnNumber - 1 + 'a');
    }

    private boolean shipCellsAvailable(List<String> generatedCells) {
        boolean available = true;
        for (Ship ship : WarShipsGame.shipList()) {
            if (!cellsAvailable(ship, generatedCells)) {
                available = false;
                break;
            }
        }
        return available;
    }

    private List<String> generateSurroundingCells(int initialRow, int initialColumn, List<String> shipCells) {
        List<String> surroundingCellsList = new ArrayList<>();
        switch (shipDirection) {
            case VERTICAL:
                for (int rowNumber = initialRow - 1; rowNumber <= initialRow + shipSize; rowNumber++) {
                    surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn - 1)) + (rowNumber));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn)) + (rowNumber));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(initialColumn + 1)) + (rowNumber));
                }
                break;
            case HORIZONTAL:
                for (int colNumber = initialColumn - 1; colNumber <= initialColumn + shipSize; colNumber++) {
                    surroundingCellsList.add(String.valueOf(getColumnLetter(colNumber)) + (initialRow - 1));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(colNumber)) + (initialRow));
                    surroundingCellsList.add(String.valueOf(getColumnLetter(colNumber)) + (initialRow + 1));
                }
                break;
        }
        surroundingCellsList.removeIf(cell -> shipCells.contains(cell));
        return surroundingCellsList;
    }

    private boolean cellsAvailable(Ship ship, List<String> generatedCells) {
        boolean available = true;
        for (String cell : generatedCells) {
            if (ship.shipCells.contains(cell) || ship.surroundingCells.contains(cell)) {
                available = false;
                break;
            }
        }
        return available;
    }

}
