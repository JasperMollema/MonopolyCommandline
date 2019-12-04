package jmol.jasper.MonopolyGame.Logic;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(PlayerActionType playerActionType) {
        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction();
        }
        throw new UnsupportedOperationException("This action is not allowed");
    }
}
