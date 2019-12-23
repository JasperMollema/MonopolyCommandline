package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;

public class BuyPropertyAction extends PlayerAction {
    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace) {
        Property property = (Property) boardspace;
        System.out.println("Wil je " + property.getName() + " kopen?");
        bank.buyProperty(player, property);
    }
}
