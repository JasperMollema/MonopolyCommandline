package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.List;

public class Board {
    private MonopolyBoardBuilder monopolyBoardBuilder;
    private Boardspace[] boardspaces;
    private List<Property> properties;
    private List<Street> streets;
    private List<Utility> utilities;
    private List<CardSpace> cardSpaces;



    public void makeBoard() {
        Utility.UtilityBuilder utilityBuilder = new Utility.UtilityBuilder();
        utilityBuilder.setName("Waterleiding").setSpaceNr(WATERLEIDING).setNrOfIdenticalTypes(2).setType(Property.PropertyType.UTILITY).setValue(150);
        Utility waterleiding = utilityBuilder.build();

    }
//    public final int SPACENR_DORP_ARHNEM_HOUSEPRICE = 50
//    public final int SPACENR_ARNHEM_ARHNEM = 100, 50, 6, 30, 90, 270, 400, 550};
//    public final int SPACENR_ARNHEM_HOUSEPRICE_DUUR = 120, 50, 8, 40, 120, 360, 450, 600};
//    public final int SPACENR_HAARLEM_ARHNEM = 140, 100, 10, 50, 150, 450, 625, 750};
//    public final int SPACENR_HAARLEM_HOUSEPRICE_DUUR = 160, 100, 12, 60, 180, 500, 700, 900};
//    public final int SPACENR_UTRECHT_ARHNEM = 180, 100, 14, 70, 200, 550, 750, 950};
//    public final int SPACENR_UTRECHT_HOUSEPRICE_DUUR = 200, 100, 16, 80, 220, 600, 800, 1000};
//    public final int SPACENR_GRONINGEN_ARHNEM = 220, 150, 18, 90, 250, 700, 875, 1050};
//    public final int SPACENR_GRONINGEN_HOUSEPRICE_DUUR = 240, 150, 20, 100, 300, 750, 925, 1100};
//    public final int SPACENR_DEN_HAAG_ARHNEM = 260, 150, 22, 110, 330, 800, 975, 1150};
//    public final int SPACENR_DEN_HAAG_HOUSEPRICE_DUUR = 280, 150, 24, 120, 360, 850, 1025, 1200};
//    public final int SPACENR_ROTTERDAM_ARHNEM = 300, 200, 26, 130, 390, 900, 1100, 1275};
//    public final int SPACENR_ROTTERDAM_HOUSEPRICE_DUUR = 320, 200, 28, 150, 450, 1000, 1200, 1400};
//    public final int SPACENR_AMSTERDAM_ARHNEM = 350, 200, 35, 175, 500, 1100, 1300, 1500};
//    public final int SPACENR_AMSTERDAM_HOUSEPRICE_DUUR = 400, 200, 50, 200, 600, 1400, 1700, 2000};


   public Board(UserInputReader userInputReader) {


   public Boardspace getBoardspace(int index) {
       return boardspaces[index];
    }
}
