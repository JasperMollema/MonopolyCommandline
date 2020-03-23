package jmol.jasper.MonopolyGame.Actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.Player.Logic.Player;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(
            PlayerActionType playerActionType,
            Player player,
            Boardspace boardspace) {

        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction(player, boardspace);
            case SELL_HOUSES: return new SellHouseAction(player, boardspace);
            case BUY_PROPERTY: return new BuyPropertyAction(player, boardspace);
            case PAY_RENT: return new PayRentAction(player, boardspace);
            case NO_PLAYER_ACTION: return new NoAction(player, boardspace);
            case GO_TO_JAIL: return new GoToJailAction(player, boardspace);
            case PRINT_STATUS: return new PrintPlayerStatus(player, boardspace);
            case PAY: return new PayCardAction(player, boardspace);
            case PAY_FOR_HOUSES_CARD: return new PayForHousesCardAction(player, boardspace);
            case GO_TO_BOARDSPACE_REGULAR: return new GoToBoardspaceRegularAction(player, boardspace);
            case GO_TO_BOARDSPACE_DIRECT: return new GoToBoardspaceDirectAction(player, boardspace);
            case GO_THREE_SPACES_BACK: return new GoThreePlacesBackAction(player, boardspace);
            case PAY_OR_DRAW_CHANCE_CARD: return new PayOrDrawChanceCardAction(player, boardspace);
        }
        throw new UnsupportedOperationException("This action is not allowed");
    }
}
