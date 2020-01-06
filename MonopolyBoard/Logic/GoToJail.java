package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class GoToJail extends Boardspace{

    public GoToJail(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor + " moet naar de gevangenis!");
        return PlayerActionType.GO_TO_JAIL_ACTION;
    }
}
