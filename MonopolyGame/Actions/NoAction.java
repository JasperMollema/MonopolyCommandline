package jmol.jasper.MonopolyGame.Actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.Player.Logic.Player;

public class NoAction extends PlayerAction {
    public NoAction(Player player, Boardspace boardspace) {
        super(player, boardspace);
    }

    @Override
    public void handleAction() {
        return;
    }
}
