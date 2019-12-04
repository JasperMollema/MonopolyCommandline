package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.Player.Logic.Player;

public abstract class PlayerAction {
    public abstract void handleAction(Bank bank, Player player);
}
