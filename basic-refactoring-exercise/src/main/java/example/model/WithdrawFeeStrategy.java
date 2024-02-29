package example.model;

public interface WithdrawFeeStrategy {

    /**
     * Calculate fees
     * @param withdrawAmount amount of money moved (deposited or withdrawed) per transaction
     * @return the fees to be paid per transaction
     */
    double getFee(double withdrawAmount);
}
