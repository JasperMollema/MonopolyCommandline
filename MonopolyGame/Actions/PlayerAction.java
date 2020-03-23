package jmol.jasper.MonopolyGame.Actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyGame.Logic.Bank;
import jmol.jasper.Player.Logic.Player;

public abstract class PlayerAction implements Action {
    protected Bank bank;
    protected Player player;
    /**
     * The boardspace to which the player should move.
     */
    protected Boardspace nextBoardspace;

    public PlayerAction(Player player, Boardspace boardspace) {
        this.player = player;
        this.nextBoardspace = boardspace;
        bank = Bank.getInstance();
    }

    public abstract void handleAction();
}
