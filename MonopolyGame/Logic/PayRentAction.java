package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.UserInputReader;


public class PayRentAction extends PlayerAction {
    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace, UserInputReader userInputReader) {
        Property property = (Property) boardspace;
        Player owner = property.getOwner();
        if (player.equals(owner)) {
            System.out.println(player.getName() + " is eigendom van " + property.getName());
            return;
        }
        int rent = property.calculateRent(bank);
        int payedRent = player.payMoney(rent);
        owner.receiveMoney(payedRent);
        if (!(rent == payedRent)) {
            System.out.println(player.getName() + " kan de huur niet betalen!");
        }
        System.out.println(player.getName() + " betaald " + payedRent + " euro aan " + owner.getName());
    }
}
