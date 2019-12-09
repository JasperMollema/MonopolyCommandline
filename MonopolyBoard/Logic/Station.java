package jmol.jasper.MonopolyBoard.Logic;

public class Station extends Property {

    public Station(String name, int spaceNr, PropertyType propertyType, int nrOfInstances, int value) {
        super(name, spaceNr, propertyType, nrOfInstances, value);
    }


    @Override
    public int calculateRent() {
        return 25 * owner.getOwnedInstances(type);
    }
}
