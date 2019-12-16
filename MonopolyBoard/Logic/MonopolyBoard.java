package jmol.jasper.MonopolyBoard.Logic;

import java.util.List;

public interface MonopolyBoard <T> {
    List<T> getBoardspaceList(MonopolyBoardData.BoardspaceType boardspaceType);
}
