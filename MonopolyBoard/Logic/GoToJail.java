package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class GoToJail extends Boardspace{

    public GoToJail(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        return PlayerActionType.NO_ACTION;
    }
}
