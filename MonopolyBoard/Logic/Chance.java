package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Chance extends CardSpace {

    public Chance(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een kanskaart.");
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}
