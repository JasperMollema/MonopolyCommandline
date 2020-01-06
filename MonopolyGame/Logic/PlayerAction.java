package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.Player.Logic.Player;

public abstract class PlayerAction {
    protected Bank bank;
    protected Player player;
    protected Boardspace boardspace;

    public PlayerAction(Bank bank, Player player, Boardspace boardspace) {
        this.bank = bank;
        this.player = player;
        this.boardspace = boardspace;
    }

    public abstract void handleAction();
}
