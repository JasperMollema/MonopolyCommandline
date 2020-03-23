package jmol.jasper.MonopolyBoard.BoardSpaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Actions.PlayerActionType;
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

    public void buyProperty(Player player) {
        owner = player;
    }

    public abstract int calculateRent();

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return name;
    }
}
