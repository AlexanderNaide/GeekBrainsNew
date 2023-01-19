package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

/**
 * Строитель Фургона Газель
 */

public class FootBuilder extends TransportBuilder {

    @Override
    void BuildName() {
        logisticTransport.setName("Ручная немеханизированная");
    }

    @Override
    void BuildTransport() {
        logisticTransport.setTransport(null);
    }

    @Override
    void BuildVolume() {
        logisticTransport.setVolume(0.025);
    }

    @Override
    void BuildBearingCapacity() {
        logisticTransport.setBearingCapacity(10.0);
    }
}
