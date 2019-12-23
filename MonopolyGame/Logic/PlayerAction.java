package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.UserInputReader;

public abstract class PlayerAction {
    public abstract void handleAction(Bank bank,
                                      Player player,
                                      Boardspace boardspace,
                                      UserInputReader userInputReader);
}
