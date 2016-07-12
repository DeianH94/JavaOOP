package Inheritance.Pr03Mankind;

import Inheritance.Pr03Mankind.modles.Student;
import Inheritance.Pr03Mankind.modles.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] studentInfo = reader.readLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            String facultyNumber = studentInfo[2];
            Student student = new Student(firstName, lastName, facultyNumber);

            String[] workerInfo = reader.readLine().split("\\s+");
            firstName = workerInfo[0];
            lastName = workerInfo[1];
            Double salary = Double.parseDouble(workerInfo[2]);
            Double workHours = Double.parseDouble(workerInfo[3]);
            Worker worker = new Worker(firstName, lastName, salary, workHours);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
