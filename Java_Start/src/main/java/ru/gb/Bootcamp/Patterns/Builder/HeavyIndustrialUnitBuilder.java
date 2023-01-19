package ru.gb.Bootcamp.Patterns.Builder;

/**
 * Строитель тяжелой промышленности
 */

public class HeavyIndustrialUnitBuilder extends IndustrialBuilder{
    @Override
    void buildName() {
        industrialUnit.setName("Тяжелая промышленность");
    }

    @Override
    void buildTemperature() {
        industrialUnit.setTemperature(1000.0f);
    }

    @Override
    void buildPressure() {
        industrialUnit.setPressure(500.0);
    }

    @Override
    void buildVoltage() {
        industrialUnit.setVoltage(380);
    }

    @Override
    void buildSupplierName() {
        industrialUnit.setSupplierName("Great Supplier");
    }

    @Override
    void buildOperatingStatus() {
        industrialUnit.setOperatingStatus(OperatingStatus.OPERATING);
    }
}
