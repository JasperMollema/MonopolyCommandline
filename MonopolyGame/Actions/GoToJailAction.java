package jmol.jasper.MonopolyGame.Actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyBoard.BoardSpaces.Jail;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

public class GoToJailAction extends PlayerAction {
    public GoToJailAction(Player player, Boardspace boardspace) {
        super(player, boardspace);
    }

    @Override
    public void handleAction() {
        Jail prison = (Jail) MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_GEVANGENIS);
        if (player.hasGetOutOfJailCard()) {
            boolean playGetOutOfJailCard = ExpressionProvider.getInstance().getBoolean(
                    "Wil je een 'ga uit de gevangenis' kaart spelen?");
            if (playGetOutOfJailCard) {
                player.playGetOutOfJailCard();
                return;
            }
        }
        prison.imprisonPlayer(player);
    }
}
