package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Action.PlayerActionType;

public class Card {
    private String message;
    private PlayerActionType playerActionType;
    private int amtToPayReceive;
    private CardActionType cardActionType;
}

enum CardActionType {
    MOVE_AMOUNT_OF_SPACES,
    GO_TO,
    GO_BACK,
    PAY,
    PAY_FOR_HOUSES,
    PAY_FROM_OTHER_PLAYERS,
    PAY_OR_DRAW_CHANCE,
    GET_OUT_OF_JAIL,
    GO_TO_JAIL
}
