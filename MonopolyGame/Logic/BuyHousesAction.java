package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Street;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.List;

public class BuyHousesAction extends PlayerAction {
    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace, UserInputReader userInputReader) {
        // Check for which streets the player can buy houses
        Street[] ownedStreets = convertStreetListToArray(bank.getOwnedCities(player));

        // Ask player for which streets he wants to buy houses.
        // TODO: Make a generic method in ExpressionProvider to get an option from the player. Call this method and
        // TODO: repeat for as long the player wants to buy houses.

        // Buy the houses
    }

    private Street[] convertStreetListToArray(List<Street> streetList) {
        Street[] ownedStreets = new Street[streetList.size()];
        int i = 0;
        for (Street street : streetList) {
            ownedStreets[i] = street;
            i++;
        }
        return ownedStreets;
    }
}
