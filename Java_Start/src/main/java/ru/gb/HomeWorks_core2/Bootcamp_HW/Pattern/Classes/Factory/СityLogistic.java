package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder.LogisticTransport;
import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.EasyBuilder.Cargo;

import java.util.ArrayList;

public class СityLogistic implements Logistic {

    public ArrayList<LogisticTransport> logisticTransports;

    public void setLogisticTransports(ArrayList<LogisticTransport> logisticTransports) {
        this.logisticTransports = logisticTransports;
    }

    @Override
    public void LogisticGood(Cargo cargo) {
        LogisticTransport priorityTransport = null;
        for (LogisticTransport logisticTransport : logisticTransports) {
            if(cargo.getVolume() <= logisticTransport.getVolume() && cargo.getCapacity() <= logisticTransport.getBearingCapacity()){
                priorityTransport = logisticTransport;
                break;
            }
        }

        if (priorityTransport != null) {
            System.out.print("Груз доставлен по городу. ");
            System.out.print(cargo);
            System.out.println(priorityTransport);
        } else {
            System.out.println("Груз " + cargo.getName() + " не может быть доставлен.");
        }
    }
}
