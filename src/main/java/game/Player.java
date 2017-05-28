package game;

import ships.Ship;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;

class Player {
    private List<String> successfulGuessesList = new ArrayList<>();
    private int uniqueGuessesAmount = 0;

    void showSessionStats() {
        System.out.println("Congrats, you sunk all ships with " + uniqueGuessesAmount + " shots!");
    }

    void play() {
        while (WarShipsGame.shipList().size() > 0) {
            String guess = getUserGuess();
            uniqueGuessesAmount++;
            checkUserGuess(guess);
        }
    }

    private String getUserGuess() {
        return Helper.getUserInput("Insert your guess please: ", successfulGuessesList);
    }

    private void checkUserGuess(String guess) {
        GuessResult guessResult = GuessResult.MISS;
        for (Ship ship : WarShipsGame.shipList()) {
            if (ship.guessMatchShipDeck(guess)) {
                if (ship.numbersOfLiveDecks() > 1) {
                    ship.dismissDeck(guess);
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
        successfulGuessesList.add(guess);
    }
}
