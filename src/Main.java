import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();


        File studentFile = new File("C:\\Users\\Шынарай\\Downloads\\students (1).txt");
        Scanner studentScanner = new Scanner(studentFile);

        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine();
            String[] data = line.split(" ");
            if (data.length >= 5) {
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = Boolean.parseBoolean(data[3]);
                int studentID = Integer.parseInt(data[4]);
                Student student = new Student(name, surname, age, gender, studentID);
                for (int i = 5; i < data.length; i++) {
                    student.addGrade(Integer.parseInt(data[i]));
                }
                students.add(student);
            } else {
                System.out.println("Invalid data format in students.txt: " + line);
            }
        }


        File teacherFile = new File("C:\\Users\\Шынарай\\Downloads\\teachers.txt");
        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNextLine()) {
            String line = teacherScanner.nextLine();
            String[] data = line.split(" ");
            if (data.length == 7) {
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = Boolean.parseBoolean(data[3]);
                String subject = data[4];
                int yearsOfExperience = Integer.parseInt(data[5]);
                int salary = Integer.parseInt(data[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                teachers.add(teacher);
            } else {
                System.out.println("Invalid data format in teachers.txt: " + line);
            }
        }


        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student);
            System.out.println("GPA: " + student.calculateGPA());
        }

        System.out.println("\nTeachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
