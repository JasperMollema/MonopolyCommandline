package jmol.jasper.MonopolyBoard.Logic;

public class MonopolyBoardData {
    /**
     * The Monopoly board.
     */
    public static final Boardspace[] monopolyBoard;

    /**
     * The names of the boardspaces.
     */
    public static final String START = "Start";
    public static final String DORPSSTRAAT = "Dorpsstraat";
    public static final String ALGEMEEN_FONDS_1 = "Algemeen Fonds";
    public static final String BRINK = "Brink";
    public static final String INKOMSTENBELASTING = "Inkomstenbelasting";
    public static final String STATION_ZUID = "Station Zuid";
    public static final String STEENSTRAAT = "Steenstraat";
    public static final String KETELSTRAAT = "Ketelstraat";
    public static final String VELPERPLEIN = "Velperplein";
    public static final String GEVANGENIS = "Gevangenis";
    public static final String BARTELJORISSTRAAT = "Barteljorisstraat";
    public static final String ELEKTRICITEITSBEDRIJF = "Elektriciteitsbedrijf";
    public static final String ZIJLWEG = "Zijlweg";
    public static final String GROTE_HOUTSTRAAT = "Grote Houtstraat";
    public static final String STATION_WEST = "Station West";
    public static final String NEUDE = "Neude";
    public static final String BILTSTRAAT = "Biltstraat";
    public static final String VREEBURG = "Vreeburg";
    public static final String VRIJ_PARKEREN = "Vrij parkeren";
    public static final String A_KERKHOF = "A Kerkhof";
    public static final String GROTE_MARKT = "Grote Markt";
    public static final String HEERESTRAAT = "Heerestraat";
    public static final String STATION_NOORD = "Station Noord";
    public static final String SPUI = "Spui";
    public static final String PLEIN = "Plein";
    public static final String WATERLEIDING = "Waterleiding";
    public static final String LANGE_POTEN = "Lange Poten";
    public static final String GA_NAAR_DE_GEVANGENIS = "Ga naar de gevangenis";
    public static final String HOFPLEIN = "Hofplein";
    public static final String BLAAK = "Blaak";
    public static final String COOLSINGEL = "Coolsingel";
    public static final String STATION_OOST = "Station Oost";
    public static final String LEIDSE_PLEIN = "Leidse Plein";
    public static final String LUXE_BELASTING = "Luxe belasting";
    public static final String KALVERSTRAAT = "Kalverstraat";
    public static final String KANS = "Kans";
    public static final String ALGEMEEN_FONDS = "Algemeen Fonds";

    /**
     * The indexes of the boardspaces.
     */
    public static final int SPACENR_START = 0;
    public static final int SPACENR_DORPSSTRAAT = 1;
    public static final int SPACENR_ALGEMEEN_FONDS_1 = 2;
    public static final int SPACENR_BRINK = 3;
    public static final int SPACENR_INKOMSTENBELASTING = 4;
    public static final int SPACENR_STATION_ZUID = 5;
    public static final int SPACENR_STEENSTRAAT = 6;
    public static final int SPACENR_KANS_1 = 7;
    public static final int SPACENR_KETELSTRAAT = 8;
    public static final int SPACENR_VELPERPLEIN = 9;
    public static final int SPACENR_GEVANGENIS = 10;
    public static final int SPACENR_BARTELJORISSTRAAT = 11;
    public static final int SPACENR_ELEKTRICITEITSBEDRIJF = 12;
    public static final int SPACENR_ZIJLWEG = 13;
    public static final int SPACENR_GROTE_HOUTSTRAAT = 14;
    public static final int SPACENR_STATION_WEST = 15;
    public static final int SPACENR_NEUDE = 16;
    public static final int SPACENR_ALGEMEEN_FONDS_2 = 17;
    public static final int SPACENR_BILTSTRAAT = 18;
    public static final int SPACENR_VREEBURG = 19;
    public static final int SPACENR_VRIJ_PARKEREN = 20;
    public static final int SPACENR_A_KERKHOF = 21;
    public static final int SPACENR_KANS_2 = 22;
    public static final int SPACENR_GROTE_MARKT = 23;
    public static final int SPACENR_HEERESTRAAT = 24;
    public static final int SPACENR_STATION_NOORD = 25;
    public static final int SPACENR_SPUI = 26;
    public static final int SPACENR_PLEIN = 27;
    public static final int SPACENR_WATERLEIDING = 28;
    public static final int SPACENR_LANGE_POTEN = 29;
    public static final int SPACENR_GA_NAAR_DE_GEVANGENIS = 30;
    public static final int SPACENR_HOFPLEIN = 31;
    public static final int SPACENR_BLAAK = 32;
    public static final int SPACENR_ALGEMEEN_FONDS_3 = 33;
    public static final int SPACENR_COOLSINGEL = 34;
    public static final int SPACENR_STATION_OOST = 35;
    public static final int SPACENR_KANS_3 = 36;
    public static final int SPACENR_LEIDSE_PLEIN = 37;
    public static final int SPACENR_LUXE_BELASTING = 38;
    public static final int SPACENR_KALVERSTRAAT = 39;

    /**
     * De property types.
     */
    public enum PropertyType{STATION(4), UTILITY(2), STREET_DORP(2),
        STREET_ARHNEM(3), STREET_HAARLEM(3), STREET_UTRECHT(3),
        STREET_GRONINGEN(3), STREET_DEN_HAAG(3), STREET_ROTTERDAM(3), STREET_AMSTERDAM(2);

    private int nrOfTypes;

    private PropertyType(int nrOfTypes) {
        this.nrOfTypes = nrOfTypes;
    }
        public int getNrOfTypes() {
            return nrOfTypes;
        }
    }

    /**
     * The rent for zero to five houses.
     */
    public static final int[] DORP_HUUR_NORMAAL = new int[]{2, 10, 30, 90, 160, 250};
    public static final int[] DORP_HUUR_DUUR = new int[]{4, 20 ,60, 180, 320, 450};
    public static final int[] ARNHEM_HUUR_NORMAAL = new int[]{6, 30, 90, 270, 400, 550};
    public static final int[] ARNHEM_HUUR_DUUR = new int[]{8, 40, 120, 360, 450, 600};
    public static final int[] HAARLEM_HUUR_NORMAAL = new int[]{10, 50, 150, 450, 625, 750};
    public static final int[] HAARLEM_HUUR_DUUR = new int[]{12, 60, 180, 500, 700, 900};
    public static final int[] UTRECHT_HUUR_NORMAAL = new int[]{14, 70, 200, 550, 750, 950};
    public static final int[] UTRECHT_HUUR_DUUR = new int[]{16, 80, 220, 600, 800, 1000};
    public static final int[] GRONINGEN_HUUR_NORMAAL = new int[]{18, 90, 250, 700, 875, 1050};
    public static final int[] GRONINGEN_HUUR_DUUR = new int[]{20, 100, 300, 750, 925, 1100};
    public static final int[] DEN_HAAG_HUUR_NORMAAL = new int[]{22, 110, 330, 800, 975, 1150};
    public static final int[] DEN_HAAG_HUUR_DUUR = new int[]{24, 120, 360, 850, 1025, 1200};
    public static final int[] ROTTERDAM_HUUR_NORMAAL = new int[]{26, 130, 390, 900, 1100, 1275};
    public static final int[] ROTTERDAM_HUUR_DUUR = new int[]{28, 150, 450, 1000, 1200, 1400};
    public static final int[] AMSTERDAM_HUUR_NORMAAL = new int[]{35, 175, 500, 1100, 1300, 1500};
    public static final int[] AMSTERDAM_HUUR_DUUR = new int[]{50, 200, 600, 1400, 1700, 2000};

    /**
     * The houseprices.
     */
    public static final int DORP_ARHNEM_HUISPRIJS = 50;
    public static final int HAARLEM_UTRECHT_HUISPRIJS = 100;
    public static final int GRONINGEN_DEN_HAAG_HUISPRIJS = 150;
    public static final int ROTTERDAM_AMSTERDAM_HUISPRIJS = 200;

    /**
     * The values of the property.
     */
    public static final int DORP_WAARDE_NORMAAL = 60;
    public static final int DORP_WAARDE_DUUR = 60;
    public static final int ARNHEM_WAARDE_NORMAAL = 100;
    public static final int ARNHEM_WAARDE_DUUR = 120;
    public static final int HAARLEM_WAARDE_NORMAAL = 140;
    public static final int HAARLEM_WAARDE_DUUR = 160;
    public static final int UTRECHT_WAARDE_NORMAAL = 180;
    public static final int UTRECHT_WAARDE_DUUR = 200;
    public static final int GRONINGEN_WAARDE_NORMAAL = 220;
    public static final int GRONINGEN_WAARDE_DUUR = 240;
    public static final int DEN_HAAG_WAARDE_NORMAAL = 260;
    public static final int DEN_HAAG_WAARDE_DUUR = 280;
    public static final int ROTTERDAM_WAARDE_NORMAAL = 300;
    public static final int ROTTERDAM_WAARDE_DUUR = 320;
    public static final int AMSTERDAM_WAARDE_NORMAAL = 350;
    public static final int AMSTERDAM_WAARDE_DUUR = 400;
    public static final int STATION_WAARDE = 200;
    public static final int NUTS_WAARDE = 150;

    /**
     * Taxation values.
     */
    public static final int BEDRAG_INKOMENSBELASTING = 200;
    public static final int BEDRAG_LUXE_BELASTING = 400;

    static {
        monopolyBoard = new Boardspace[]{
                new Start(START, SPACENR_START),
                new Street(DORPSSTRAAT, SPACENR_DORPSSTRAAT, PropertyType.STREET_DORP, DORP_WAARDE_NORMAAL, DORP_ARHNEM_HUISPRIJS, DORP_HUUR_NORMAAL)};
                new CommunityChest(ALGEMEEN_FONDS, SPACENR_ALGEMEEN_FONDS_1),
                new Street(BRINK, SPACENR_BRINK, PropertyType.STREET_DORP, DORP_WAARDE_DUUR, DORP_ARHNEM_HUISPRIJS, DORP_HUUR_DUUR),
                new Taxation(INKOMSTENBELASTING, SPACENR_INKOMSTENBELASTING, ),
                new Station("Station Zuid", STATION_ZUID, STATION, 4, STATION_PRIJZEN),
                new Street("Steenstraat", STEENSTRAAT, STRAAT, 3, ARNHEM_PRIJZEN_NORMAAL, ARNHEM),
                new Chance("Kans", KANS_1),
                new Street("Ketelstraat", KETELSTRAAT, STRAAT, 3, ARNHEM_PRIJZEN_NORMAAL, ARNHEM),
                new Street("Velperplein", VELPERPLEIN, STRAAT, 3, ARNHEM_PRIJZEN_DUUR, ARNHEM),
                new Jail("Gevangenis", GEVANGENIS),
                new Street("Barteljorisstraat", BARTELJORISSTRAAT, STRAAT, 3, HAARLEM_PRIJZEN_NORMAAL, HAARLEM),
                new ("Elektriciteitsbedrijf", ELEKTRICITEITSBEDRIJF, NUTSBEDRIJF, 2, NUTS_PRIJZEN),
                new Street("Zijlweg", ZIJLWEG, STRAAT, 3, HAARLEM_PRIJZEN_NORMAAL, HAARLEM),
                new Street("Grote Houtstraat", GROTE_HOUTSTRAAT, STRAAT, 3, HAARLEM_PRIJZEN_DUUR, HAARLEM),
                new Station("Station West", STATION_WEST, STATION, 4, STATION_PRIJZEN),
                new Street("Neude", NEUDE, STRAAT, 3, UTRECHT_PRIJZEN_NORMAAL, UTRRECHT),
                new CommunityChest("Algemeen Fonds", ALGEMEEN_FONDS_2),
                new Street("Biltstraat", BILTSTRAAT, STRAAT, 3, UTRECHT_PRIJZEN_NORMAAL, UTRRECHT),
                new Street("Vreeburg", VREEBURG, STRAAT, 3, UTRECHT_PRIJZEN_DUUR, UTRRECHT),
                new Freeparking("Vrij parkeren", VRIJ_PARKEREN),
                new Street("A Kerkhof", A_KERKHOF, STRAAT, 3, GRONINGEN_PRIJZEN_NORMAAL, GRONINGEN),
                new Chance("Kans", KANS_2),
                new Street("Grote Markt", GROTE_MARKT, STRAAT, 3, GRONINGEN_PRIJZEN_NORMAAL, GRONINGEN),
                new Street("Heerestraat", HEERESTRAAT, STRAAT, 3, GRONINGEN_PRIJZEN_DUUR, GRONINGEN),
                new Station("Station Noord", STATION_NOORD, STATION, 4, STATION_PRIJZEN),
                new Street("Spui", SPUI, STRAAT, 3, DEN_HAAG_PRIJZEN_NORMAAL, DEN_HAAG),
                new Street("Plein", PLEIN, STRAAT, 3, DEN_HAAG_PRIJZEN_NORMAAL, DEN_HAAG),
                new ("Waterleiding", WATERLEIDING, NUTSBEDRIJF, 4, NUTS_PRIJZEN),
                new Street("Lange Poten", LANGE_POTEN, STRAAT, 3, DEN_HAAG_PRIJZEN_DUUR, DEN_HAAG),
                new GoToJail("Ga naar de gevangenis", GA_NAAR_DE_GEVANGENIS),
                new Street("Hofplein", HOFPLEIN, STRAAT, 3, ROTTERDAM_PRIJZEN_NORMAAL, ROTTERDAM),
                new Street("Blaak", BLAAK, STRAAT, 3, ROTTERDAM_PRIJZEN_NORMAAL, ROTTERDAM),
                new CommunityChest("Algemeen Fonds", ALGEMEEN_FONDS_3),
                new Street("Coolsingel", COOLSINGEL, STRAAT, 3, ROTTERDAM_PRIJZEN_DUUR, ROTTERDAM),
                new Station("Station Oost", STATION_OOST, STATION, 4, STATION_PRIJZEN),
                new Chance("Kans", KANS_3),
                new Street("Leidse Plein", LEIDSE_PLEIN, STRAAT, 2, AMSTERDAM_PRIJZEN_NORMAAL, AMSTERDAM),
                new Taxation("Luxe belasting", LUXE_BELASTING, 100),
                new Street("Kalverstraat", KALVERSTRAAT, STRAAT,
                new Street(2, AMSTERDAM_PRIJZEN_DUUR, AMSTERDAM)
        }
}
