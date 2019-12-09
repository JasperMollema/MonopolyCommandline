package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Jail extends Boardspace {

    public Jail(String name, int spaceNr) {
        super(name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println("Alleen op bezoek!");
        return null;
    }
}
