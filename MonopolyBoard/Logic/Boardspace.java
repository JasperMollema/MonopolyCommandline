package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.PlayerActionType;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.Utility.Logic.UserInputReader;

public abstract class Boardspace {
    protected String name;
    protected int spaceNr;
    protected UserInputReader userInputReader;
    protected Player visitor;
    protected int diceThrowVisitor;

    public Boardspace(){}

    public Boardspace(UserInputReader userInputReader, String name, int spaceNr){
        this.userInputReader = userInputReader;
        this.name = name;
        this.spaceNr = spaceNr;
    }

    public abstract PlayerActionType performAction();

    public int prepareAction (Player player, int diceThrow) {
        visitor = player;
        diceThrowVisitor = diceThrow;
        System.out.println(player + " staat op " + name + ".");
        return spaceNr;
    }

    public String getName() {
        return name;
    }

    public int getSpaceNr() {
        return spaceNr;
    }
}
