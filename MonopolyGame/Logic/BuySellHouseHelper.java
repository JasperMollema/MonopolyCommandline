package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.MonopolyBoardData;
import jmol.jasper.MonopolyBoard.Logic.Street;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.List;

public class BuySellHouseHelper {


    public Street[] convertStreetListToArray(List<Street> streetList) {
        Street[] ownedStreets = new Street[streetList.size()];
        int i = 0;
        for (Street street : streetList) {
            ownedStreets[i] = street;
            i++;
        }
        return ownedStreets;
    }

    public Street askWhichStreetPerformAction(Street[] streets, String question) {
        String[] streetOptions = new String[streets.length];
        for (int i = 0; i<streets.length; i++) {
            streets[i].printNumberOfHouses();
            streetOptions[i] = streets[i].getName();
        }
        int choice = ExpressionProvider.getInstance().getOption(streetOptions, question);
        return streets[choice];
    }

    public boolean onlyStreetWithAmtHouses(List<Street> streets, int amountHouses) {
        int sum = 0;
        for (Street street: streets) {
            if (street.getNumberOfHouses() == amountHouses) {
                sum += 1;
            }
        }
        return sum == 1;
    }

    public boolean everyStreetSameAmtHouses(List<Street> streets) {
        int amtHouses = streets.get(0).getNumberOfHouses();
        for (Street street : streets) {
            if (street.getNumberOfHouses() != amtHouses) {
                return false;
            }
        }
        return true;
    }

    public boolean onlyOneStreetWithHouses(List<Street> streets) {
        int sum = 0;
        for (Street street : streets) {
            if (street.getNumberOfHouses() > 0) {
                sum += 1;
            }
        }
        return sum == 1;
    }

    public int getMinAmtOfHousesInCity(List<Street> streets) {
        int minAmountOfHouses = streets.get(0).getNumberOfHouses();
        for (Street street: streets) {
            if (street.getNumberOfHouses() < minAmountOfHouses) {
                minAmountOfHouses = street.getNumberOfHouses();
            }
        }
        return minAmountOfHouses;
    }

    public int getMaxAmtOfHousesInCity(List<Street> streets) {
        int maxAmtOfHouses = streets.get(0).getNumberOfHouses();
        for (Street street: streets) {
            if (street.getNumberOfHouses() > maxAmtOfHouses) {
                maxAmtOfHouses = street.getNumberOfHouses();
            }
        }
        return maxAmtOfHouses;
    }

    public List<Street> askForWhichCity(Bank bank, Player player) {
        List<MonopolyBoardData.BoardspaceType> cities = bank.getOwnedCitiesBoardSpaceTypes(player);
        String[] ownedCities = new String[cities.size()];

        if (cities == null) {
            return null;
        }

        for (int i = 0; i < cities.size(); i++) {
            ownedCities[i] = cities.get(i).getName();
        }
        int cityIndex = ExpressionProvider.getInstance().getOption(ownedCities, "Voor welke stad?");
        return bank.getOwnedCities(player, cities.get(cityIndex));
    }
}
