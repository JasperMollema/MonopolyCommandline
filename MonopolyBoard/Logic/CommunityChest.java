package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class CommunityChest extends CardSpace {

    public CommunityChest(String name, int spaceNr) {
        super(name, spaceNr);
    }


    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een algemeen fonds kaart.");
        return null;
    }
}
