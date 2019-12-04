package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Jail extends Boardspace {

    public Jail(UserInputReader userInputReader, String name, int spaceNr) {
        super(userInputReader, name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println("Alleen op bezoek!");
        return null;
    }
}
