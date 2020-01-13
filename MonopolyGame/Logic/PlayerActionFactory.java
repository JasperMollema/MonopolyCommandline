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
            case PlayerActionType.BUY_HOUSES: return new BuyHousesAction(bank, player, boardspace);
            case PlayerActionType.SELL_HOUSES: return new SellHouseAction(bank, player, boardspace);
            case PlayerActionType.BUY_PROPERTY: return new BuyPropertyAction(bank, player, boardspace);
            case PlayerActionType.PAY_RENT: return new PayRentAction(bank, player, boardspace);
            case PlayerActionType.NO_PLAYER_ACTION: return new NoAction(bank, player, boardspace);
            case PlayerActionType.GO_TO_JAIL_ACTION: return new GoToJailAction(bank, player, boardspace);
            case PlayerActionType.PRINT_STATUS: return new PrintPlayerStatus(bank, player, boardspace);
        }
        throw new UnsupportedOperationException("This action is not allowed");
    }
}
