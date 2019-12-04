package jmol.jasper.MonopolyBoard.Logic;

public class BoardspaceBuilder {
    private String name;
    private int spaceNr;
    private int value;
    private int nrOfInstances;
    private int priceHouse;
    private int rentNoHouses;
    private int rentForOneHouse;
    private int rentForTwoHouses;
    private int rentForThreeHouses;
    private int rentForFourHouses;
    private int rentForHotel;
    private String type;
    private int taxAmount;

    public Boardspace build() {
        return new Boardspace(name, spaceNr, value, nrOfInstances, priceHouse, rentNoHouses, rentForOneHouse,
                rentForTwoHouses, rentForThreeHouses, rentForFourHouses, rentForHotel, type, taxAmount);
    }

    public BoardspaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BoardspaceBuilder setSpaceNr(int spaceNr) {
        this.spaceNr = spaceNr;
        return this;
    }

    public BoardspaceBuilder setValue(int value) {
        this.value = value;
        return this;
    }

    public BoardspaceBuilder setNrOfInstances(int nrOfInstances) {
        this.nrOfInstances = nrOfInstances;
        return this;
    }

    public BoardspaceBuilder setPriceHouse(int priceHouse) {
        this.priceHouse = priceHouse;
        return this;
    }

    public BoardspaceBuilder setRentNoHouses(int rentNoHouses) {
        this.rentNoHouses = rentNoHouses;
        return this;
    }

    public BoardspaceBuilder setRentForOneHouse(int rentForOneHouse) {
        this.rentForOneHouse = rentForOneHouse;
        return this;
    }

    public BoardspaceBuilder setRentForTwoHouses(int rentForTwoHouses) {
        this.rentForTwoHouses = rentForTwoHouses;
        return this;
    }

    public BoardspaceBuilder setRentForThreeHouses(int rentForThreeHouses) {
        this.rentForThreeHouses = rentForThreeHouses;
        return this;
    }

    public BoardspaceBuilder setRentForFourHouses(int rentForFourHouses) {
        this.rentForFourHouses = rentForFourHouses;
        return this;
    }

    public BoardspaceBuilder setRentForHotel(int rentForHotel) {
        this.rentForHotel = rentForHotel;
        return this;
    }

    public BoardspaceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public BoardspaceBuilder setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }
}
