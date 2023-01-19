package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.EasyBuilder;

public class Cargo {

    private String name;
    private double volume;
    private double capacity;

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Груз: " + name + ". ";
    }

    private Cargo(Builder builder) {
        this.name = builder.Name;
        this.volume = builder.Volume;
        this.capacity = builder.Capacity;

    }

    public static class Builder {
        private String Name;
        private double Volume;
        private double Capacity;

        public Builder(String name){ // Обязательное поле
            Name = name;
        }

        public Builder setVolume(double volume) {
            Volume = volume;
            return this;
        }

        public Builder setCapacity(double capacity) {
            Capacity = capacity;
            return this;
        }

        public Cargo build(){
            return new Cargo(this);
        }
    }
}
