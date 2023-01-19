package ru.gb.Bootcamp.Patterns.Mediator;

public class ConcreteTaxi implements Taxi{

    private String name;
    private String status;
    private boolean busy;
    Mediator mediator;

    public ConcreteTaxi(String name, String status, boolean busy, Mediator mediator) {
        this.name = name;
        this.status = status;
        this.busy = busy;
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBooked() {
        status = "Booked";
        busy = true;
        System.out.println(name + ". I am booked!");
    }

    @Override
    public void setFree() {
        status = "Free";
        busy = false;
        System.out.println(name + ". I am free and ready for a trip!");
    }

    @Override
    public void setRest() {
        status = "Rest";
        busy = true;
        System.out.println(name + ". I am on rest and not able to drive!");
    }

    @Override
    public boolean getBusy() {
        return busy;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void assingDriver(Trip trip) {
        if (!busy && !trip.isAssignedTrip()){
            trip.setAssignedTrip(true);
            System.out.println("\n Trip to " + trip.getAddress() + " assingned on " + name + ".");
            setBooked();
        } else {
            mediator.requestAll(trip);
        }
    }
}
