package jmol.jasper.UserInterface.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class KeuzeMenu {
    String[] optionsBeforeTurn;
    String[] optionsAfterTurn;
    String startMenu = "Wat wil je doen?";

    public KeuzeMenu() {
        optionsBeforeTurn = new String[] {
                "Dobbelsteen gooien.",
                "Huizen kopen"
        };

        optionsAfterTurn = new String[] {
                "Huizen kopen",
                "Einde beurt"
        };
    }
    public PlayerActionType getChoiceBeforeTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsBeforeTurn, startMenu);
        switch (choice) {
            case 1: return PlayerActionType.BUY_HOUSES;
            default: return PlayerActionType.NO_ACTION;
        }
    }

    public PlayerActionType getChoiceAfterTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsAfterTurn, startMenu);
        switch (choice) {
            case 0: return PlayerActionType.BUY_HOUSES;
            default: return PlayerActionType.NO_ACTION;
        }
    }
}
