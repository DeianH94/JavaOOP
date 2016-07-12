package StaticMembers.Pr02UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UniqueStudentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String studentName = reader.readLine();

        while (!studentName.toLowerCase().equals("end")) {
            Student student = new Student(studentName);
            studentName = reader.readLine();
        }

        System.out.println(StudentGroup.getNumOfStudents());
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
        StudentGroup.addUniqueStudents(this.name);
    }
}

class StudentGroup {
    private static HashSet<String> uniqueStudents;
    private static Integer numOfStudents;

    static {
        uniqueStudents = new HashSet<>();
        numOfStudents = 0;
    }

    public static void addUniqueStudents(String studentName) {
        if (!uniqueStudents.contains(studentName)) {
            uniqueStudents.add(studentName);
            numOfStudents++;
        }
    }

    public static Integer getNumOfStudents() {
        return numOfStudents;
    }
}