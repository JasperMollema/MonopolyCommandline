package jmol.jasper.MonopolyGame.Logic;

public enum PlayerActionType {
    BUY_PROPERTY("grond kopen"), BUY_HOUSES("huizen kopen"), INVALID_ACTION("Ongeldige actie");

    /**
     * Message that describes the player action. The entire message that is displayed
     * when this action is chosen should be like: "Wil je [actionMessage]" .
     */
    private String actionMessage;

    private PlayerActionType(String actionMessage) {this.actionMessage = actionMessage;}

    public String getActionMessage(){return actionMessage;}
}
