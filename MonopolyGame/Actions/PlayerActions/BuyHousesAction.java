package jmol.jasper.MonopolyGame.Actions.PlayerActions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.List;

public class BuyHousesAction implements PlayerAction {
    private Bank bank;
    private HouseBuyer houseBuyer;
    private BuySellHousesUserInterface buySellHousesUserInterface;
    private boolean bankHasHouses;
    private boolean bankHasHotels;
    private boolean bankHasOneHouse;

    public BuyHousesAction() {
        bank = new Bank();
        buySellHousesUserInterface = new BuySellHousesUserInterface();
        houseBuyer = new HouseBuyer();
    }

    @Override
    public void handleAction(Player player) {
        // Determine if bank has enough houses.
        setAvailableHousesAndHotels();

        if (!bankHasHouses && !bankHasHotels) {
            buySellHousesUserInterface.printBankHasNoHouses();
            return;
        }

        // Determine which streets the player can buy houses.
        List<Street> streetsWherePlayerCanBuyHouses = bank.getOwnedStreetsOfCity(player);
        Street street = buySellHousesUserInterface.askPlayerWhichStreetToBuyHouses(streetsWherePlayerCanBuyHouses);
        List<Street> city = MonopolyBoardData.getCity(street);

        // Determine how many houses can be bought.
        int nrHousesCanBeBought = houseBuyer.determineHowManyHousesCanBeBought(street, city);

        TransactionType transactionType = houseBuyer.determineTransactionType(street, nrHousesCanBeBought);
        if (!hasBankEnoughForTransactionType(transactionType)) {
            transactionType = determineDefinitiveTransactionType(transactionType);
        }

        buySellHousesUserInterface.askPlayerHowManyHousesToBuy(street.getName(), transactionType);

        if (nrHousesCanBeBought > 1) {
            nrOfHousesToBuy = buySellHousesUserInterface.askPlayerHowManyHousesToBuy(streetToBuyHouses.getName());
        }

        transactionType = houseBuyer.determineTransactionType(streetToBuyHouses, nrOfHousesToBuy);


        // --> confirm amount.

        // Buy the house(s). --> HOUSEBUYER

        // Confirm the transaction.
        // if player wants to buy more houses --> Start again.
        // if player wants to stop buying --> end action.


    }

    private void setAvailableHousesAndHotels() {
        bankHasHouses = bank.getNrOfHouses() > 0;
        bankHasHotels = bank.getNrOfHotels() > 0;
        bankHasOneHouse = bank.getNrOfHouses() == 1;
    }

    private TransactionType determineDefinitiveTransactionType(TransactionType transactionType) {
        if (hasBankEnoughForTransactionType(transactionType)) {
            return transactionType;
        }
        return TransactionType.HOUSE_AND_HOTEL;
    }

    private boolean hasBankEnoughForTransactionType(TransactionType transactionType) {
        return TransactionType.TWO_HOUSES.equals(transactionType) && bankHasHouses && !bankHasOneHouse
                || TransactionType.ONE_HOUSE.equals(transactionType) && bankHasOneHouse
                || TransactionType.HOTEL.equals(transactionType) && bankHasHotels
                || TransactionType.HOUSE_AND_HOTEL.equals(transactionType) && bankHasHouses && bankHasHotels;
     }





    private boolean verifySale(Street street, int amount, boolean isHotel) {
        String question;
        if (isHotel) {
            question = "Weet je zeker dat je een hotel wil kopen voor " + street.getName();
        }
        else if (amount == 2) {
            question = "Weet je zeker dat je 2 huizen wil kopen voor " + street.getName();
        }
        else {
            question = "Weet je zeker dat je 1 huis wil kopen voor " + street.getName();
        }
        return ExpressionProvider.getInstance().getBoolean(question);
    }

    private void verifySale(Street street, int amountHouses) {
        if (amountHouses == 0) {
            System.out.println("Je kan geen huizen kopen voor " + street.getName());
        }

        if (amountHouses == 1) {
            System.out.println("Je kan 1 huis kopen voor " + street.getName());
        }
    }
}
