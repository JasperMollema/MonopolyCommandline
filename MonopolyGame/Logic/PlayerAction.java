package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;

public abstract class PlayerAction {
    protected Bank bank;
    protected Player player;
    /**
     * The boardspace to which the player should move.
     */
    protected Boardspace nextBoardspace;

    public PlayerAction(Bank bank, Player player, Boardspace boardspace) {
        this.bank = bank;
        this.player = player;
        this.nextBoardspace = boardspace;
    }

    public abstract void handleAction();
}
