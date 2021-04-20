package exercises;

public class Validation {
    public boolean isValidMobileNumber(String contact) {
        if (!contact.matches("\\+1-[0-9]{10}")) {
            throw new InvalidMobileNumberException("Entered mobile number "+contact+" is invalid");
        } else {
            return true;
        }
    }

    public boolean isValidAge(int age) {
        if (age <= 0) {
            throw new
        }
    }
}
