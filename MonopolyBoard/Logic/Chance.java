package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Chance extends CardSpace {

    public Chance(String name, int spaceNr) {
        super(name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een kanskaart.");
        return null;
    }
}
