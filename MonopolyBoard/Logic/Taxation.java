package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Taxation extends Boardspace {
    private int taxAmount;

    public Taxation(String name, int spaceNr, int taxAmount) {
        super(name, spaceNr);
        this.taxAmount = taxAmount;
    }

    @Override
    public PlayerActionType performAction() {
        visitor.payMoney(taxAmount);
        System.out.println(visitor.getName() + " moet " + taxAmount + " belasting betalen!");
        return null;
    }
}
