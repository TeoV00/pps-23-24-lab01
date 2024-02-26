package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private WithdrawFeeStrategy withdrawFeeStrategy;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, WithdrawFeeStrategy withdrawFeeStrategy) {
        super(holder, balance);
        this.withdrawFeeStrategy = withdrawFeeStrategy;
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + withdrawFeeStrategy.getFee(amount));
    }

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - withdrawFeeStrategy.getFee(amount));
    }
}
