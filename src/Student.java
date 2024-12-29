import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender, int studentID) {
        super(name, surname, age, gender);
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
