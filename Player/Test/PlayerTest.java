//package jmol.jasper.Player.Test;
//
//import jmol.jasper.MonopolyBoard.Logic.Station;
//import jmol.jasper.MonopolyBoard.Logic.Street;
//import jmol.jasper.Player.Logic.Player;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PlayerTest {
//    private Player player1;
//    private Player player2;
//    private String cityProperty = "Stad";
//    private String stationProperty = "Station";
//    private Station station1;
//    private Station station2;
//    private Station station3;
//    private Street street1;
//    private Street street2;
//    private final int VALUE_STATION = 200;
//    private final int VALUE_STREET_1 = 100;
//    private final int VALUE_STREET_2 = 150;
//    private final int NR_OF_STREETS = 2;
//    private final int NR_OF_STATIONS = 3;
//
//   @BeforeEach
//   void init(){
////        player1 = new Player("Speler 1");
////        player2 = new Player("Speler 2");
////        street1 = new Street(null, "Straat1", 1, cityProperty, NR_OF_STREETS, new int[]{VALUE_STREET_1, 0, 0, 0, 0, 0, 0, 0}, "");
////        street2 = new Street(null, "Straat2", 2, cityProperty, NR_OF_STREETS, new int[]{VALUE_STREET_2, 0, 0, 0, 0, 0, 0, 0},"");
////        station1 = new Station(null, "Station1", 3, stationProperty,NR_OF_STATIONS, new int[]{VALUE_STATION});
////        station2 = new Station(null, "Station2", 4, stationProperty,NR_OF_STATIONS, new int[]{VALUE_STATION});
////        station3 = new Station(null, "Station2", 5, stationProperty,NR_OF_STATIONS, new int[]{VALUE_STATION});
//    }
//
//    @Test
//    void testHasAllInstances() {
//       player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//       assertFalse(player1.hasAllInstances(cityProperty,NR_OF_STREETS));
//
//       player1.buyPropertyFromBank(street2, VALUE_STREET_2);
//
//       assertTrue(player1.hasAllInstances(cityProperty, NR_OF_STREETS));
//    }
//
//    @Test
//    void testGetNrOfInstances() {
//       assertEquals(0, player1.getOwnedInstances(cityProperty));
//
//       player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//       assertEquals(1, player1.getOwnedInstances(cityProperty));
//    }
//
//    @Test
//    void testBuyDifferentTypes() {
//       player1.buyPropertyFromBank(station1, VALUE_STATION);
//       player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//       assertEquals(1, player1.getOwnedInstances(cityProperty));
//       assertEquals(1, player1.getOwnedInstances(stationProperty));
//
//       player1.buyPropertyFromBank(street2, VALUE_STREET_2);
//       player1.buyPropertyFromBank(station2, VALUE_STATION);
//
//       assertTrue(player1.hasAllInstances(cityProperty, NR_OF_STREETS));
//       assertFalse(player1.hasAllInstances(stationProperty, NR_OF_STATIONS));
//    }
//
//    @Test
//    void testCanBuyHousesHasWholeStreet() {
//        player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//        player1.buyPropertyFromBank(street2, VALUE_STREET_2);
//
//        assertTrue(player1.canBuyHouses());
//    }
//
//    @Test
//    void testCanBuyHousesHasAllStations() {
//        player1.buyPropertyFromBank(station1, VALUE_STATION);
//        player1.buyPropertyFromBank(station2, VALUE_STATION);
//        player1.buyPropertyFromBank(station3, VALUE_STATION);
//
//        assertFalse(player1.canBuyHouses());
//    }
//
//    @Test
//    void testCanBuyHousesHasNotWholeStreet() {
//       player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//       assertFalse(player1.canBuyHouses());
//    }
//
//    @Test
//    void testBuyProperty(){
//        int amountMoney = player1.getAmountOfMoney();
//        player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//        assertEquals(amountMoney - VALUE_STREET_1, player1.getAmountOfMoney());
//        assertTrue(player1.getProperties().contains(street1));
//    }
//
//    @Test
//    void testBuyOwnedProperty() {
//       player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//       assertFalse(player2.buyPropertyFromBank(street1, VALUE_STREET_1));
//    }
//
//    @Test
//    void testBuyMultipleProperty(){
//        player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//        player1.buyPropertyFromBank(street2, VALUE_STREET_2);
//
//        assertEquals(2, player1.getProperties().size());
//    }
//
//    @Test
//    void testBuyIdenticalProperty(){
//        player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//        player1.buyPropertyFromBank(street1, VALUE_STREET_1);
//
//        assertEquals(1, player1.getProperties().size());
//    }
//
//    @Test
//    void testMoveOnBoard(){
//        player1.move(4);
//        assertEquals(4, player1.getBoardspaceNr());
//    }
//
//    @Test
//    void testInvalidThrow(){
//        int currentPlace = player1.getBoardspaceNr();
//        player1.move(100);
//        assertEquals(currentPlace, player1.getBoardspaceNr());
//    }
//
//    @Test
//    void testMultipleMoves(){
//        for (int i = 0; i<1001; i++){
//            player1.move(7);
//        }
//        assertEquals(7, player1.getBoardspaceNr());
//    }
//
//    @Test
//    void testPayMoney(){
//        int amountMoney = player1.getAmountOfMoney();
//        int moneyPayed = 100;
//        assertTrue(player1.payMoney(moneyPayed));
//        assertEquals(amountMoney - moneyPayed, player1.getAmountOfMoney());
//    }
//
//    @Test
//    void testCanNotAffordPayment() {
//       int amountMoney = player1.getAmountOfMoney() + 1;
//       assertFalse(player1.payMoney(amountMoney));
//    }
//
//    @Test
//    void testNegativeAmountMoneyPaid(){
//        int amountMoney = player1.getAmountOfMoney();
//        int moneyPayed = -100;
//        assertFalse(player1.payMoney(moneyPayed));
//        assertEquals(amountMoney, player1.getAmountOfMoney());
//    }
//
//    @Test
//    void testReceiveMoney(){
//        int amountMoney = player1.getAmountOfMoney();
//        int moneyReceived = 100;
//        assertTrue(player1.receiveMoney(moneyReceived));
//        assertEquals(amountMoney + moneyReceived, player1.getAmountOfMoney());
//    }
//
//    @Test
//    void testNegativeAmountOfMoneyReceived() {
//        int amountMoney = player1.getAmountOfMoney();
//        int moneyReceived = -100;
//        assertFalse(player1.payMoney(moneyReceived));
//        assertEquals(amountMoney, player1.getAmountOfMoney());
//    }
//}
