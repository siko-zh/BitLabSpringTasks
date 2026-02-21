package com.zholdigaliev.studentlist.DBManager;

import com.zholdigaliev.studentlist.Model.Student;
import lombok.Getter;

import java.util.ArrayList;


public class DBManager {
    private static Long id = 9L;
    @Getter
    private static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "MukhammedAlibek", "Mahmeden", 95,  "A"));
        students.add(new Student(2L, "Nuraly", "Rakhmetov", 95,  "A"));
        students.add(new Student(3L, "Eraly", "Rakhmetov", 85,  "B"));
        students.add(new Student(4L, "Ernaz", "Moldiev", 90,  "A"));
        students.add(new Student(5L, "Serik", "Zholdigaliev", 90,  "A"));
        students.add(new Student(6L, "Dimuhanbet", "Kobzhanov", 48,  "F"));
        students.add(new Student(7L, "Patrick", "Bateman", 80,  "B"));
        students.add(new Student(8L, "Luffy", "Monkey", 38,  "F"));
    }

    public static void addStudent(Student student) {
        student.setId(id);
        id++;
        if (student.getExam() >= 90) {
            student.setMark("A");
            students.add(student);
        } else if (student.getExam() >= 75) {
            student.setMark("B");
            students.add(student);
        } else if (student.getExam() >= 60) {
            student.setMark("C");
            students.add(student);
        } else if (student.getExam() >= 50){
            student.setMark("D");
            students.add(student);
        } else {
            student.setMark("F");
            students.add(student);
        }
    }

}
