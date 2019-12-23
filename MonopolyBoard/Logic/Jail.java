package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Jail extends Boardspace {

    public Jail(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println("Alleen op bezoek!");
        return PlayerActionType.NO_ACTION;
    }
}
