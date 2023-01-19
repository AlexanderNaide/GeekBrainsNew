package ru.gb.HomeWorks_core3.lesson1_test;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void addFruit(T t) {
        list.add(t);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public Float getBoxWeight() {
        return list.size() * T.getWeightFruit();
    }

    public String getBoxTitle() {
        return T.getTitleFruit();
    }

    public boolean compare(Box<? extends Fruit> box) {

        System.out.println("box - это OrangeBox, то есть Title \"Апельсины\", а вес 1,5. Получаем: " + box.getBoxTitle() + " / " + box.getBoxWeight());
        System.out.println("This - это AppleBox, то есть Title \"Яблоки\", а вес 1,0. Но получаем: " + this.getBoxTitle() + " / " + this.getBoxWeight());

        return Math.abs(list.size() * this.getBoxWeight() - box.getList().size() * box.getBoxWeight()) < 0.0001;

        /**
         * Вот тут мы не обращаемся к типу коробки. Мы используем текущую коробку для сравнения с переданной ссылкой на другую коробку, которые уже созданы ранее,
         * каждая со своим типом, а <?> нам нужен только для того, чтобы получать на вход коробки разных типов, при этом методы getBoxWeight вызываются у каждой коробки свой.
         * Но на самом деле в методе getBoxWeight (да и в остальных тоже) T берется не от типа коробки, а из <?> переданного в методе compare. Это странно.
         * Вот про этот момент я и хотел спросить на семинаре.
         * Я гуглил в инете эту тему. Единственное пояснение мне удалось найти - это то, что если мы используем джинерики и в каком-то методе передается <?>,
         * то Т меняется на значение ? во всем классе во всех методах и действует до тех пор, пока вызванный метод не вернет return.
         *
         * Дз я конечно переделал, и Вы проверили, но джинерики стали меня пугать еще больше (шутка)))
         *
         */


    }
}
