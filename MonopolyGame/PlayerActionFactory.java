package jmol.jasper.MonopolyGame;

import jmol.jasper.MonopolyBoard.Logic.PlayerActionType;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(PlayerActionType playerActionType) {
        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction();
        }
        return null;
    }
}
