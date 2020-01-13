package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Action.PlayerActionType;

public class Freeparking extends Boardspace {

    public Freeparking(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}
