package jmol.jasper.MonopolyGame.Logic;

public class PlayerActionFactory {
    public static PlayerAction getPlayerAction(PlayerActionType playerActionType) {
        switch (playerActionType) {
            case BUY_HOUSES: return new BuyHousesAction();
            case BUY_PROPERTY: return new BuyPropertyAction();
            case PAY_RENT: return new PayRentAction();
            case NO_ACTION: return new NoAction();
        }
        throw new UnsupportedOperationException("This action is not allowed");
    }
}
