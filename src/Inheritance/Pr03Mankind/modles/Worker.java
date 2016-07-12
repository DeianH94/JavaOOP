package Inheritance.Pr03Mankind.modles;

public class Worker extends Human {
    private Double weeklySalary;
    private Double hoursPerDay;

    public Worker(String firstName, String lastName, Double weeklySalary, Double hoursPerDay) {
        super(firstName, lastName);
        this.setHoursPerDay(hoursPerDay);
        this.setWeeklySalary(weeklySalary);
    }

    @Override
    protected void setLastName (String lastName) {
        if (lastName == null || lastName.trim().length() <= 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: lastName");
        }

        super.setLastName(lastName);
    }

    private void setWeeklySalary(Double weeklySalary) {
        if (weeklySalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }

        this.weeklySalary = weeklySalary;
    }

    private void setHoursPerDay(Double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: workHoursPerDay");
        }

        this.hoursPerDay = hoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.weeklySalary / (this.hoursPerDay * 7);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n",
                this.weeklySalary, this.hoursPerDay, this.getSalaryPerHour());
    }
}
