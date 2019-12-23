package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;
import jmol.jasper.Player.Logic.Player;

public abstract class Property extends Boardspace {
    public final int VALUE;

    protected Player owner;

    public Property(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType);
        VALUE = value;
    }

    @Override
    public PlayerActionType performAction (){
        if (owner == null) {
            return PlayerActionType.BUY_PROPERTY;
        } else
            return PlayerActionType.PAY_RENT;
    }

    public void payRent() {
        if (owner == visitor) {
            return;
        }
        int rent = calculateRent();
        System.out.println(visitor + " betaald " + rent + " euro rente aan " + owner);
        visitor.payMoney(rent);
        owner.receiveMoney(rent);
    }

//    private boolean wantToBuyProperty() {
//       if (!visitor.canAffordPayment(value)) {
//           System.out.println(visitor + " heeft niet genoeg geld om " + name + " te kopen.");
//           return false;
//       }
//       System.out.println("Wil je " + name + " kopen? De prijs is " + value + " euro.");
//       visitor.printAmountOfMoney();
//       Boolean wantToBuyProperty = userInputReader.getBoolean();
//       while (!ExpressionValidator.getInstance().isValidBoolean(wantToBuyProperty)) {
//           System.out.println("Voer ja, j, yes, y voor ja en nee, no, n voor nee");
//           wantToBuyProperty = userInputReader.getBoolean();
//       }
//       return wantToBuyProperty;
//    }

    public void buyProperty(Player player) {
        owner = player;
    }


    private boolean buyProperty() {
//        if (!wantToBuyProperty()) {
//            return false;
//        }
//        if (!visitor.buyPropertyFromBank(this, value)) {
//            return false;
//        }
        return true;
    }

    public abstract int calculateRent();
}
