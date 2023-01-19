package ru.gb.Bootcamp.Patterns.chainsOfResponsibility;

public class TransferManager {
    /**
     *
     * B2B
     * B2P
     * P2B
     * .....
     *
     **/
    public void doTransfer(MoneyTransfer transfer){
//        switch (transfer.provider){
//            case "B2B" -> {
//                checkFraudExternal(transfer);
//                checkFraudLocal(transfer);
//                transferViaB2B(transfer);
//            }
//            case "B2P" -> {
//                checkFraudLocal(transfer);
//                transferViaB2P(transfer);
//            }
//            case "P2B" -> {
//                checkFraudLocal(transfer);
//                transferViaP2B(transfer);
//            }
//        }
//      private void checkFraudExternal(MoneyTransfer transfer){
//          //logic
//      }
//      private void checkFraudLocal(MoneyTransfer transfer){
//          //logic
//      }
//      private void transferViaB2B(MoneyTransfer transfer){
//          //logic
//      }
//      private void transferViaB2P(MoneyTransfer transfer){
//          //logic
//      }
//      private void transferViaP2B(MoneyTransfer transfer){
//          //logic
//      }

        CheckFraudExternalMiddleware externalMiddleware =
                new CheckFraudExternalMiddleware(
                        new CheckFraudLocalMiddleware(
                                new B2BTransferMiddleware(
                                        new B2PTransferMiddleware(
                                                new P2BTransferMiddleware(null)))));
        externalMiddleware.process(transfer);

    }

}
