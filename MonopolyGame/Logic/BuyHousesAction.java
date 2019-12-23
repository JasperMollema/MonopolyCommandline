package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.UserInputReader;

public class BuyHousesAction extends PlayerAction {
    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace, UserInputReader userInputReader) {
        // Check for which streets the player can buy houses
        bank.getOwnedCities(player);
        // Buy the houses
    }
}
