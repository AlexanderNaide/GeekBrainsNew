package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

/**
 * Строитель Фургона Газель
 */

public class VeloBuilder extends TransportBuilder {

    @Override
    void BuildName() {
        logisticTransport.setName("Ручная механизированная");
    }

    @Override
    void BuildTransport() {
        logisticTransport.setTransport("Велосипед");
    }

    @Override
    void BuildVolume() {
        logisticTransport.setVolume(0.05);
    }

    @Override
    void BuildBearingCapacity() {
        logisticTransport.setBearingCapacity(20.0);
    }
}
