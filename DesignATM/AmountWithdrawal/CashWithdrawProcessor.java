package  com.cleo.LowLevelDesign.DesignATM.AmountWithdrawal;

import  com.cleo.LowLevelDesign.DesignATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {

        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;

    }

    public void withdraw(ATM atm, int remainingAmount) {

        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}