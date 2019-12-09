package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class GoToJail extends Boardspace{

    public GoToJail(String name, int spaceNr) {
        super(name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        return null;
    }
}
