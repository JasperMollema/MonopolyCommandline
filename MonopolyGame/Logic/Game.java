package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.MonopolyBoardData;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;
import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private UserInputReader userInputReader;
    private Map<Player, Boardspace> playerBoardspaceMap;
    private int nrOfRounds;
    private Bank bank;
    private TransactionHandler transactionHandler;

    public Game(GameSetup gameSetup){
        players = makeArrayList(gameSetup.getPlayers());
        playerBoardspaceMap = gameSetup.getPlayerBoardspaceMap();
        userInputReader = gameSetup.getUserInputReader();
        bank = gameSetup.getBank();
        bank.fillPlayerlistMap(players);
        transactionHandler = new TransactionHandler(userInputReader);
    }

    public void startGame(){
        while (!gameIsOver()) {
            playTurn();
            nrOfRounds ++;
        }
        System.out.println(players.get(0) + " heeft gewonnen!");
        printGameStatus();
    }

    private boolean gameIsOver() {
        return players.size() == 1;
    }

    private void playTurn() {
        for (Player player : players) {
            playTurn(player);
            if (player.isGameOver()) {
                handleGameOver(player);
            }
        }
    }

    private void handleBoardTransactions(PlayerActionType playerActionType, Player player) {
        PlayerAction playerAction = PlayerActionFactory.getPlayerAction(playerActionType);

        playerAction.handleAction(bank, player, playerBoardspaceMap.get(player));
    }

    private void handlePlayerTransactions(Player player) {
        if (!askIfPlayerWantTransactions(player)) {
            return;
        }
        PlayerAction playerAction = PlayerActionFactory.getPlayerAction(transactionHandler.determinePlayerTransaction());
        playerAction.handleAction(bank, player, playerBoardspaceMap.get(player));
    }

    private boolean askIfPlayerWantTransactions(Player player) {
        return ExpressionProvider.getInstance().
                getBoolean(("Wil " + player.getName() + " transacties uitvoeren?"), userInputReader);

    }

    private void handleGameOver(Player player) {
        playerBoardspaceMap.remove(player);
        players.remove(player);
        System.out.println(player + " is failliet en doet niet meer mee!");
    }

    private void playTurn(Player player) {
        RoundOfPlay roundOfPlay = new RoundOfPlay(player, userInputReader);
        do {
            roundOfPlay.play();
            putPlayerOnNewBoardSpace(player, roundOfPlay.getTotalThrow());
            performBoardspaceActions(player, roundOfPlay.getTotalThrow());
            handlePlayerTransactions(player);
        }
        while (roundOfPlay.determineCanThrowAgain());
    }

    private void putPlayerOnNewBoardSpace(Player player, int diceThrow) {
        int previousBoardSpaceNr = playerBoardspaceMap.get(player).getSpaceNr();
        int newBoardSpaceNr = determineNewBoardspaceNr(previousBoardSpaceNr, diceThrow);

        if (newBoardSpaceNr != 0 && newBoardSpaceNr<previousBoardSpaceNr) {
            System.out.println(player + " is voorbij start gekomen en ontvangt 200 euro!");
            player.receiveMoney(200);
        }
        player.moveToBoardspace(newBoardSpaceNr);
        playerBoardspaceMap.put(player, MonopolyBoardData.getBoardspace(newBoardSpaceNr));
    }

    private int determineNewBoardspaceNr(int previousBoardspaceNr, int diceThrow) {
        int newBoardspaceNr = previousBoardspaceNr + diceThrow;
        if (newBoardspaceNr > MonopolyBoardData.MAX_BOARDSPACE_NR) {
            newBoardspaceNr -= MonopolyBoardData.MAX_BOARDSPACE_NR - 1;
        }
        return newBoardspaceNr;
    }

    private void performBoardspaceActions(Player player, int diceThrow) {
        Boardspace boardspace = playerBoardspaceMap.get(player);
        boardspace.prepareAction(player, diceThrow);
        handleBoardTransactions(boardspace.performAction(), player);
    }

    private void printGameStatus(){
        for (Player player : players){
            System.out.println(showPlayerStatus(player));
        }
        System.out.println("Er zijn " + nrOfRounds + " ronden gespeeld.");
    }

    private String showPlayerStatus(Player player) {
        StringBuilder playerStatus = new StringBuilder(player.getName());
        playerStatus.append(" staat op ");
        playerStatus.append(MonopolyBoardData.getBoardspace(player.getBoardspaceNr()).getName());
        playerStatus.append(" en heeft ");
        playerStatus.append(player.getAmountOfMoney() + " euro.");
        playerStatus.append(System.lineSeparator());
        if (player.getProperties().isEmpty()) {
            playerStatus.append(player.getName() + " heeft geen nog geen bezittingen.");
        }
        else {
            playerStatus.append(player + " heeft de volgende bezittingen:");
            for (Property property : player.getProperties()){
                playerStatus.append(System.lineSeparator());
                playerStatus.append(property.getName() + ".");
            }
        }
        playerStatus.append(System.lineSeparator());
        return playerStatus.toString();
    }

    private List<Player> makeArrayList(Player[] playerArray) {
        List<Player> players = new ArrayList<>();
        for (Player player : playerArray) {
            players.add(player);
        }
        return players;
    }
}
