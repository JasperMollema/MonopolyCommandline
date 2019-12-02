package jmol.jasper.MonopolyGame;

import jmol.jasper.Player.Logic.Player;
import jmol.jasper.Utility.Logic.UserInputReader;

public class RoundOfPlay {
    private UserInputReader userInputReader;
    private Player player;
    private int totalThrow;
    private boolean isDoubleTrow;
    private int nrOfThrows;

    public RoundOfPlay(Player player, UserInputReader userInputReader) {
        this.player = player;
        this.userInputReader = userInputReader;
    }

    public void play() {
        throwDice();
        player.move(totalThrow);
    }

    private void throwDice() {
        int firstThrow = player.throwDice();
        int secondThrow = player.throwDice();
        isDoubleTrow = firstThrow == secondThrow;
        totalThrow = firstThrow + secondThrow;
        nrOfThrows ++;
        System.out.println(player + " heeft " + firstThrow + " en " + secondThrow + " gegooid!");
    }

    public boolean determineCanThrowAgain() {
        boolean canThrowAgain = isDoubleTrow && nrOfThrows > 0 && nrOfThrows < 3;
        if (canThrowAgain) {
            System.out.println(player + " mag nog een keer gooien!");
        }
        return canThrowAgain;
    }

    public int getTotalThrow() {
        return totalThrow;
    }
}
