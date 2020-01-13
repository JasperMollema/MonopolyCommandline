package jmol.jasper.MonopolyBoard.Logic;


import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class CommunityChest extends CardSpace {

    public CommunityChest(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een algemeen fonds kaart.");
        return PlayerActionType.NO_PLAYER_ACTION;
    }
}
