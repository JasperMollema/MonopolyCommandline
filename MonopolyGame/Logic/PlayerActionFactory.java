package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(
            PlayerActionType playerActionType,
            Bank bank,
            Player player,
            Boardspace boardspace) {

        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction(bank, player, boardspace);
            case SELL_HOUSES: return new SellHouseAction(bank, player, boardspace);
            case BUY_PROPERTY: return new BuyPropertyAction(bank, player, boardspace);
            case PAY_RENT: return new PayRentAction(bank, player, boardspace);
            case NO_PLAYER_ACTION: return new NoAction(bank, player, boardspace);
            case GO_TO_JAIL_ACTION: return new GoToJailAction(bank, player, boardspace);
            case PRINT_STATUS: return new PrintPlayerStatus(bank, player, boardspace);
            case PAY_CARD_ACTION: return new PayCardAction(bank, player, boardspace);
            case PAY_FOR_HOUSES_CARD_ACTION: return new PayForHousesCardAction(bank, player, boardspace);
            case GO_TO_BOARDSPACE_CARD_ACTION: return new GoToBoardSpaceCardAction(bank, player, boardspace);
            case PAY_OR_DRAW_CHANCH_CARD_ACTION: return new PayOrDrawChanceCardAction(bank, player, boardspace);
        }
        throw new UnsupportedOperationException("This action is not allowed");
    }
}
