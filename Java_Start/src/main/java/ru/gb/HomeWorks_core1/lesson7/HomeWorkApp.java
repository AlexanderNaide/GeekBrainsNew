package ru.gb.HomeWorks_core1.lesson7;

public class HomeWorkApp {

    public static void main(String[] args) {

        Cat[] catPack = {
                new Cat("Барсик", 100),
                new Cat("Чижик", 80),
                new Cat("Чубайс", 120),
                new Cat("Мурзик", 80),
                new Cat("Черчиль", 60),
        };
        Bowl bowl = new Bowl(400);
        bowl.putFood(200);
        bowl.putFood(200);

        for (Cat cat : catPack){
            cat.eat(bowl);
        }

        for (Cat cat : catPack){
            System.out.printf(cat.isSatiation() ?
                    "Кот %s сыт.\n" :
                    "Кот %s голоден.\n",
                    cat.getName());
        }
    }
}
