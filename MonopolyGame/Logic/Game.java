package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Board;
import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionValidator;
import jmol.jasper.UserInterface.Logic.UserInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private UserInputReader userInputReader;
    private Map<Player, Boardspace> playerBoardspaceMap;
    private Board board;
    private int nrOfRounds;
    private Bank bank;
    private TransactionHandler transactionHandler;

    public Game(GameSetup gameSetup){
        players = makeArrayList(gameSetup.getPlayers());
        playerBoardspaceMap = gameSetup.getPlayerBoardspaceMap();
        userInputReader = gameSetup.getUserInputReader();
        board = gameSetup.getBoard();
        bank = gameSetup.getBank();
        transactionHandler = new TransactionHandler(userInputReader);
    }

    public void startGame(){
        while (!gameIsOver()) {
            playRound();
            nrOfRounds ++;
        }
        System.out.println(players.get(0) + " heeft gewonnen!");
        printGameStatus();
    }

    private boolean gameIsOver() {
        return players.size() == 1;
    }

    private void playRound() {
        for (Player player : players) {
            handleTransactions(player);
            playRound(player);
            handleTransactions(player);
            if (player.isGameOver()) {
                handleGameOver(player);
            }
        }
    }

    private void handleTransactions(Player player) {
        if (!askIfPlayerWantTransactions(player)) {
            return;
        }
        PlayerAction playerAction = PlayerActionFactory.getPlayerAction(transactionHandler.determinePlayerTransaction());
        playerAction.handleAction(bank, player);
    }

    private boolean askIfPlayerWantTransactions(Player player) {
        System.out.println("Wil " + player.getName() + " transacties uitvoeren?");
        Boolean wantHandleTransactions = userInputReader.getBoolean();
        while (!ExpressionValidator.getInstance().isValidBoolean(wantHandleTransactions)) {
            System.out.println("Voer ja, j, yes, y voor ja en nee, no, n voor nee");
            wantHandleTransactions = userInputReader.getBoolean();
        }
        return wantHandleTransactions;
    }

    private void handleGameOver(Player player) {
        playerBoardspaceMap.remove(player);
        players.remove(player);
        System.out.println(player + " is failliet en doet niet meer mee!");
    }

    private void playRound(Player player) {
        RoundOfPlay roundOfPlay = new RoundOfPlay(player, userInputReader);
        do {
            int currentBoardSpaceNr = player.getBoardspaceNr();
            roundOfPlay.play();
            putPlayerOnNewBoardSpace(player, currentBoardSpaceNr);
            performBoardspaceActions(player, roundOfPlay.getTotalThrow());
        }
        while (roundOfPlay.determineCanThrowAgain());
    }

    private void putPlayerOnNewBoardSpace(Player player, int previousBoardSpaceNr) {
        int newBoardSpaceNr = player.getBoardspaceNr();
        if (newBoardSpaceNr != 0 && newBoardSpaceNr<previousBoardSpaceNr) {
            System.out.println(player + " is voorbij start gekomen en ontvangt 200 euro!");
            player.receiveMoney(200);
        }
        playerBoardspaceMap.put(player, board.getBoardspace(newBoardSpaceNr));
    }

    private void performBoardspaceActions(Player player, int diceThrow) {
        Boardspace boardspace = playerBoardspaceMap.get(player);
        boardspace.prepareAction(player, diceThrow);
        boardspace.performAction();
    }

    private void printGameStatus(){
        for (Player player : players){
            System.out.println(showPlayerStatus(player));
        }
        System.out.println("Er zijn " + nrOfRounds + " gespeeld.");
    }

    private String showPlayerStatus(Player player) {
        StringBuilder playerStatus = new StringBuilder(player.getName());
        playerStatus.append(" staat op ");
        playerStatus.append(board.getBoardspace(player.getBoardspaceNr()).getName());
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
