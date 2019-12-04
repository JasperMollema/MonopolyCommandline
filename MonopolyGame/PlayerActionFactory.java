package jmol.jasper.MonopolyGame;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(PlayerActionType playerActionType) {
        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction();
        }
        return null;
    }
}
