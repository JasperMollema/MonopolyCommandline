package jmol.jasper;

import jmol.jasper.MonopolyGame.Logic.Game;
import jmol.jasper.MonopolyGame.Logic.GameSetup;
public class Main {

    public static void main(String[] args) {
        GameSetup gameSetup = new GameSetup();
        Game monopolyGame = gameSetup.createGame();
        monopolyGame.startGame();
    }
}
