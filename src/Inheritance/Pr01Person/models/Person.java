package Inheritance.Pr01Person.models;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    protected void setName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }

        this.name = name;
    }

    protected void setAge(Integer age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }

        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));

        return stringBuilder.toString();
    }
}
