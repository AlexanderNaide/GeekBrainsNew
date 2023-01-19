package ru.gb.Bootcamp.Patterns.Builder;

/**
 * Строитель оьекта легкой промышленности
 */

public class LightIndustrialUnitBuilder extends IndustrialBuilder{


    @Override
    void buildName() {
        industrialUnit.setName("Легкая промышленность.");
    }

    @Override
    void buildTemperature() {
        industrialUnit.setTemperature(100.0f);
    }

    @Override
    void buildPressure() {
        industrialUnit.setPressure(10.0);
    }

    @Override
    void buildVoltage() {
        industrialUnit.setVoltage(220);
    }

    @Override
    void buildSupplierName() {
        industrialUnit.setSupplierName("First Supplier");
    }

    @Override
    void buildOperatingStatus() {
        industrialUnit.setOperatingStatus(OperatingStatus.OPERATING);
    }
}
