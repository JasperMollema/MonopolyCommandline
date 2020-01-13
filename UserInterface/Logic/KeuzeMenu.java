package jmol.jasper.UserInterface.Logic;

import jmol.jasper.MonopolyGame.Action.PlayerActionType;

public class KeuzeMenu {
    private String[] optionsBeforeTurn;
    private String[] optionsAfterTurn;
    private String startMenu = "Wat wil je doen?";
    private final String DOBBELSTEEN_GOOIEN = "Dobbelsteen gooien";
    private final String HUIZEN_KOPEN = "Huizen kopen";
    private final String HUIZEN_VERKOPEN = "Huizen verkopen";
    private final String PRINT_OVERZICHT = "Bekijk bezittingen";
    private final String EINDE_BEURT = "Einde beurt";

    public KeuzeMenu() {
        optionsBeforeTurn = new String[] {
                DOBBELSTEEN_GOOIEN,
                HUIZEN_KOPEN,
                HUIZEN_VERKOPEN,
                PRINT_OVERZICHT
        };

        optionsAfterTurn = new String[] {
                HUIZEN_KOPEN,
                HUIZEN_VERKOPEN,
                PRINT_OVERZICHT,
                EINDE_BEURT
        };
    }
    public PlayerActionType getChoiceBeforeTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsBeforeTurn, startMenu);
        return getChoice(optionsBeforeTurn[choice]);
    }

    public PlayerActionType getChoiceAfterTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsAfterTurn, startMenu);
        return getChoice(optionsAfterTurn[choice]);
    }

    private PlayerActionType getChoice(String choice) {
        switch (choice) {
            case HUIZEN_KOPEN:
                return PlayerActionType.BUY_HOUSES;
            case HUIZEN_VERKOPEN:
                return PlayerActionType.SELL_HOUSES;
            case PRINT_OVERZICHT:
                return PlayerActionType.PRINT_STATUS;
            default:
                return PlayerActionType.NO_PLAYER_ACTION;
        }
    }
}
