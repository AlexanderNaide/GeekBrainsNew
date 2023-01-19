package ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern;

import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.EasyBuilder.Cargo;
import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory.CityLogisticFactory;
import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory.IntercityLogisticFactory;
import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory.Logistic;
import ru.gb.HomeWorks_core2.Bootcamp_HW.Pattern.Classes.Factory.LogisticFactory;

public class LogisticApp {
    public static void main(String[] args) {

        // Создаем Междугороднюю службу доставки
        LogisticFactory logisticFactoryInterCity = new IntercityLogisticFactory();
        Logistic intercity = logisticFactoryInterCity.createLogistic();

        // Сщздаем службу доставки по городу
        LogisticFactory logisticFactoryCity = new CityLogisticFactory();
        Logistic city = logisticFactoryCity.createLogistic();

        //Создаем товар: Пицца
        Cargo pizza = new Cargo.Builder("Pizza")
                .setVolume(0.002)
                .setCapacity(0.2)
                .build();

        //Отправляем Пиццу курьером
        city.LogisticGood(pizza);

        //Создаем товар: 12 ящиков водки
        Cargo vodka = new Cargo.Builder("Vodka")
                .setVolume(0.035 * 12)
                .setCapacity(14 * 12)
                .build();

        //Отправляем 12 щиков водки междугородней доставкой
        intercity.LogisticGood(vodka);

        //Создаем товар: Пополняемый ассортимент магазина Пятерочка
        Cargo rc = new Cargo.Builder("Поставка на магазин")
                .setVolume(4.65)
                .setCapacity(642.8)
                .build();

        //Отправляем товар для Пятерочки междугородней доставкой
        intercity.LogisticGood(rc);

        //Создаем товар: Кубометр асфальта
        Cargo as = new Cargo.Builder("Кубометр асфальта")
                .setVolume(1.0)
                .setCapacity(12000.0)
                .build();

        //Отправляем асфальт междугородней доставкой
        intercity.LogisticGood(as);

    }
}
