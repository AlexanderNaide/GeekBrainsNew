package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class CheckFraudLocalMiddleware extends TransferMiddleware{
    protected CheckFraudLocalMiddleware(TransferMiddleware next) {
        super(next);
    }

    @Override
    public boolean Do(MoneyTransfer transfer) {
        System.out.println("Local fraud logic");
        return true;
    }

    @Override
    public boolean CanDo(MoneyTransfer transfer) {
        return transfer != null;
    }
}
