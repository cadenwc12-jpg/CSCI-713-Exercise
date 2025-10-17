import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    // Bug: returns first student if list is empty
    public Student getTopStudent() {
        Student top = students.get(0);  // Potential IndexOutOfBoundsException
        for (Student s : students) {
            if (s.getGpa() < top.getGpa()) {
                top = s;
            }
        }
        return top;
    }

    // Code smell: duplicated logic in loop
    public double calculateAverageGpa() {
        double total = 0.0;
        for (Student s : students) {
            total += s.getGpa();
        }
        if (students.size() > 0) {
            return total / students.size();
        } else {
            return 0.0;
        }
    }

    // Unused method (code smell)
    public void removeStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equals(name)) {
                students.remove(s);  // Bug: ConcurrentModificationException possible
            }
        }
    }
}
