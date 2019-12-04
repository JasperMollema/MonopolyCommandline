package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Chance extends CardSpace {

    public Chance(UserInputReader userInputReader, String name, int spaceNr) {
        super(userInputReader, name, spaceNr);
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een kanskaart.");
        return null;
    }
}
