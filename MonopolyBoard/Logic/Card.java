package jmol.jasper.MonopolyBoard.Logic;


import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

public class Card {
    private String message;
    private PlayerActionType playerActionType;
    private int amtToPayOrRecieve;
    private Integer nextBoardspaceNr;
    private boolean payRecFromOthers;
    private boolean isGetOutOfJailCard;

    public Card(String message, PlayerActionType playerActionType, int amtToPayOrRecieve,
                Integer nextBoardspaceNr, boolean payRecFromOthers, boolean isGetOutOfJailCard) {
        this.message = message;
        this.playerActionType = playerActionType;
        this.amtToPayOrRecieve = amtToPayOrRecieve;
        this.nextBoardspaceNr = nextBoardspaceNr;
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


    public boolean isPayRecFromOthers() {
        return payRecFromOthers;
    }

    public boolean isGetOutOfJailCard() {
        return isGetOutOfJailCard;
    }
}
