package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class GoToJail extends Boardspace{
    private final int JAIL_SPACE_NR = 10;

    public GoToJail(UserInputReader userInputReader, String name, int spaceNr) {
        super(userInputReader, name, spaceNr);
    }

    @Override
    public PlayerAction performAction() {
        return null;
    }
}
