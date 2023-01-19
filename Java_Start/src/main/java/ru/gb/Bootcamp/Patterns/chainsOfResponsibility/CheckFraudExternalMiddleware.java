package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class CheckFraudExternalMiddleware extends TransferMiddleware{
    protected CheckFraudExternalMiddleware(TransferMiddleware next) {
        super(next);
    }

    @Override
    public boolean Do(MoneyTransfer transfer) {
        System.out.println("External fraud logic");
        return true;
    }

    @Override
    public boolean CanDo(MoneyTransfer transfer) {
        return transfer.provider.equals("B2B");
    }
}
