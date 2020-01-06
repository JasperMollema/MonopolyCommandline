package jmol.jasper.MonopolyGame.Logic;

import jmol.jasper.MonopolyBoard.Logic.Boardspace;
import jmol.jasper.MonopolyBoard.Logic.MonopolyBoardData;
import jmol.jasper.MonopolyBoard.Logic.Property;
import jmol.jasper.Player.Logic.Player;

public class PrintPlayerStatus extends PlayerAction {

    public PrintPlayerStatus(Bank bank, Player player, Boardspace boardspace) {
        super(bank, player, boardspace);
    }

    @Override
    public void handleAction() {
        StringBuilder playerStatus = new StringBuilder(player.getName());
        playerStatus.append(" staat op ");
        playerStatus.append(MonopolyBoardData.getBoardspace(player.getBoardspaceNr()).getName());
        playerStatus.append(" en heeft ");
        playerStatus.append(player.getAmountOfMoney() + " euro.");
        playerStatus.append(System.lineSeparator());
        if (player.getProperties().isEmpty()) {
            playerStatus.append(player.getName() + " heeft geen bezittingen.");
        }
        else {
            playerStatus.append(player + " heeft de volgende bezittingen:");
            for (Property property : player.getProperties()){
                playerStatus.append(System.lineSeparator());
                playerStatus.append(property.toString());
            }
        }
        playerStatus.append(System.lineSeparator());
        System.out.println(playerStatus.toString());
    }
}
