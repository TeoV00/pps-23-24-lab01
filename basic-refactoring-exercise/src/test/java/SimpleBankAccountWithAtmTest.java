import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private final static double TRANSACTION_FEE = 1.0;
    private final static double INITIAL_BALANCE = 0.0;
    private final static double DEPOSIT_AMOUNT = 100.0;
    private final static double WITHDRAW_AMOUNT = 50.0;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Teo", "Viola", 0);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, INITIAL_BALANCE, (withdrawAmount)-> {
            return TRANSACTION_FEE;
        });
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDepositWithFee() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(INITIAL_BALANCE+DEPOSIT_AMOUNT-TRANSACTION_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithFee() {
        testDepositWithFee();
        bankAccount.deposit(2, DEPOSIT_AMOUNT);
        assertEquals(INITIAL_BALANCE+DEPOSIT_AMOUNT-TRANSACTION_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(48, bankAccount.getBalance());
    }
}
