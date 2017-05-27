package game;

import ships.Ship;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;

class Player {
    private List<String> successfulGuesses;
    private int guessesAmount;

    Player() {
        successfulGuesses = new ArrayList<>();
        guessesAmount = 0;
    }

    public void play() {
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
                System.out.println("You've already shoot here, try something else");
                continue;
            } else {
                unique = true;
            }
        }
        return guess;
    }

    private GuessResult checkUserGuess(String guess) {
        GuessResult guessResult = GuessResult.MISS;
        for (Ship ship : WarShipsGame.shipList()) {
            if (ship.isAlive()) {
                if (ship.shipCells().contains(guess)) {
                    if (ship.shipCells().size() > 1) {
                        ship.shipCells().remove(guess);
                        guessResult = GuessResult.HIT;
                        addSuccessfulGuess(guess);
                        break;
                    } else if (ship.shipCells().size() == 1) {
                        guessResult = GuessResult.KILL;
                        WarShipsGame.shipList().remove(ship);
                        addSuccessfulGuess(guess);
                        break;
                    }
                }
            }
        }
        System.out.println(guessResult.message());
        return guessResult;
    }

    public void showStats() {
        System.out.println(guessesAmount);
    }

    private void addSuccessfulGuess(String guess) {
        successfulGuesses.add(guess);
    }
}
