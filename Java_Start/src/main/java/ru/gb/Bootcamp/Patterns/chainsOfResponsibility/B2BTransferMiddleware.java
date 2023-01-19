package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class B2BTransferMiddleware extends TransferMiddleware{
    protected B2BTransferMiddleware(TransferMiddleware next) {
        super(next);
    }

    @Override
    public boolean Do(MoneyTransfer transfer) {
        System.out.println("B2B logic");
        return true;
    }

    @Override
    public boolean CanDo(MoneyTransfer transfer) {
        if (transfer == null){
            return false;
        }
        return transfer.provider.equals("B2B");
    }
}
