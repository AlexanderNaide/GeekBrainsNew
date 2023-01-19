package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public abstract class TransferMiddleware {
    private TransferMiddleware next;
    protected TransferMiddleware (TransferMiddleware next){
        this.next = next;
    }

    public void process(MoneyTransfer transfer){
        if (CanDo(transfer)){
            if (!Do(transfer)) {
                return;
            }
        }
        if (next != null){
            next.process(transfer);
        }
    }

    public abstract boolean Do(MoneyTransfer transfer);
    public abstract boolean CanDo(MoneyTransfer transfer);
}
