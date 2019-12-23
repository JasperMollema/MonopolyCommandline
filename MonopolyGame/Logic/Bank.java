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
    private List<Property> properties;
    private Map <Player, List<Property>> playerListMap;

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
        properties = new ArrayList<>();
        properties.addAll(onsDorp);
        properties.addAll(arnhem);
        properties.addAll(haarlem);
        properties.addAll(utrecht);
        properties.addAll(groningen);
        properties.addAll(denHaag);
        properties.addAll(rotterdam);
        properties.addAll(amsterdam);
        properties.addAll(stations);
        properties.addAll(nutsBedrijven);
    }

    public boolean buyProperty(Player player, Property property) {
        // Check if player already owns the property.
        if (playerListMap.get(player).contains(property)) {
            return false;
        }

        // Check if the Bank owns the property.
        if (!properties.contains(property)) {
            return false;
        }
        if (!(player.buyProperty(property, property.VALUE))) {
            return false;
        }
        if (!(property.buyProperty(player))) {
            return false;
        }
        playerListMap.get(player).add(property);
        System.out.println(player.getName() + " is nu eigendom van: " + property.getName());
        return true;
    }

    public void fillPlayerlistMap(List<Player> playerList) {
        playerListMap = new HashMap<>();
        for (Player player : playerList) {
            List <Property> propertyList = new ArrayList<>();
            playerListMap.put(player, propertyList);
        }
    }
}
