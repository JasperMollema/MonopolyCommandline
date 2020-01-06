package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Board;
import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Street;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.ArrayList;
import java.util.List;

public class SellHouseAction extends PlayerAction {
    private boolean hasHouses;
    private Street[] streetsWithHouses;
    private BuySellHouseHelper buySellHouseHelper;
    private String[] cityOrStreet;

    public SellHouseAction(Bank bank, Player player, Boardspace boardspace) {
        super(bank, player, boardspace);
        buySellHouseHelper = new BuySellHouseHelper();
        streetsWithHouses = buySellHouseHelper.convertStreetListToArray(getStreetsWithHouses());
        hasHouses = streetsWithHouses.length > 0;
        cityOrStreet = new String[]{"Enkele straat", "Alle huizen in een stad"};
    }

    @Override
    public void handleAction() {
        if (!hasHouses) {
            System.out.println("Je hebt geen huizen!");
            return;
        }
        do {
            sellHousesOrHotels();
        }
        while (hasHouses && ExpressionProvider.getInstance().getBoolean("Wil je nog meer huizen verkopen?"));
    }

    private void sellHousesOrHotels () {
        if (sellForWholeCity()) {
            sellAllHousesInCity();
        } else {
            sellHousesSingleStreet();
        }
    }


    private void sellAllHousesInCity() {
        List<Street> city = buySellHouseHelper.askForWhichCity(bank, player);
        if (!verifySell(city.get(0),0, true)) {
            return;
        }
        for (Street street : city) {
            sellHouses(street, street.getNumberOfHouses());
        }
    }

    private void sellHousesSingleStreet() {
        Street street = buySellHouseHelper.askWhichStreetPerformAction(
                    streetsWithHouses,
                    "Voor welke straat wil je huizen verkopen?");
        int amtCanBeSold = howManyCanBeSold(street);
        int amtToBeSold = 0;


        if (amtCanBeSold == 0) {
            return;
        }

        if (amtCanBeSold == 1) {
            amtToBeSold = 1;
        }

        if (amtCanBeSold == 2) {
            int choice = ExpressionProvider.getInstance().getOption(
                    new String[]{"1 huis", "2 huizen"},
                    "Wil je 1 of twee huizen verkopen?");
            amtToBeSold += choice + 1;
        }

        if (!verifySell(street, amtToBeSold, false)) {
            return;
        }
        sellHouses(street, amtToBeSold);
    }

    private int howManyCanBeSold(Street street) {
        List<Street> city = new Board<Street>().getBoardspaceList(street.getBoardspaceType());
        int amtOfHouses = street.getNumberOfHouses();
        boolean isMaxAmtHousesInCity = buySellHouseHelper.getMaxAmtOfHousesInCity(city) == amtOfHouses;
        boolean sameAmtOfHousesInCity = buySellHouseHelper.everyStreetSameAmtHouses(city);
        String streetName = street.getName();

        if (isMaxAmtHousesInCity &&
                amtOfHouses > 1 &&
                !sameAmtOfHousesInCity) {
            System.out.println("Je kan voor 2 huizen verkopen voor " + streetName);
            return 2;
        }

        if (buySellHouseHelper.onlyOneStreetWithHouses(city) ||
                sameAmtOfHousesInCity ||
                isMaxAmtHousesInCity) {
            System.out.println("Je kan voor 1 huis verkopen voor " + streetName);
            return 1;
        }

        if (amtOfHouses == buySellHouseHelper.getMinAmtOfHousesInCity(city)) {
            System.out.println("Je kan voor " + streetName + " geen huizen verkopen!");
            return 0;
        }
        return 0;
    }

    private boolean sellForWholeCity() {
        return ExpressionProvider.getInstance().
                getOption(
                        cityOrStreet,
                        "Wil je voor enkele straat of hele stad huizen verkopen")
                == 1;
    }

    private List<Street> getStreetsWithHouses() {
        List<Street> streets = new ArrayList<>();
        List<Street> ownedStreets = bank.getOwnedCities(player);
        for (Street street : ownedStreets) {
            if (street.getNumberOfHouses() > 0) {
                streets.add(street);
            }
        }
        return streets;
    }

    public boolean verifySell(Street street, int amount, boolean sellWholeStreet) {
        String question;
        if (sellWholeStreet) {
            question = "Weet je zeker dat je alle huizen voor "
                    + street.getBoardspaceType().getName()
                    + " wil verkopen?";
        }
        else if (amount > 1) {
            question = "Weet je zeker dat je " + amount + " huizen wil verkopen voor " + street.getName();
        }
        else {
            question = "Weet je zeker dat je " + amount + " huis wil verkopen voor " + street.getName();
        }
        return ExpressionProvider.getInstance().getBoolean(question);
    }

    private void sellHouses(Street street, int amount) {
        int currentAmtHouses = street.getNumberOfHouses();

        if (amount == 5) {
            bank.sellHotel();
            bank.sellHouses(4);
            street.sellAllHouses();
            return;
        }

        if (currentAmtHouses == 5) {
            bank.sellHotel();
            bank.sellHouses(amount - 1);
            street.sellHouses(amount);
            return;
        }
        bank.sellHouses(amount);
        street.sellHouses(amount);
    }
}
