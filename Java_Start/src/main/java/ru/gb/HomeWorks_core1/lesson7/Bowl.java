package ru.gb.HomeWorks_core1.lesson7;

public class Bowl {

    private int foodAmount;
    private final int bowlVolume;

    public Bowl(int bowlVolume) {
        this.bowlVolume = bowlVolume;
    }

    public void putFood(int amount) {
        if ((foodAmount + amount) <= bowlVolume) {
            this.foodAmount += amount;
            System.out.printf("В миску положили %d грамм еды, теперь в миске %d грамм.\n", amount, foodAmount);
        } else {
            this.foodAmount = bowlVolume;
            System.out.printf("В миску положили %d грамм еды, миска полна, в ней %d грамм, остальное вывалилось.\n", amount, foodAmount);
        }
    }

    public boolean decreaseFood(int amount){
        if (amount < foodAmount) {
            this.foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
