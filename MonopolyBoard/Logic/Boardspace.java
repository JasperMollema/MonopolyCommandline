package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.MonopolyGame.Logic.PlayerActionType;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.Utility.Logic.UserInputReader;

public class Boardspace {
    protected String name;
    protected int spaceNr;
    protected int value;
    protected int nrOfInstances;
    protected int priceHouse;
    protected int rentNoHouses;
    protected int rentForOneHouse;
    protected int rentForTwoHouses;
    protected int rentForThreeHouses;
    protected int rentForFourHouses;
    protected int rentForHotel;
    protected String type;
    protected int taxAmount;
    protected UserInputReader userInputReader;
    protected Player visitor;
    protected int diceThrowVisitor;

    public Boardspace(String name, int spaceNr, int value, int nrOfinstances, int priceHouse, int rentNoHouses,
                      int rentForOneHouse, int rentForTwoHouses, int rentForThreeHouses, int rentForFourHouses,
                      int rentForHotel, String type, int taxAmount){
        this.name = name;
        this.spaceNr = spaceNr;
        this.value = value;
        this.nrOfInstances = nrOfinstances;
        this.priceHouse = priceHouse;
        this.rentNoHouses = rentNoHouses;
        this.rentForOneHouse = rentForOneHouse;
        this.rentForTwoHouses = rentForTwoHouses;
        this.rentForThreeHouses = rentForThreeHouses;
        this.rentForFourHouses = rentForFourHouses;
        this.rentForHotel = rentForHotel;
        this.type = type;
        this.taxAmount = taxAmount;
    }

    public Boardspace(UserInputReader userInputReader, String name, int spaceNr){
        this.userInputReader = userInputReader;
        this.name = name;
        this.spaceNr = spaceNr;
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
}
