package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;

public class NoAction extends PlayerAction {
    public NoAction(Bank bank, Player player, Boardspace boardspace) {
        super(bank, player, boardspace);
    }

    @Override
    public void handleAction() {
        return;
    }
}
