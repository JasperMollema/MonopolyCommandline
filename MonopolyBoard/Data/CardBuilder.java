package jmol.jasper.MonopolyBoard.Data;

import jmol.jasper.MonopolyGame.Actions.PlayerActionType;

public class CardBuilder {
    private String message;
    private PlayerActionType playerActionType;
    private int amtToPayOrReceive;
    private Integer nextBoardspaceNr;
    private boolean payRecFromOthers;
    private boolean isGetOutOfJailCard;

    public Card build() {
        return new Card(message, playerActionType, amtToPayOrReceive,
                nextBoardspaceNr, payRecFromOthers, isGetOutOfJailCard);
    }

    public CardBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public CardBuilder setPlayerActionType(PlayerActionType playerActionType) {
        this.playerActionType = playerActionType;
        return this;
    }

    public CardBuilder setAmtToPayOrReceive(int amtToPayOrReceive) {
        this.amtToPayOrReceive = amtToPayOrReceive;
        return this;
    }

    public CardBuilder setNextBoardspaceNr(Integer nextBoardspaceNr) {
        this.nextBoardspaceNr = nextBoardspaceNr;
        return this;
    }

    public CardBuilder setPayRecFromOthers(boolean payRecFromOthers) {
        this.payRecFromOthers = payRecFromOthers;
        return this;
    }

    public CardBuilder setGetOutOfJailCard(boolean getOutOfJailCard) {
        isGetOutOfJailCard = getOutOfJailCard;
        return this;
    }
}
