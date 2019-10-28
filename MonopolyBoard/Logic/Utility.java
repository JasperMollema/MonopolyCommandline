package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Utility extends Property {

    public Utility(UserInputReader userInputReader, String name, int spaceNr, String type, int nrOfInstances, int[]values) {
        super(userInputReader, name, spaceNr, type, nrOfInstances, values);
    }

    @Override
    public int calculateRent() {
        int rent;
        if (owner.hasAllInstances(type, nrOfInstances)) {
            rent = diceThrowVisitor * 10;
        }
        else {
            rent = diceThrowVisitor * 4;
        }
        return rent;
    }
}
