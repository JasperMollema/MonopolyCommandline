package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Player.Logic.Player;

public class Street extends Property {
    public final int PRICE_HOUSE;
    public final int RENT_NO_HOUSES;
    public final int RENT_1_HOUSE;
    public final int RENT_2_HOUSES;
    public final int RENT_3_HOUSES;
    public final int RENT_4_HOUSES;
    public final int RENT_HOTEL;
    private int numberOfHouses;

    public Street(String name, int spaceNr, MonopolyBoardData.PropertyType propertyType, int value, int priceHouse, int[] rents) {
        super(name, spaceNr, propertyType, value);
        PRICE_HOUSE = priceHouse;
        RENT_NO_HOUSES = rents[0];
        RENT_1_HOUSE = rents[1];
        RENT_2_HOUSES = rents[2];
        RENT_3_HOUSES = rents[3];
        RENT_4_HOUSES = rents[4];
        RENT_HOTEL = rents[5];
    }

    @Override
    public int calculateRent() {
        int rent = 0;
        switch (numberOfHouses) {
            case 0: rent = calculateRentNoHouses();
            break;
            case 1: rent = RENT_1_HOUSE;
            break;
            case 2: rent = RENT_2_HOUSES;
            break;
            case 3: rent = RENT_3_HOUSES;
            break;
            case 4: rent = RENT_4_HOUSES;
            break;
            case 5: rent = RENT_HOTEL;
            break;
        }
        return rent;
    }

    @Override
    public boolean buyProperty(Player player) {
        super.buyProperty(player);

        return true;
    }

    public int buyHouses(int amount) {
        return PRICE_HOUSE;
    }

    private int calculateRentNoHouses() {
        if (cityOwnedBySinglePlayer()) {
            return 2 * RENT_NO_HOUSES;
        }
        return RENT_NO_HOUSES;
    }

    private boolean cityOwnedBySinglePlayer() {
        owner.hasAllInstances(type, nrOfInstances);
        return true;
    }
}
