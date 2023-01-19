package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

/**
 * Строитель Фургона Газель
 */

public class MannBuilder extends TransportBuilder {

    @Override
    void BuildName() {
        logisticTransport.setName("Дальнии грузоперевозки");
    }

    @Override
    void BuildTransport() {
        logisticTransport.setTransport("Man большегруз");
    }

    @Override
    void BuildVolume() {
        logisticTransport.setVolume(18.0);
    }

    @Override
    void BuildBearingCapacity() {
        logisticTransport.setBearingCapacity(10000.0);
    }
}
