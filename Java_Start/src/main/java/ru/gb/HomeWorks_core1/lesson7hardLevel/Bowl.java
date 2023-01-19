package ru.gb.HomeWorks_core1.lesson7hardLevel;

public class Bowl extends Thread{

    private int foodAmount;
    private final int bowlVolume;

    public Bowl(int bowlVolume) {
        this.bowlVolume = bowlVolume;
    }

    public void putFood() {
        if ((bowlVolume - foodAmount) > 120) {
            int pack = (bowlVolume - foodAmount) / 120;
            this.foodAmount += pack * 120;
            System.out.printf("Семёновна высыпает в миску %d %s еды, теперь в миске %d грамм.\n", pack, text(pack), foodAmount);
        } else {
            System.out.println("А сыпать некуда.");
        }
    }

    public void decreaseFood(int amount){
        foodAmount -= amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public int getBowlVolume() {
        return bowlVolume;
    }

    public void run(){
        long startTime = System.currentTimeMillis();
        while (true){
            System.out.printf("\nВремя %d часов, — говорит Семёновна. — Пора дать котам покушать!\n", (System.currentTimeMillis() - startTime)/5000 + 6);
            putFood();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static String text (int i){
        if (i == 1 || (i % 10 == 1 && i != 11)){
            return "пакетик";
        } else if ((i > 1 && i < 5) || ((i % 10 > 1 && i % 10 < 5) && i > 21)) {
            return "пакетика";
        } else {
            return "пакетиков";
        }
    }
}
