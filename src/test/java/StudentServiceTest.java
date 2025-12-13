import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ConcurrentModificationException;

class StudentServiceTest {

    private StudentService service = new StudentService();
    
    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

        @Test
    void testAvgGpaEmpty() {
        assertEquals(0.0, service.calculateAverageGpa(), 0.0001);
    }

    @Test
    void testAvgGpaNormal() {
        service.addStudent(new Student("A", 20, 4.0));
        service.addStudent(new Student("B", 21, 3.0));
        assertEquals(3.5, service.calculateAverageGpa(), 0.0001);
    }

    @Test
    void testTopStudentEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.getTopStudent());
    }

    @Test
    void testTopStudentNormal() {
        Student high = new Student("High", 22, 3.9);
        Student low = new Student("Low", 20, 2.5);
        service.addStudent(low);
        service.addStudent(high);
        assertSame(high, service.getTopStudent());
    }

    @Test
    void testRemoveExisting() {
        Student s = new Student("Alice", 20, 3.8);
        service.addStudent(s);
        service.addStudent(new Student("Bob", 21, 3.5));

        service.removeStudentByName("Alice");

        assertEquals("Bob", service.getTopStudent().getName());
    }

    @Test
    void testRemoveMissing() {
        Student s = new Student("Charlie", 22, 3.7);
        service.addStudent(s);

        service.removeStudentByName("Unknown");

        assertSame(s, service.getTopStudent());
    }

    @Test
    void testRemoveConcurrentMod() {
        service.addStudent(new Student("Alice", 20, 3.8));
        service.addStudent(new Student("Alice", 21, 3.9));

        assertThrows(ConcurrentModificationException.class,
            () -> service.removeStudentByName("Alice"));
    }

    // Intentionally leave out tests for:
    // - removeStudentByName
    // - behavior with empty student list
    // - Utils methods
}
