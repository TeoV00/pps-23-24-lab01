import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private final static double TRANSACTION_FEE = 1.0;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Teo", "Viola", 0);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, (withdrawAmount)-> {
            return TRANSACTION_FEE;
        });
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDepositWithFee() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithFee() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 50);
        assertEquals(48, bankAccount.getBalance());
    }
}
