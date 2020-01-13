package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Action.PlayerActionType;

public class Taxation extends Boardspace {
    private int taxAmount;

    public Taxation(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int taxAmount) {
        super(name, spaceNr, boardspaceType);
        this.taxAmount = taxAmount;
    }

    @Override
    public PlayerActionType performAction() {
        visitor.payMoney(taxAmount);
        System.out.println(visitor.getName() + " moet " + taxAmount + " belasting betalen!");
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}
