package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.*;
import jmol.jasper.Player.Logic.Player;

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
    }

    public void buyProperty() {

    }
}
