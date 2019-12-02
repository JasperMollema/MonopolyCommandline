package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Freeparking extends Boardspace {

    public Freeparking(UserInputReader userInputReader, String name, int spaceNr) {
        super(userInputReader, name, spaceNr);
    }

    @Override
    public PlayerAction performAction() {
        return null;
    }
}
