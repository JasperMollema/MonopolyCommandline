package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class Board {
    private Boardspace[] boardspaces;

    /**
     * The indexes of the boardspaces.
     */
    private final int START = 0;
    private final int DORPSSTRAAT = 1;
    private final int ALGEMEEN_FONDS_1 = 2;
    private final int BRINK = 3;
    private final int INKOMSTENBELASTING = 4;
    private final int STATION_ZUID = 5;
    private final int STEENSTRAAT = 6;
    private final int KANS_1 = 7;
    private final int KETELSTRAAT = 8;
    private final int VELPERPLEIN = 9;
    private final int GEVANGENIS = 10;
    private final int BARTELJORISSTRAAT = 11;
    private final int ELEKTRICITEITSBEDRIJF = 12;
    private final int ZIJLWEG = 13;
    private final int GROTE_HOUTSTRAAT = 14;
    private final int STATION_WEST = 15;
    private final int NEUDE = 16;
    private final int ALGEMEEN_FONDS_2 = 17;
    private final int BILTSTRAAT = 18;
    private final int VREEBURG = 19;
    private final int VRIJ_PARKEREN = 20;
    private final int A_KERKHOF = 21;
    private final int KANS_2 = 22;
    private final int GROTE_MARKT = 23;
    private final int HEERESTRAAT = 24;
    private final int STATION_NOORD = 25;
    private final int SPUI = 26;
    private final int PLEIN = 27;
    private final int WATERLEIDING = 28;
    private final int LANGE_POTEN = 29;
    private final int GA_NAAR_DE_GEVANGENIS = 30;
    private final int HOFPLEIN = 31;
    private final int BLAAK = 32;
    private final int ALGEMEEN_FONDS_3 = 33;
    private final int COOLSINGEL = 34;
    private final int STATION_OOST = 35;
    private final int KANS_3 = 36;
    private final int LEIDSE_PLEIN = 37;
    private final int LUXE_BELASTING = 38;
    private final int KALVERSTRAAT = 39;

    private final int[] DORP_PRIJZEN_NORMAAL = new int[]{60, 50, 2, 10, 30, 90, 160, 250};
    private final int[] DORP_PRIJZEN_DUUR = new int[]{60, 50, 4, 20 ,60, 180, 320, 450};
    private final int[] ARNHEM_PRIJZEN_NORMAAL = new int[]{100, 50, 6, 30, 90, 270, 400, 550};
    private final int[] ARNHEM_PRIJZEN_DUUR = new int[]{120, 50, 8, 40, 120, 360, 450, 600};
    private final int[] HAARLEM_PRIJZEN_NORMAAL = new int[]{140, 100, 10, 50, 150, 450, 625, 750};
    private final int[] HAARLEM_PRIJZEN_DUUR = new int[]{160, 100, 12, 60, 180, 500, 700, 900};
    private final int[] UTRECHT_PRIJZEN_NORMAAL = new int[]{180, 100, 14, 70, 200, 550, 750, 950};
    private final int[] UTRECHT_PRIJZEN_DUUR = new int[]{200, 100, 16, 80, 220, 600, 800, 1000};
    private final int[] GRONINGEN_PRIJZEN_NORMAAL = new int[]{220, 150, 18, 90, 250, 700, 875, 1050};
    private final int[] GRONINGEN_PRIJZEN_DUUR = new int[]{240, 150, 20, 100, 300, 750, 925, 1100};
    private final int[] DEN_HAAG_PRIJZEN_NORMAAL = new int[]{260, 150, 22, 110, 330, 800, 975, 1150};
    private final int[] DEN_HAAG_PRIJZEN_DUUR = new int[]{280, 150, 24, 120, 360, 850, 1025, 1200};
    private final int[] ROTTERDAM_PRIJZEN_NORMAAL = new int[]{300, 200, 26, 130, 390, 900, 1100, 1275};
    private final int[] ROTTERDAM_PRIJZEN_DUUR = new int[]{320, 200, 28, 150, 450, 1000, 1200, 1400};
    private final int[] AMSTERDAM_PRIJZEN_NORMAAL = new int[]{350, 200, 35, 175, 500, 1100, 1300, 1500};
    private final int[] AMSTERDAM_PRIJZEN_DUUR = new int[]{400, 200, 50, 200, 600, 1400, 1700, 2000};

    private final int[] STATION_PRIJZEN = new int[]{200, 25, 50, 100, 200};
    private final int[] NUTS_PRIJZEN = new int[]{150};

   public Board(UserInputReader userInputReader) {
       boardspaces = new Boardspace[]{
               new Start(userInputReader,"Start", START),
               new Street(userInputReader,"Dorpsstraat",DORPSSTRAAT, "Ons Dorp", 2, DORP_PRIJZEN_NORMAAL),
               new CommunityChest(userInputReader, "Algemeen Fonds", ALGEMEEN_FONDS_1),
               new Street(userInputReader, "Brink", BRINK, "Ons Dorp", 2, DORP_PRIJZEN_DUUR),
               new Taxation(userInputReader, "Inkomstenbelasting", INKOMSTENBELASTING, 200),
               new Station(userInputReader, "Station Zuid", STATION_ZUID, "Station", 4, STATION_PRIJZEN),
               new Street(userInputReader, "Steenstraat", STEENSTRAAT, "Arnhem", 3, ARNHEM_PRIJZEN_NORMAAL),
               new Chance(userInputReader, "Kans", KANS_1),
               new Street(userInputReader, "Ketelstraat", KETELSTRAAT, "Arnhem", 3, ARNHEM_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Velperplein", VELPERPLEIN, "Arnhem", 3, ARNHEM_PRIJZEN_DUUR),
               new Jail(userInputReader, "Gevangenis", GEVANGENIS),
               new Street(userInputReader, "Barteljorisstraat", BARTELJORISSTRAAT, "Haarlem", 3, HAARLEM_PRIJZEN_NORMAAL),
               new Utility(userInputReader, "Elektriciteitsbedrijf", ELEKTRICITEITSBEDRIJF, "Nutsbedrijf", 2, NUTS_PRIJZEN),
               new Street(userInputReader, "Zijlweg", ZIJLWEG, "Haarlem", 3, HAARLEM_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Grote Houtstraat", GROTE_HOUTSTRAAT, "Haarlem", 3, HAARLEM_PRIJZEN_DUUR),
               new Station(userInputReader, "Station West", STATION_WEST, "Station", 4, STATION_PRIJZEN),
               new Street(userInputReader, "Neude", NEUDE, "Utrecht", 3, UTRECHT_PRIJZEN_NORMAAL),
               new CommunityChest(userInputReader, "Algemeen Fonds", ALGEMEEN_FONDS_2),
               new Street(userInputReader, "Biltstraat", BILTSTRAAT, "Utrecht", 3, UTRECHT_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Vreeburg", VREEBURG, "Utrecht", 3, UTRECHT_PRIJZEN_DUUR),
               new Freeparking(userInputReader, "Vrij parkeren", VRIJ_PARKEREN),
               new Street(userInputReader, "A Kerkhof", A_KERKHOF, "Groningen", 3, GRONINGEN_PRIJZEN_NORMAAL),
               new Chance(userInputReader, "Kans", KANS_2),
               new Street(userInputReader, "Grote Markt", GROTE_MARKT, "Groningen", 3, GRONINGEN_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Heerestraat", HEERESTRAAT, "Groningen", 3, GRONINGEN_PRIJZEN_DUUR),
               new Station(userInputReader, "Station Noord", STATION_NOORD, "Station", 4, STATION_PRIJZEN),
               new Street(userInputReader, "Spui", SPUI, "'s-Gravenhage", 3, DEN_HAAG_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Plein", PLEIN, "'s-Gravenhage", 3, DEN_HAAG_PRIJZEN_NORMAAL),
               new Utility(userInputReader, "Waterleiding", WATERLEIDING, "Nutsbedrijf" , 4, NUTS_PRIJZEN),
               new Street(userInputReader, "Lange Poten", LANGE_POTEN, "'s-Gravenhage", 3, DEN_HAAG_PRIJZEN_DUUR),
               new GoToJail(userInputReader, "Ga naar de gevangenis", GA_NAAR_DE_GEVANGENIS),
               new Street(userInputReader, "Hofplein", HOFPLEIN, "Rotterdam", 3, ROTTERDAM_PRIJZEN_NORMAAL),
               new Street(userInputReader, "Blaak", BLAAK, "Rotterdam", 3, ROTTERDAM_PRIJZEN_NORMAAL),
               new CommunityChest(userInputReader, "Algemeen Fonds", ALGEMEEN_FONDS_3),
               new Street(userInputReader, "Coolsingel", COOLSINGEL, "Rotterdam", 3, ROTTERDAM_PRIJZEN_DUUR),
               new Station(userInputReader, "Station Oost", STATION_OOST, "Station", 4, STATION_PRIJZEN),
               new Chance(userInputReader, "Kans", KANS_3),
               new Street(userInputReader, "Leidse Plein", LEIDSE_PLEIN, "Amsterdam", 2, AMSTERDAM_PRIJZEN_NORMAAL),
               new Taxation(userInputReader, "Luxe belasting", LUXE_BELASTING, 100),
               new Street(userInputReader, "Kalverstraat", KALVERSTRAAT, "Amsterdam", 2, AMSTERDAM_PRIJZEN_DUUR)};
   }

    public Boardspace getBoardspace(int index) {
        return boardspaces[index];
    }
}
