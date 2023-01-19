package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Builder;

public class LogisticTransport {
    private String name;
    private String transport;
    private double volume;
    private double bearingCapacity;

    public void setName(String name) {
        this.name = name;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setBearingCapacity(double bearingCapacity) {
        this.bearingCapacity = bearingCapacity;
    }

    public double getVolume() {
        return volume;
    }

    public double getBearingCapacity() {
        return bearingCapacity;
    }

    @Override
    public String toString() {
        return "Способ доставки: " + name +
                ", доставляется " + (transport == null ? "пешком" : "на " + transport + "е") +
                ", максимальный обьем: " + volume +
                ", максимальная масса: " + bearingCapacity + ".";
    }
}
