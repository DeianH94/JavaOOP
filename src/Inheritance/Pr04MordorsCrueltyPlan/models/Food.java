package Inheritance.Pr04MordorsCrueltyPlan.models;

public class Food {
    private int amount;

    public Food(int amount) {
        this.setAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }
}
