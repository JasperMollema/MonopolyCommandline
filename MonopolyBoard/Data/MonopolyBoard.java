package jmol.jasper.MonopolyBoard.Data;

import java.util.List;

public interface MonopolyBoard <T> {
    List<T> getBoardspaceList(MonopolyBoardData.BoardspaceType boardspaceType);
}
