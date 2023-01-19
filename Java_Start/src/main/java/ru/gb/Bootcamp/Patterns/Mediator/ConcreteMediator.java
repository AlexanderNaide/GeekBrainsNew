package ru.gb.Bootcamp.Patterns.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Конкретный диспетчер
 */

public class ConcreteMediator implements Mediator{

    List<Taxi> taxis = new ArrayList<>();

    public void add(Taxi taxi){
        taxis.add(taxi);
    }

    @Override
    public void requestAll(Trip trip) {

        for (Taxi taxi : taxis) {
            if (!taxi.getBusy() && !trip.isAssignedTrip()){
                trip.setAssignedTrip(true);
                System.out.println("\n Trip to " + trip.getAddress() + " assingned on " + taxi.getName() + ".");
                taxi.setBooked();
                break;
            }
        }
        if (!trip.isAssignedTrip()){
            System.out.println("\n All taxis are busy! Please wait for someone will be ready.");
        }
    }
}
