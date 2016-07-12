package Inheritance.Pr03Mankind.modles;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
        }

        if (firstName == null || firstName.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        }

        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  String.format("First Name: %s\nLast Name: %s\n", this.firstName, this.lastName);
    }
}
