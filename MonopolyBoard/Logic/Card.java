package jmol.jasper.MonopolyBoard.Logic;


import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Card {
    private String message;
    private PlayerActionType playerActionType;
    private int amtToPayOrRecieve;
    private int spacesToMove;
    private boolean payRecFromOthers;
    private boolean isGetOutOfJailCard;

    public Card(String message, PlayerActionType playerActionType, int amtToPayOrRecieve,
                int spacesToMove, boolean payRecFromOthers, boolean isGetOutOfJailCard) {
        this.message = message;
        this.playerActionType = playerActionType;
        this.amtToPayOrRecieve = amtToPayOrRecieve;
        this.spacesToMove = spacesToMove;
        this.payRecFromOthers = payRecFromOthers;
        this.isGetOutOfJailCard = isGetOutOfJailCard;
    }

    public String getMessage() {
        return message;
    }

    public PlayerActionType getPlayerActionType() {
        return playerActionType;
    }

    public int getAmtToPayOrRecieve() {
        return amtToPayOrRecieve;
    }

    public int getSpacesToMove() {
        return spacesToMove;
    }

    public boolean isPayRecFromOthers() {
        return payRecFromOthers;
    }

    public boolean isGetOutOfJailCard() {
        return isGetOutOfJailCard;
    }
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
