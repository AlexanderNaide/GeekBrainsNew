package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder.*;

import java.util.ArrayList;

/**
 * Фабрика межгородской службы доставки
 */


public class IntercityLogisticFactory implements LogisticFactory {

    @Override
    public Logistic createLogistic() {
        IntercityLogistic intercityLogistic = new IntercityLogistic();
        ArrayList<LogisticTransport> transports = new ArrayList<>();

        CreateTransport createTransport = new CreateTransport();

        createTransport.setBuilder(new GazelleBuilder());
        transports.add(createTransport.buildLogisticTransport());
        createTransport.setBuilder(new LargusBuilder());
        transports.add(createTransport.buildLogisticTransport());
        createTransport.setBuilder(new MannBuilder());
        transports.add(createTransport.buildLogisticTransport());

        double volume = 0;
        double capacity = 0;
        for (int j = 0; j < transports.size(); j++) {
            for (int i = 0; i < transports.size() - j;) {
                LogisticTransport lt = transports.get(i);
                if (i == 0 || (volume < lt.getVolume() && capacity < lt.getBearingCapacity())){
                    volume = lt.getVolume();
                    capacity = lt.getBearingCapacity();
                    i++;
                } else {
                    transports.remove(i);
                    transports.add(i - 1, lt);
                    volume = lt.getVolume();
                    capacity = lt.getBearingCapacity();
                }
            }
        }

//        for (LogisticTransport transport : transports) {
//            System.out.println(transport.getVolume() + " - " + transport.getBearingCapacity());
//        }

        intercityLogistic.setLogisticTransports(transports);
        return intercityLogistic;
    }
}
