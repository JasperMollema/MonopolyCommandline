package jmol.jasper.MonopolyBoard.Logic;


import jmol.jasper.MonopolyGame.Logic.PlayerActionType;

import java.util.HashSet;
import java.util.Set;

public class CommunityChest extends CardSpace {
    private Set<Card> cards;

    public CommunityChest(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
        cards = new HashSet<>();
        getCards();
    }

    @Override
    public PlayerActionType performAction() {
        System.out.println(visitor.getName() + " trekt een algemeen fonds kaart.");
        return drawCard().getPlayerActionType();
    }

    public Card drawCard() {
        return cards.stream().findAny().get();
    }

    private void getCards() {
        Card[] cardDeck = new CardDecks().communityChest;
        for (int i = 0; i < cardDeck.length; i++ ) {
            cards.add(cardDeck[i]);
        }
    }
}
