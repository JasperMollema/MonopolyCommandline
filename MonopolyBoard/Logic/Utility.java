package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.Bank;

public class Utility extends Property {

    public Utility(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }

    @Override
    public int calculateRent(Bank bank) {
        if (bank.getOwnesAllTypes(this, owner)) {
            return diceThrowVisitor * 10;
        }
        else {
            return diceThrowVisitor * 4;
        }
    }
}
