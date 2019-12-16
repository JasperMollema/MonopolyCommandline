package jmol.jasper.MonopolyGame.Test;

import jmol.jasper.MonopolyGame.Logic.Bank;
import org.junit.jupiter.api.Test;

public class BankTest {
    Bank bank = new Bank();

    @Test
    void testBuyProperty() {
        bank.buyProperty();
    }
}
