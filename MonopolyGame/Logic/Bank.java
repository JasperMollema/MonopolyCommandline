package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.*;
import jmol.jasper.Player.Logic.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Bank {
    private int nrOfHouses;
    private int nrOfHotels;
    private final int NR_OF_HOUSES = 32;
    private final int NR_OF_HOTELS = 12;
    private List<Street> onsDorp;
    private List<Street> arnhem;
    private List<Street> haarlem;
    private List<Street> utrecht;
    private List<Street> groningen;
    private List<Street> denHaag;
    private List<Street> rotterdam;
    private List<Street> amsterdam;
    private List<Utility> nutsBedrijven;
    private List<Station> stations;
    private List<Property> bankProperties;
    private Map<Player, List<Station>> playerStationMap;
    private Map<Player, List<Property>> playerPropertyMap;
    private Map<Player, Map<MonopolyBoardData.BoardspaceType, Boolean>> playerOwnsAllTypes;

    public Bank() {
        nrOfHouses = NR_OF_HOUSES;
        nrOfHotels = NR_OF_HOTELS;
        onsDorp = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_DORP);
        arnhem = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_ARHNEM);
        haarlem = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_HAARLEM);
        utrecht = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_UTRECHT);
        groningen = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_GRONINGEN);
        denHaag = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_DEN_HAAG);
        rotterdam = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_ROTTERDAM);
        amsterdam = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_AMSTERDAM);
        nutsBedrijven = new Board<Utility>().getBoardspaceList(MonopolyBoardData.BoardspaceType.UTILITY);
        stations = new Board<Station>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STATION);
        bankProperties = new ArrayList<>();
        bankProperties.addAll(onsDorp);
        bankProperties.addAll(arnhem);
        bankProperties.addAll(haarlem);
        bankProperties.addAll(utrecht);
        bankProperties.addAll(groningen);
        bankProperties.addAll(denHaag);
        bankProperties.addAll(rotterdam);
        bankProperties.addAll(amsterdam);
        bankProperties.addAll(stations);
        bankProperties.addAll(nutsBedrijven);
        playerOwnsAllTypes = new HashMap<>();
        playerStationMap = new HashMap<>();
    }

    public void buyPropertyFromBank(Player player, Property property) {
        playerPropertyMap.get(player).add(property);
        bankProperties.remove(property);
        MonopolyBoardData.BoardspaceType boardspaceType = property.getBoardspaceType();
        addPropertyToOwnedTypes(player, boardspaceType);
        if (stations.contains(property)) {
            buyStation((Station) property, player);
        }
    }

    /**
     * Gets all streets of which the player ownes the whole city.
     * @param player
     * @return List with all te streets owned by the player.
     */
    public List<Street> getOwnedCities(Player player) {
        List<Street> ownedStreets = new ArrayList<>();
        for (Property property : playerPropertyMap.get(player)) {
            if (isStreet(property) && ownesAllTypes(player, property)) {
                ownedStreets.add((Street) property);
            }
        }
        return ownedStreets;
    }

    /**
     * Gets all the owned streets of a particular owned BoardspaceTypeCity.
     * @param player
     * @param boardspaceType
     * @return
     */
    public List<Street> getOwnedCities(Player player, MonopolyBoardData.BoardspaceType boardspaceType) {
        List<Street> streets = new ArrayList<>();
        if (playerPropertyMap.get(player) == null || !boardspaceType.getIsCity()) {
            return null;
        }
        for (Property property : playerPropertyMap.get(player)) {
            if (property.getBoardspaceType().equals(boardspaceType)) {
                streets.add((Street)property);
            }
        }
        return streets;
    }

    public List<MonopolyBoardData.BoardspaceType> getOwnedCitiesBoardSpaceTypes (Player player) {
        List<MonopolyBoardData.BoardspaceType> boardspaceTypeList = new ArrayList<>();
        if (playerOwnsAllTypes.get(player) == null) {
            return null;
        }
        Map<MonopolyBoardData.BoardspaceType, Boolean> ownedBoardSpaceTypes = playerOwnsAllTypes.get(player);
        for (MonopolyBoardData.BoardspaceType boardspaceType : ownedBoardSpaceTypes.keySet()) {
            if (playerOwnsAllTypes.get(player).get(boardspaceType) && boardspaceType.getIsCity()) {
                boardspaceTypeList.add(boardspaceType);
            }
        }
        return boardspaceTypeList;
    }

    public void fillPlayerlistMap(List<Player> playerList) {
        playerPropertyMap = new HashMap<>();
        for (Player player : playerList) {
            List<Property> propertyList = new ArrayList<>();
            playerPropertyMap.put(player, propertyList);
        }
    }

    public void buyHouses(int amount) {
        nrOfHouses -= amount;
    }

    public void buyHotel(int amount) { nrOfHotels -= amount;}

    public void sellHouses(int amount) {
        nrOfHouses += amount;
    }

    public void sellHotel() {
        nrOfHotels--;
    }

    private boolean isStreet(Property property) {
        return !(stations.contains(property) || nutsBedrijven.contains(property));
    }

    private void buyStation(Station station, Player player) {
        List<Station> ownedStations = playerStationMap.get(player);
        if (ownedStations == null) {
            ownedStations = new ArrayList<>();
        }
        ownedStations.add(station);
        playerStationMap.put(player, ownedStations);
    }

    private boolean ownesAllTypes(Player player, Property property) {
        if (playerOwnsAllTypes.get(player) == null) {
            return false;
        }
        return playerOwnsAllTypes.get(player).get(property.getBoardspaceType());
    }

    private void addPropertyToOwnedTypes(Player player, MonopolyBoardData.BoardspaceType boardspaceType) {
        if (playerOwnsAllTypes.get(player) == null) {
            playerOwnsAllTypes.put(player, new HashMap<>());
        }
        int nrOfBoardspaceTypes = boardspaceType.getNrOfTypes();
        int ownedTypes = 0;
        for (Property property : playerPropertyMap.get(player)) {
            if (property.getBoardspaceType().equals(boardspaceType)) {
                ownedTypes++;
            }
        }
        Boolean ownesAllTypes = nrOfBoardspaceTypes == ownedTypes;
        playerOwnsAllTypes.get(player).put(boardspaceType, ownesAllTypes);
    }

    public int getNrOfHouses() {
        return nrOfHouses;
    }

    public int getNrOfHotels() {
        return nrOfHotels;
    }

    public boolean getOwnesAllTypes(Property property, Player player) {
        if ((playerOwnsAllTypes.get(player) == null)) {
            return false;
        }
        Boolean ownesAllTypes = playerOwnsAllTypes.get(player).get(property);
        if (ownesAllTypes == null) {
            return false;
        }
        return ownesAllTypes;
    }

    public int getNrOFStationsOwned(Player player) {
        if (playerStationMap.get(player) == null) {
            return 0;
        }
        else return playerStationMap.get(player).size();
    }
}
