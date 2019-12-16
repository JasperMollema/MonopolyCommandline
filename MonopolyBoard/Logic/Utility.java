package jmol.jasper.MonopolyBoard.Logic;

public class Utility extends Property {

    public Utility(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }

    @Override
    public int calculateRent() {
//        int rent;
////        if (owner.hasAllInstances(type, nrOfInstances)) {
//            rent = diceThrowVisitor * 10;
//        }
//        else {
//            rent = diceThrowVisitor * 4;
//        }
//        return rent;
//    }
        return 1;
    }
}
