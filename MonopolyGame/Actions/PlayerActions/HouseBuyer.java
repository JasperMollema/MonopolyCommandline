package jmol.jasper.MonopolyGame.Actions.PlayerActions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;

import java.util.List;

public class HouseBuyer {
    private static int MAX_AMOUNT_OF_HOUSES = 5;

    public HouseBuyer() {
    }

    public int determineHowManyHousesCanBeBought(Street street, List<Street> city) {
        int currentAmtHouses = street.getNumberOfHouses();
        int minHouseInCity = BuySellHouseHelper.getMinAmtOfHousesInCity(city);
        boolean onlyOneMin = BuySellHouseHelper.onlyStreetWithAmtHouses(city, minHouseInCity);
        int amount = 1;

        if (currentAmtHouses == minHouseInCity && onlyOneMin) {
            amount = 2;
        }

        if (currentAmtHouses > minHouseInCity) {
            amount = 0;
        }

        if ((currentAmtHouses + amount) > MAX_AMOUNT_OF_HOUSES) {
            amount = MAX_AMOUNT_OF_HOUSES - currentAmtHouses;
        }
        return amount;
    }

    public TransactionType determineTransactionType(Street streetToBuyHouses, int amountToBuy) {
        int housesOnStreet = streetToBuyHouses.getNumberOfHouses();

        if (housesOnStreet < 4 && amountToBuy == 1) {
            return TransactionType.ONE_HOUSE;
        }

        else if (housesOnStreet == 4) {
            return TransactionType.HOTEL;
        }

        else if (housesOnStreet == 3 && amountToBuy == 2) {
            return TransactionType.HOUSE_AND_HOTEL;
        }

        else {
            return TransactionType.TWO_HOUSES;
        }
    }

//    public boolean buyHouseOrHotel(Street street) {
//        // Calculate how many houses the player can buy (can only be 1 or 2).
//        int amtCanBeBought = 3;
//        int amountToBeBought = getHowManyToBeBought(street, amtCanBeBought);
//        if (amountToBeBought == 0) {
//            return false;
//        }
//
//        else if (street.getNumberOfHouses() == 4 ) {
//            buyHotel(street, amountToBeBought);
//        }
//
//        else if (street.getNumberOfHouses() == 3 && amountToBeBought == 2) {
//            buyHouse(street,1);
//            buyHotel(street, 1);
//        }
//
//        else {
//            buyHouse(street, amountToBeBought);
//        }
//
//        return true;
//    }
//
//    private int getHowManyToBeBought(Street street, int amountCanBeBought) {
//
//    }
//
//    private void buyHotel(Street street, int amount) {
//        if (bank.getNrOfHotels() < amount) {
//            System.out.println("De bank heeft geen hotels meer!");
//            return;
//        }
//        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
//            System.out.println("Je hebt niet genoeg geld!");
//            return;
//        }
//
//        if (verifyBuy(street, amount, true))
//
//            bank.buyHotel(amount);
//        player.payMoney(street.PRICE_HOUSE * amount);
//        street.buyHouses(amount);
//        confirmBuy(street, amount, true);
//        filterStreets();
//    }
//
//    private void buyHouse(Street street, int amount) {
//        bank.getNrOfHouses(); bank.buyHouses(bank.getNrOfHouses());
//        if (bank.getNrOfHouses() < amount) {
//            System.out.println("De bank heeft niet genoeg huizen!");
//            return;
//        }
//        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
//            System.out.println("Je hebt niet genoeg geld!");
//            return;
//        }
//
//        if (!verifyBuy(street, amount, false)) {
//            return;
//        }
//
//        bank.buyHouses(amount);
//        player.payMoney(street.PRICE_HOUSE * amount);
//        street.buyHouses(amount);
//        confirmBuy(street, amount, false);
//        filterStreets();
//    }
//
//
//
//    private void confirmBuy(Street street, int amount, boolean isHotel) {
//        if (isHotel) {
//            System.out.println(player.getName() + " heeft een hotel gekocht voor " + street.getName());
//        }
//        else if (amount > 1) {
//            System.out.println(player.getName() + " heeft " + amount +
//                    " huizen gekocht voor " + street.getName());
//        }
//        else {
//            System.out.println(player.getName() + " heeft een huis gekocht voor " + street.getName());
//        }
//    }
//
//    private boolean verifyBuy() {return true;}
//
//    private void filterStreets() {
//        streetsWhereHousesCanBeBought.clear();
//        for (Street street : ownedStreets) {
//            if (verifyBuy()) {
//                streetsWhereHousesCanBeBought.add(street);
//            }
//            else {
//                streetsWhereHousesCanBeBought.remove(street);
//            }
//        }
//    }
}
