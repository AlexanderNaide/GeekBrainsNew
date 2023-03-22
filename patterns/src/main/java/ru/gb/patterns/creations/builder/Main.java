package ru.gb.patterns.creations.builder;

public class Main {

    public static void main(String[] args) {

        /**
         * Чтобы все работало красиво надо добавить плагин builder, любой, например InnerBuilder
         **/

        User user = User.newBuilder()
                .withName("Ivan")
                .withSurName("Ivanov")
                .withEmail("a@b.ru")
                .withPhone("89005523565")
                .withAddress("jcfjfjfjf")
                .withAge(25)
                .withHeight(180)
                .withWeight(80)
                .build();

        User copy = User.newBuilder(user).build();


        /**
         * Другой вариант, еще проще - Lombok, добавить dependency, и в классе добавляем @Data, @Builder
         **/

        // через lombok:

        UserLombok userLombok = UserLombok.builder()
                .name("Ivan")
                .surName("Ivanov")
                .email("a@b.ru")
                .phone("89005523565")
                .address("jcfjfjfjf")
                .age(25)
                .height(180)
                .weight(80)
                .build();

    }
}