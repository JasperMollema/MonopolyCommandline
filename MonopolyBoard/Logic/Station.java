package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Station extends Property {

    public Station(UserInputReader userInputReader, String name, int spaceNr, String type, int nrOfInstances, int[] values) {
        super(userInputReader, name, spaceNr, type, nrOfInstances, values);
    }


    @Override
    public int calculateRent() {
        return 25 * owner.getOwnedInstances(type);
    }
}
