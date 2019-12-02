package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Player.Logic.Player;
import jmol.jasper.Utility.Logic.UserInputReader;

public class Street extends Property {
    private final int PRICE_HOUSE;
    private final int RENT_NO_HOUSES;
    private final int RENT_1_HOUSE;
    private final int RENT_2_HOUSES;
    private final int RENT_3_HOUSES;
    private final int RENT_4_HOUSES;
    private final int RENT_HOTEL;
    private int numberOfHouses;
    private String city;

    public Street(UserInputReader userInputReader, String name, int spaceNr, String type, int nrOfStreetsInCity, int[] values, String city) {
        super(userInputReader, name, spaceNr, type, nrOfStreetsInCity, values);
        this.city = city;
        PRICE_HOUSE = values[1];
        RENT_NO_HOUSES = values[2];
        RENT_1_HOUSE = values[3];
        RENT_2_HOUSES = values[4];
        RENT_3_HOUSES = values[5];
        RENT_4_HOUSES = values[6];
        RENT_HOTEL = values[7];
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
