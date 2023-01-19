package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

/**
 * Строитель Фургона Газель
 */

public class GazelleBuilder extends TransportBuilder {

    @Override
    void BuildName() {
        logisticTransport.setName("Легкая грузовая");
    }

    @Override
    void BuildTransport() {
        logisticTransport.setTransport("Газель фургон");
    }

    @Override
    void BuildVolume() {
        logisticTransport.setVolume(4.6);
    }

    @Override
    void BuildBearingCapacity() {
        logisticTransport.setBearingCapacity(3500.0);
    }
}
