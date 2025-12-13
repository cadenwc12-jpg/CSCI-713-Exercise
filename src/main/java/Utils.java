
public class Utils {

    // Poor naming, duplicate logic, code smell
    public static boolean checkName(String name) {
        if (name != null && name.length() > 0) return true;
        else return false;
    }

    public static boolean isValidAge(int age) {
        if (age < 0) return false;
        else return true;  // Bug: Allows age > 120
    }

}
