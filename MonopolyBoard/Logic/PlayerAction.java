package jmol.jasper.MonopolyBoard.Logic;

public enum PlayerAction {
    BUY_PROPERTY("grond kopen"), BUY_HOUSES("huizen kopen");

    /**
     * Message that describes the player action. The entire message that is displayed
     * when this action is chosen should be like: "Wil je [actionMessage]" .
     */
    private String actionMessage;

    private PlayerAction(String actionMessage) {this.actionMessage = actionMessage;}

    public String getActionMessage(){return actionMessage;}
}

