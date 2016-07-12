package StaticMembers.Pr01Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String studentName = reader.readLine();

        while (!studentName.toLowerCase().equals("end")) {
            Student student = new Student(studentName);
            studentName = reader.readLine();
        }

        System.out.println(Student.getNumOfStudents());
    }
}

class Student {
    private String name;
    private static Integer numOfStudents;

    static {
        numOfStudents = 0;
    }

    public Student(String name) {
        this.name = name;
        numOfStudents++;
    }

    public static Integer getNumOfStudents() {
        return numOfStudents;
    }
}
