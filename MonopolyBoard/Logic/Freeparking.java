package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Freeparking extends Boardspace {

    public Freeparking(String name, int spaceNr) {
        super(name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        return null;
    }
}
