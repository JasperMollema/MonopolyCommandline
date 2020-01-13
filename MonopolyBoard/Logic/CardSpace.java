package jmol.jasper.MonopolyBoard.Logic;


public abstract class CardSpace extends Boardspace {
    protected Card[] cards;

    public CardSpace(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    public Card drawCard() {
        return cards[0];
    }
}
