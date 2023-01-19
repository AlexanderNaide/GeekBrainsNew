package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

public class CreateTransport {

    TransportBuilder builder;

    public void setBuilder(TransportBuilder builder) {
        this.builder = builder;
    }

    public LogisticTransport buildLogisticTransport(){
        builder.CreateLogisticTransport();
        builder.BuildName();
        builder.BuildTransport();
        builder.BuildVolume();
        builder.BuildBearingCapacity();

        return builder.getLogisticTransport();
    }
}
