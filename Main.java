package jmol.jasper;

import jmol.jasper.MonopolyGame.Logic.Bank;
import jmol.jasper.MonopolyGame.Logic.Game;
import jmol.jasper.MonopolyGame.Logic.GameSetup;
import jmol.jasper.UserInterface.Logic.UserInputReader;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();GameSetup gameSetup = new GameSetup(new UserInputReader());
        Game monopolyGame = gameSetup.createGame();
        monopolyGame.startGame();
    }
}
