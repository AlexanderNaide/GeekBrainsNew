package ru.gb.Bootcamp.Patterns.Builder;

/**
 * Промышленный обьект
 */

public class IndustrialUnit {

    private String Name;
    private float Temperature;
    private double Pressure;
    private int Voltage;
    private String SupplierName;
    private OperatingStatus operatingStatus;

    public void setName(String name) {
        Name = name;
    }

    public void setTemperature(float temperature) {
        Temperature = temperature;
    }

    public void setPressure(double pressure) {
        Pressure = pressure;
    }

    public void setVoltage(int voltage) {
        Voltage = voltage;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public void setOperatingStatus(OperatingStatus operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    @Override
    public String toString() {
        return "IndustrialUnit{" +
                "Name='" + Name + '\'' +
                ", Temperature=" + Temperature +
                ", Pressure=" + Pressure +
                ", Voltage=" + Voltage +
                ", SupplierName='" + SupplierName + '\'' +
                ", operatingStatus=" + operatingStatus +
                '}';
    }
}
