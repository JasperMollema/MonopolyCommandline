package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Board;
import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Street;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;
import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.List;

public class BuyHousesAction extends PlayerAction {
    private final int MAX_AMOUNT_OF_HOUSES = 5;
    @Override
    public void handleAction(Bank bank, Player player, Boardspace boardspace, UserInputReader userInputReader) {
        // Check for which streets the player can buy houses
        List<Street> possibleBuyOptions = bank.getOwnedCities(player);
        if (possibleBuyOptions.size()== 0) {
            System.out.println("Je hebt geen straten waarvoor je huizen kan kopen!");
            return;
        }
        Street[] ownedStreets = convertStreetListToArray(possibleBuyOptions);

        // Ask player for which streets he wants to buy houses.
        Street street = askWhichStreetToBuyHouse(ownedStreets);

        // Calculate how many houses the player can buy (can only be 1 or 2).
        int amtCanBeBought = calculateHowManyHousesAllowed(street);

        int amount =ExpressionProvider.getInstance().getNumberWithinBoundary(
                "Hoeveel huizen wil je kopen?",
                0,
                amtCanBeBought,
                "Je kan minimaal 0 en maximaal " + amtCanBeBought + " huizen kopen."
        );

        if (street.getNumberOfHouses() == 4 ) {
            buyHotel(player, street, bank, amount);
        }

        if (street.getNumberOfHouses() == 3 && amount == 2) {
            buyHouse(player, street, bank, 1);
            buyHotel(player, street, bank, 1);
        }

        else buyHouse(player, street, bank, amount);
    }

    private void buyHotel(Player player, Street street, Bank bank, int amount) {
        if (bank.getNrOfHotels() < amount) {
            System.out.println("De bank heeft geen hotels meer!");
            return;
        }
        if (player.canAffordPayment(street.PRICE_HOUSE * amount)) {
            System.out.println("Je hebt niet genoeg geld!");
        }
        bank.buyHotel(amount);
        player.payMoney(street.PRICE_HOUSE * amount);
        street.buyHouses(amount);
    }

    private void buyHouse(Player player, Street street, Bank bank, int amount) {

    }

    private int calculateHowManyHousesAllowed(Street street) {
        List<Street> city = new Board<Street>().getBoardspaceList(street.getBoardspaceType());
        int currentAmtHouses = street.getNumberOfHouses();
        int minHouseInCity = getMinAmtOfHousInCity(city);
        boolean onlyOneMin = onlyStreetWithAmtHouses(city, minHouseInCity);
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

    private boolean onlyStreetWithAmtHouses(List<Street> streets, int amountHouses) {
        int sum = 0;
        for (Street street: streets) {
            if (street.getNumberOfHouses() == amountHouses) {
                sum += 1;
            }
        }
        return sum == 1;
    }

    private int getMinAmtOfHousInCity(List<Street> streets) {
        int minAmountOfHouses = streets.get(0).getNumberOfHouses();
        for (Street street: streets) {
            if (street.getNumberOfHouses() < minAmountOfHouses) {
                minAmountOfHouses = street.getNumberOfHouses();
            }
        }
        return minAmountOfHouses;
    }

    private Street[] convertStreetListToArray(List<Street> streetList) {
        Street[] ownedStreets = new Street[streetList.size()];
        int i = 0;
        for (Street street : streetList) {
            ownedStreets[i] = street;
            i++;
        }
        return ownedStreets;
    }

    private Street askWhichStreetToBuyHouse(Street[] streets) {
        String[] streetOptions = new String[streets.length];
        for (int i = 0; i<streets.length; i++) {
            streets[i].printNumberOfHouses();
            streetOptions[i] = streets[i].getName();
        }
        int choice = ExpressionProvider.getInstance().getOption(streetOptions, "Voor welke straat wil je huizen kopen?");
        return streets[choice];
    }
}
