package jmol.jasper.MonopolyBoard.Data;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;

import java.util.ArrayList;
import java.util.List;

public class Board <T> implements MonopolyBoard <T>{
    private Boardspace[] monopolyBoard = MonopolyBoardData.MONOPOLYBOARD;

    @Override
    public List getBoardspaceList(MonopolyBoardData.BoardspaceType boardspaceType) {

        List<T> boardspaceList = new ArrayList<>();
        for (Boardspace boardspace : monopolyBoard) {
            if (boardspace.getBoardspaceType().equals(boardspaceType)) {
                boardspaceList.add((T) boardspace);
            }
        }
        return boardspaceList;
    }
}

