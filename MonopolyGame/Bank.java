package jmol.jasper.MonopolyGame;

public class  Bank {
    private int nrOfHouses;
    private int nrOfHotels;

    public Bank() {
        nrOfHouses = 32;
        nrOfHotels = 12;

    }

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
}
