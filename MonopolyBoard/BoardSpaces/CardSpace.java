package jmol.jasper.MonopolyBoard.BoardSpaces;

import jmol.jasper.MonopolyBoard.Data.Card;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Actions.PlayerActionType;

public abstract class CardSpace extends Boardspace {

    public CardSpace(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public PlayerActionType performAction() {
        return drawCard().getPlayerActionType();
    }

    public abstract Card drawCard();

    public abstract boolean discardCard(Card card);
}
