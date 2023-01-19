package ru.gb.HomeWorks_core1.lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiation;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiation = false;
    }

    public void eat (Bowl bowl){
        boolean sat = bowl.decreaseFood(appetite);
        if (sat) {
            this.satiation = true;
            System.out.printf("Кот %s съел %d грамм еды.\n", name, appetite);
        } else {
            System.out.printf("Кот %s остался голодный.\n", name);
        }
    }

    public boolean isSatiation() {
        return satiation;
    }

    public String getName() {
        return name;
    }
}
