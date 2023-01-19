package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class P2BTransferMiddleware extends TransferMiddleware{
    protected P2BTransferMiddleware(TransferMiddleware next) {
        super(next);
    }

    @Override
    public boolean Do(MoneyTransfer transfer) {
        System.out.println("P2B logic");
        return true;
    }

    @Override
    public boolean CanDo(MoneyTransfer transfer) {
        if (transfer == null){
            return false;
        }
        return transfer.provider.equals("P2B");
    }
}
