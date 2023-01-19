package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

/**
 * Строитель Фургона Газель
 */

public class LargusBuilder extends TransportBuilder {

    @Override
    void BuildName() {
        logisticTransport.setName("Легковая");
    }

    @Override
    void BuildTransport() {
        logisticTransport.setTransport("Ларгус");
    }

    @Override
    void BuildVolume() {
        logisticTransport.setVolume(1.0);
    }

    @Override
    void BuildBearingCapacity() {
        logisticTransport.setBearingCapacity(800.0);
    }
}
