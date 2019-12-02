package jmol.jasper.MonopolyBoard.Logic;

import jmol.jasper.Utility.Logic.UserInputReader;

public class CommunityChest extends CardSpace {

    public CommunityChest(UserInputReader userInputReader, String name, int spaceNr) {
        super(userInputReader, name, spaceNr);
    }


    @Override
    public PlayerAction performAction() {
        System.out.println(visitor.getName() + " trekt een algemeen fonds kaart.");
        return null;
    }
}
