package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class B2PTransferMiddleware extends TransferMiddleware{
    protected B2PTransferMiddleware(TransferMiddleware next) {
        super(next);
    }

    @Override
    public boolean Do(MoneyTransfer transfer) {
        System.out.println("B2P logic");
        return true;
    }

    @Override
    public boolean CanDo(MoneyTransfer transfer) {
        if (transfer == null){
            return false;
        }
        return transfer.provider.equals("B2P");
    }
}
