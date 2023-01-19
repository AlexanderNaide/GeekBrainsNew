package ru.gb.HomeWorks_core1.lesson7hardLevel;

public class Day extends Thread{

    Cat[] catPack;
    Bowl bowl;

    public void dayStart(Cat[] catPack, Bowl bowl){
        this.catPack = catPack;
        this.bowl = bowl;
        this.start();
    }

    public void run(){
        System.out.println("\nДень начался!");
        for (Cat cat : catPack){
            cat.start();
        }
        bowl.start();
        long timeStart = System.currentTimeMillis();
        while (System.currentTimeMillis() - timeStart < 80_000){
            try {
                Thread.sleep(250);
                Cat hungryCat = veryHungriestCat();
                if (hungryCat != null)hungryCat.eat(bowl);
            } catch (InterruptedException e) {
                break;
            }
        }
        for (Cat cat : catPack){
            cat.interrupt();
        }
        bowl.interrupt();
        System.out.println("\nДень завершился!\n");
    }

    //Метод возвращает самого голодного кота из списка, при этом кот только тогда голодный, когда "остаток" сытости меньше 30%.
    public Cat veryHungriestCat(){
        Cat hungryCat = catPack[0];
        for (Cat cat : catPack){
            if(cat.getAppetite() - cat.getSatiation() > hungryCat.getAppetite() - hungryCat.getSatiation()){
                hungryCat = cat;
            }
        }
        if (hungryCat.getSatiation() < hungryCat.getAppetite() * 0.3){
            return hungryCat;
        } else {
            return null;
        }
    }


}
