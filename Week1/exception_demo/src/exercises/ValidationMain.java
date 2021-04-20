package exercises;

public class ValidationMain {
    public static void main(String[] args) {
        Validation v = new Validation();
        try {
            if (v.isValidMobileNumber("+1-1234567890"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
