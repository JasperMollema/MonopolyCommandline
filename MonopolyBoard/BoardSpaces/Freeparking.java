package jmol.jasper.MonopolyBoard.BoardSpaces;


import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Actions.PlayerActionType;

public class Freeparking extends Boardspace {

    public Freeparking(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}