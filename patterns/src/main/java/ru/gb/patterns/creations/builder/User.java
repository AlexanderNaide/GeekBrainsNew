package ru.gb.patterns.creations.builder;

public class User {

    private final String name;
    private final String surName;
    private final String email;
    private final String address;
    private final String phone;
    private final int age;
    private final int weight;
    private final int height;

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    private User(Builder builder) {
        name = builder.name;
        surName = builder.surName;
        email = builder.email;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        weight = builder.weight;
        height = builder.height;
    }

    public static Builder newBuilder(User copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.surName = copy.getSurName();
        builder.email = copy.getEmail();
        builder.address = copy.getAddress();
        builder.phone = copy.getPhone();
        builder.age = copy.getAge();
        builder.weight = copy.getWeight();
        builder.height = copy.getHeight();
        return builder;
    }


    public static final class Builder {
        private String name;
        private String surName;
        private String email;
        private String address;
        private String phone;
        private int age;
        private int weight;
        private int height;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withHeight(int height) {
            this.height = height;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
