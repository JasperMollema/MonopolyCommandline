package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Action.PlayerActionType;

public class Start extends Boardspace{

    public Start(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor + " staat op start en ontvangt 400 euro!");
        visitor.receiveMoney(400);
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}
