package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.Utility.Logic.ExpressionValidator;
import jmol.jasper.Utility.Logic.UserInputReader;

public class TransactionHandler {
    private UserInputReader userInputReader;
    private static final int BUY_HOUSES = 1;
    private static final int SOMETHING_ELSE = 2;

    public TransactionHandler (UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    public PlayerActionType determinePlayerTransaction() {
       switch (getChoice()) {
           case BUY_HOUSES: return PlayerActionType.BUY_HOUSES;
       }
       return PlayerActionType.INVALID_ACTION;
    }

    private int getChoice () {
        System.out.println("Wat wil je doen? " +
                "-Kies 1 voor huizen of hotels kopen." +
                "-Kies 2 voor iets anders");
        Integer choice = userInputReader.getIntegerWithBoundary(1,2);
        boolean isValidChoice = isValidChoice(choice);
        while (!isValidChoice) {
            System.out.println("Dat is geen geldige keuze, voer nog een keer je keuze in.");
            choice = userInputReader.getIntegerWithBoundary(1,2);
            isValidChoice = isValidChoice(choice);
        }
        return choice;
    }

    private boolean isValidChoice(Integer choice) {
        return ExpressionValidator.getInstance().isValidInteger(choice);
    }
}
