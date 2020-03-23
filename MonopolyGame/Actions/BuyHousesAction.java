package jmol.jasper.MonopolyGame.Actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.MonopolyBoard.Data.Board;
import jmol.jasper.MonopolyGame.Logic.BuySellHouseHelper;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.ArrayList;
import java.util.List;

public class BuyHousesAction extends PlayerAction {
    private final int MAX_AMOUNT_OF_HOUSES = 5;
    private BuySellHouseHelper buySellHouseHelper;
    private boolean canBuyHouses;
    private Street[] ownedStreets;
    private List<Street> streetsWhereCanBuyHouses;

    public BuyHousesAction(Player player, Boardspace boardspace) {
        super(player, boardspace);
        buySellHouseHelper = new BuySellHouseHelper();
        streetsWhereCanBuyHouses = new ArrayList<>();
        ownedStreets = buySellHouseHelper.convertStreetListToArray(bank.getOwnedStreetsOfCity(player));
        filterStreets();
        determineCanBuyHouses();
    }

    @Override
    public void handleAction() {
        if (!canBuyHouses) {
            System.out.println("Je hebt geen straten waarvoor je huizen kan kopen!");
            return;
        }
        do {
            buyHouseOfHotel();
            determineCanBuyHouses();
        }
        while (canBuyHouses && ExpressionProvider.getInstance().getBoolean("Wil je nog meer huizen kopen?"));

    }

    private void buyHouseOfHotel() {
        // Ask player for which streets he wants to buy houses.
        Street street = buySellHouseHelper.askWhichStreetPerformAction(
                buySellHouseHelper.convertStreetListToArray(streetsWhereCanBuyHouses),
                "Voor welke straat wil je huizen kopen?");

        // Calculate how many houses the player can buy (can only be 1 or 2).
        int amtCanBeBought = calculateHowManyHousesAllowed(street);
        int amountToBeBought = getHowManyToBeBought(street, amtCanBeBought);
        if (amountToBeBought == 0) {
            return;
        }

        if (street.getNumberOfHouses() == 4 ) {
            buyHotel(street, amountToBeBought);
        }

        else if (street.getNumberOfHouses() == 3 && amountToBeBought == 2) {
            buyHouse(street,1);
            buyHotel(street, 1);
        }

        else buyHouse(street, amountToBeBought);
    }

    private int getHowManyToBeBought(Street street, int amountCanBeBought) {
        if (amountCanBeBought == 0) {
            System.out.println("Je kan geen huizen kopen voor " + street.getName());
            return 0;
        }

        if (amountCanBeBought == 1) {
            System.out.println("Je kan 1 huis kopen voor " + street.getName());
            return 1;
        }

        // There can be 2 houses bought.
        int choice = ExpressionProvider.getInstance().getOption(
                new String[]{"1 huis", "2 huizen"},
                "Wil je 1 of 2 huizen kopen voor " + street.getName());
        return choice + 1;
    }

    private void buyHotel(Street street, int amount) {
        if (bank.getNrOfHotels() < amount) {
            System.out.println("De bank heeft geen hotels meer!");
            return;
        }
        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
            System.out.println("Je hebt niet genoeg geld!");
            return;
        }

        if (verifyBuy(street, amount, true))

        bank.buyHotel(amount);
        player.payMoney(street.PRICE_HOUSE * amount);
        street.buyHouses(amount);
        confirmBuy(street, amount, true);
        filterStreets();
    }

    private void buyHouse(Street street, int amount) {
        if (bank.getNrOfHouses() < amount) {
            System.out.println("De bank heeft niet genoeg huizen!");
            return;
        }
        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
            System.out.println("Je hebt niet genoeg geld!");
            return;
        }

        if (!verifyBuy(street, amount, false)) {
            return;
        }

        bank.buyHouses(amount);
        player.payMoney(street.PRICE_HOUSE * amount);
        street.buyHouses(amount);
        confirmBuy(street, amount, false);
        filterStreets();
    }

    private void confirmBuy(Street street, int amount, boolean isHotel) {
        if (isHotel) {
            System.out.println(player.getName() + " heeft een hotel gekocht voor " + street.getName());
        }
        else if (amount > 1) {
            System.out.println(player.getName() + " heeft " + amount +
                    " huizen gekocht voor " + street.getName());
        }
        else {
            System.out.println(player.getName() + " heeft een huis gekocht voor " + street.getName());
        }
    }

    private boolean verifyBuy(Street street, int amount, boolean isHotel) {
        String question;
        if (isHotel) {
            question =question = "Weet je zeker dat je een hotel wil kopen voor " + street.getName();
        }
        else if (amount == 2) {
            question = "Weet je zeker dat je " + amount + " huizen wil kopen voor " + street.getName();
        }
        else {
            question = "Weet je zeker dat je " + amount + " huis wil kopen voor " + street.getName();
        }
        return ExpressionProvider.getInstance().getBoolean(question);
    }

    private int calculateHowManyHousesAllowed(Street street) {
        List<Street> city = new Board<Street>().getBoardspaceList(street.getBoardspaceType());
        int currentAmtHouses = street.getNumberOfHouses();
        int minHouseInCity = buySellHouseHelper.getMinAmtOfHousesInCity(city);
        boolean onlyOneMin = buySellHouseHelper.onlyStreetWithAmtHouses(city, minHouseInCity);
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

    private void filterStreets() {
        streetsWhereCanBuyHouses.clear();
        for (Street street : ownedStreets) {
            if (calculateHowManyHousesAllowed(street) > 0) {
                streetsWhereCanBuyHouses.add(street);
            }
            else {
                streetsWhereCanBuyHouses.remove(street);
            }
        }
    }

    private void determineCanBuyHouses() {
        canBuyHouses = streetsWhereCanBuyHouses.size() > 0;
    }
}
