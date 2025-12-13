
public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);
        Student s3 = new Student("Charlie", 19, 3.2);

        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);

        // Using removeStudentByName method
        service.removeStudentByName("Alice");
        
        // Bug: Will crash if students list is empty
        System.out.println("Top Student: " + service.getTopStudent().getName());

        // Code smell: Repeated calls, magic numbers
        System.out.println("Average GPA: " + service.calculateAverageGpa());

        // Dead code / unused
        int x = 42;
        if (x > 100) {
            System.out.println("Impossible");  // Never executes
        }
    }
}
