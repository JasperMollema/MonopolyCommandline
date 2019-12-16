package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;
import jmol.jasper.Player.Logic.Player;

public class Boardspace {
    protected String name;
    protected int spaceNr;
    protected MonopolyBoardData.BoardspaceType boardspaceType;
    protected Player visitor;
    protected int diceThrowVisitor;

    public Boardspace(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType){
        this.name = name;
        this.spaceNr = spaceNr;
        this.boardspaceType = boardspaceType;
    }

    public Boardspace() {}

    public PlayerActionType performAction(){return null;}

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

    public MonopolyBoardData.BoardspaceType getBoardspaceType() {
        return boardspaceType;
    }
}
