package DefiningClasses.Pr04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> departmentWhitSalary = new HashMap<>();
        HashMap<String, TreeSet<Employee>> departmentWhitEmployees = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = reader.readLine().split("\\s+");
            String name = employeeInfo[0];
            Double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;

            if (employeeInfo.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeInfo.length == 5) {
                if (isNumber(employeeInfo[4])) {
                    int age = Integer.parseInt(employeeInfo[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = employeeInfo[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                int age = Integer.parseInt(employeeInfo[5]);
                String email = employeeInfo[4];
                employee = new Employee(name, salary, position, department, email, age);
            }

            if (!departmentWhitEmployees.containsKey(department)) {
                departmentWhitEmployees.put(department, new TreeSet<>());
                departmentWhitSalary.put(department, 0d);
            }

            departmentWhitEmployees.get(department).add(employee);
            departmentWhitSalary.put(department, departmentWhitSalary.get(department) + salary);
        }

        Map.Entry<String, TreeSet<Employee>> best = departmentWhitEmployees.entrySet().stream().sorted((e1, e2) ->
                Double.compare(departmentWhitSalary.get(e2.getKey()), departmentWhitSalary.get(e1.getKey())))
                .findFirst().get();
        System.out.println("Highest Average Salary: " + best.getKey());
        best.getValue().forEach(System.out::println);
    }

    private static boolean isNumber(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

class Employee implements Comparable<Employee> {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary,
                    String position, String department,
                    String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary,
                    String position, String department,
                    String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary,
                    String position, String department,
                    int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary,
                    String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(employee.salary, this.salary);
    }
}