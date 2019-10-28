package jmol.jasper.Player.Logic;

import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.MonopolyBoard.Logic.Street;

import java.util.*;
import java.util.function.BiFunction;

public class Player {
    private String name;
    private int amountOfMoney;
    private int boardspaceNr;
    private Random dice;
    private List<Property> properties;
    private Map<String, Integer> propertyMap;
    private Map<Street, Integer> streetMap;
    private boolean isGameOver;

    public Player(String name){
        this.name = name;
        this.amountOfMoney = 1500;
        this.boardspaceNr = 0;
        properties = new ArrayList<>();
        dice = new Random();
        propertyMap = new HashMap<>();
    }


    public int throwDice() {
        return dice.nextInt(5) +1;
    }

    public boolean buyProperty(Property property, int value){
        if (properties.contains(property) || !property.buyProperty(this)){
            return false;
        }
        payMoney(value);
        addToPropertyList(property);
        System.out.println(name + " is nu eigendom van: " + property.getName());
        return true;
    }

    public boolean hasAllInstances(String type, int nrOfInstances) {
        Integer instancesOwned = propertyMap.get(type);
        if (instancesOwned == null) {
            return false;
        }
        return instancesOwned == nrOfInstances;
    }

    public int getOwnedInstances(String type) {
        if (!(propertyMap.containsKey(type))) {
            return 0;
        }
        return propertyMap.get(type);
    }

    public void move(int numberOfSpaces){
        if (numberOfSpaces < 1 || numberOfSpaces > 12){
            return;
        }
        boardspaceNr += numberOfSpaces;
        if (!(boardspaceNr<40)){
            boardspaceNr -= 40;
        }
    }

    public boolean receiveMoney(int amount) {
        if (amount < 0) {
            return false;
        }
        amountOfMoney += amount;
        return true;
    }

    public boolean payMoney(int amount){
        if (amount < 0) {
            return false;
        }
        if (!canAffordPayment(amount)) {
            amountOfMoney = 0;
            isGameOver = true;
            return false;
        }
        amountOfMoney -= amount;
        return true;
    }

    public void printAmountOfMoney() {
        System.out.println("Je hebt nog " + amountOfMoney + " euro.");
    }

    public boolean canAffordPayment(int amtToPay) {
        return (amountOfMoney - amtToPay) > 0;
    }

    public boolean canBuyHouses() {

        return true;
    }

    private void addToPropertyList(Property property) {
        properties.add(property);
        String propertyType = property.getType();
        BiFunction<Integer, Integer, Integer> mapper = (v1, v2) -> v1 + 1;
        propertyMap.merge(propertyType, 1, mapper);
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getBoardspaceNr() {
        return boardspaceNr;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}

