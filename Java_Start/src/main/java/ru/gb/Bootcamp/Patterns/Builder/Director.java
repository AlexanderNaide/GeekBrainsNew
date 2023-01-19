package ru.gb.Bootcamp.Patterns.Builder;

/**
 * Директор строительства
 */
public class Director {

    IndustrialBuilder builder;

    public void setBuilder(IndustrialBuilder builder) {
        this.builder = builder;
    }

    public IndustrialUnit buildIndustrialUnit(){
        builder.createIndustrial();
        builder.buildName();
        builder.buildTemperature();
        builder.buildPressure();
        builder.buildVoltage();
        builder.buildSupplierName();
        builder.buildOperatingStatus();

        return builder.getIndustrialUnit();
    }
}
