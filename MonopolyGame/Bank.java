package jmol.jasper.MonopolyGame;

import jmol.jasper.MonopolyBoard.Logic.Property;

import java.util.Map;

public class  Bank {
    private int nrOfHouses;
    private int nrOfHotels;
    private Map <Integer, Property> properties;

    public Bank() {
        nrOfHouses = 32;
        nrOfHotels = 12;
    }

    public void buyHouses(){}

    public int buyHouses (int amountHouses) {
        int housesBought;
        if (amountHouses > nrOfHouses) {
           housesBought = nrOfHouses;
           nrOfHouses = 0;
        }
        else {
            housesBought = amountHouses;
        }
        return housesBought;
    }

    public int buyHotels (int amountHotels) {
        int hotelsBought;
        if (amountHotels > nrOfHotels) {
            hotelsBought = nrOfHotels;
            nrOfHotels = 0;
        }
        else {
            hotelsBought = amountHotels;
        }
        return hotelsBought;
    }

    public void addProperty(int boardSpaceNumber, Property property) {
        properties.put(boardSpaceNumber, property);
    }
}
