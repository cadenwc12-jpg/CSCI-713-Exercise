import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testCheckNameInvalid() {
        assertFalse(Utils.checkName(null));
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameValid() {
        assertTrue(Utils.checkName("Alice"));
    }

    @Test
    void testValidAgeNegative() {
        assertFalse(Utils.isValidAge(-5));
    }

    @Test
    void testValidAgeOk() {
        assertTrue(Utils.isValidAge(0));
        assertTrue(Utils.isValidAge(25));
        assertTrue(Utils.isValidAge(150));
    }
}
