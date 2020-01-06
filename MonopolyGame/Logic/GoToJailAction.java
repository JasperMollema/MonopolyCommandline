package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Jail;
import jmol.jasper.MonopolyBoard.Logic.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

public class GoToJailAction extends PlayerAction {
    public GoToJailAction(Bank bank, Player player, Boardspace boardspace) {
        super(bank, player, boardspace);
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
