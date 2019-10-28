package jmol.jasper;

import jmol.jasper.MonopolyGame.Game;
import jmol.jasper.MonopolyGame.GameSetup;
import jmol.jasper.Utility.Logic.UserInputReader;

public class Main {

    public static void main(String[] args) {
        GameSetup gameSetup = new GameSetup(new UserInputReader());
        Game monopolyGame = gameSetup.createGame();
        monopolyGame.startGame();
    }
}
