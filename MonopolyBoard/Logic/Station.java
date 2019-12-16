package jmol.jasper.MonopolyBoard.Logic;

public class Station extends Property {

    public Station(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }


    @Override
    public int calculateRent() {
        return 25 * owner.getOwnedInstances("");
    }
}
