package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.Bank;

public class Station extends Property {

    public Station(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }


    @Override
    public int calculateRent(Bank bank) {
        return 25 * bank.getNrOFStationsOwned(owner);
    }
}
