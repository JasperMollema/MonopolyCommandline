package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionValidator;
import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.HashMap;
import java.util.Map;

public class GameSetup {
    private Player[] players;
    private Bank bank;
    private UserInputReader userInputReader;
    private Integer numberOfPlayers;
    private Map<Player, Boardspace> playerBoardspaceMap;
    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 2;
    private final int MIN_NAME_LENGHT = 1;
    private final int MAX_NAME_LENGHT = 12;

    public GameSetup(UserInputReader userInputReader) {
        playerBoardspaceMap = new HashMap<>();
        this.userInputReader = userInputReader;
    }

    public Game createGame() {
        setupGame();
        return new Game(this);
    }

    private void setupGame(){
        System.out.println("Welkom bij Monopoly!");
        createPlayers();
        for (Player player : players) {
            // Put all the players on the start space.
            playerBoardspaceMap.put(player, MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_START));
        }
    }

    private boolean createPlayers() {
        determineNumberOfPlayers();
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            players[i] = createPlayer(i + 1);
        }
        return true;
    }

    private Player createPlayer(int playerNo) {
        String name = getPlayerName(playerNo);
        System.out.println(name + " is toegevoegd!");
        return new Player(name);
    }

    private void determineNumberOfPlayers() {
        System.out.println("Met hoeveel spelers wil je spelen?");
        numberOfPlayers = userInputReader.getInteger();
        boolean validNumberOfPlayers = isNumberOfPlayersValid();
        while (!validNumberOfPlayers) {
            System.out.println("Er kunnen minimaal " + MIN_PLAYERS + " en maximaal " + MAX_PLAYERS + " spelen.");
            System.out.println("Voer nog een keer het aantal spelers in.");
            numberOfPlayers = userInputReader.getInteger();
            validNumberOfPlayers = isNumberOfPlayersValid();
        }
    }

    private String getPlayerName(int playerNo) {
        System.out.println("Wat is de naam van speler " + playerNo + "?");
        String name = userInputReader.getString();
        boolean isValidName = validateName(name);
        while (!isValidName) {
            System.out.println("Een naam mag niet leeg zijn of langer dan 12 tekens");
            System.out.println("Voer nog een keer je naam in.");
            name = userInputReader.getString();
            isValidName = validateName(name);
        }
        return name;
    }

    private boolean validateName(String name) {
        return ExpressionValidator.getInstance().isStringWithinLength(name, MIN_NAME_LENGHT, MAX_NAME_LENGHT);
    }

    private boolean isNumberOfPlayersValid() {
        return ExpressionValidator.getInstance().isValidIntegerWithBoundaries(numberOfPlayers, MIN_PLAYERS, MAX_PLAYERS);
    }

    private void createBank() {
        bank = new Bank();

    }
    public Player[] getPlayers() {
        return players;
    }

    public UserInputReader getUserInputReader() {
        return userInputReader;
    }

    public Map<Player, Boardspace> getPlayerBoardspaceMap() {
        return playerBoardspaceMap;
    }

    public Bank getBank() {
        return bank;
    }
}
