package game;

import ships.Ship;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;

class Player {
    private List<String> successfulGuesses = new ArrayList<>();
    private int guessesAmount = 0;

    void showSessionStats() {
        System.out.println("Congrats, you sunk all ships with " + guessesAmount + " shots!");
    }

    void play() {
        while (WarShipsGame.shipList().size() > 0) {
            String guess = getUserGuess();
            guessesAmount++;
            checkUserGuess(guess);
        }
    }

    private String getUserGuess() {
        boolean unique = false;
        String guess = "";
        while (!unique) {
            guess = Helper.getUserInput("Insert your guess please: ").toLowerCase();
            if (successfulGuesses.contains(guess)) {
                System.out.println("You've already hit something here, try another spot");
            } else {
                unique = true;
            }
        }
        return guess;
    }

    private void checkUserGuess(String guess) {
        GuessResult guessResult = GuessResult.MISS;
        for (Ship ship : WarShipsGame.shipList()) {
            if (ship.shipCells().contains(guess)) {
                if (ship.shipCells().size() > 1) {
                    ship.shipCells().remove(guess);
                    guessResult = GuessResult.HIT;
                    addSuccessfulGuess(guess);
                    break;
                } else {
                    guessResult = GuessResult.KILL;
                    WarShipsGame.destroyShip(ship);
                    addSuccessfulGuess(guess);
                    break;
                }
            }
        }
        if (guessResult!=GuessResult.KILL){
            System.out.println(guessResult.message());
        }
    }

    private void addSuccessfulGuess(String guess) {
        successfulGuesses.add(guess);
    }
}
