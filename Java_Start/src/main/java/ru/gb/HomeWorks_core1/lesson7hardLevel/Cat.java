package ru.gb.HomeWorks_core1.lesson7hardLevel;

public class Cat extends Thread {

    private String name;
    private int appetite;
    private int satiation;
    private int count = 0;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiation = 0;
    }

    public void eat (Bowl bowl){
        if (appetite > bowl.getFoodAmount() && bowl.getFoodAmount() > 0){
            satiation = bowl.getFoodAmount();
            bowl.decreaseFood(satiation);
            System.out.printf("Кот %s съел %d грамм еды и не наелся.\n", name, satiation);
        } else if (bowl.getFoodAmount() == 0){
            System.out.printf("Кот %s хотел поесть, но миска пуста.\n", name);
        } else {
            satiation = appetite;
            bowl.decreaseFood(satiation);
            System.out.printf("Кот %s съел %d грамм еды.\n", name, satiation);
            count++;
        }
    }

    public int getSatiation() {
        return satiation;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getNameCat() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void run(){
        while (true){
            try {
                Thread.sleep(100);
                if (satiation > 0){
                    satiation--;
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
