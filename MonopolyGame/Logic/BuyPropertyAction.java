package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;
import jmol.jasper.UserInterface.Logic.UserInputReader;

public class BuyPropertyAction extends PlayerAction {

    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace, UserInputReader userInputReader) {
        Property property = (Property) boardspace;

        // Ask if player wants to buy the property:
        if (!ExpressionProvider.getInstance().
                getBoolean(("Wil je " + property.getName() + " kopen? Het kost " +
                        property.VALUE + " euro."), userInputReader)){
            return;
        }

        // Check if the player can buy the property;
        if (!player.canAffordPayment(property.VALUE)){
            System.out.println("Je hebt niet genoeg geld!");
            return;
        }

        // Buy the property
        bank.buyPropertyFromBank(player, property);
        player.buyProperty(property);
        property.buyProperty(player);

        System.out.println(player.getName() + " is nu eigendom van: " + property.getName());
    }
}
