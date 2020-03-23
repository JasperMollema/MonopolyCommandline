package jmol.jasper.MonopolyBoard.BoardSpaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Logic.Bank;

public class Station extends Property {

    public Station(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }


    @Override
    public int calculateRent() {
        return 25 * Bank.getInstance().getNrOFStationsOwned(owner);
    }
}
