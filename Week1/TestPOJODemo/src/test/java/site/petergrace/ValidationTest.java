package site.petergrace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private static Validation validation;

    @BeforeAll
    public static void setupValidation() {
        validation = new Validation();
    }

    @Test
    public void testIsFibonacciValid() {
        for(int n: new int[] {0,1,2,3,5,8,13,21,34})
            Assertions.assertTrue(validation.isFibonacci(n));
    }

    @Test
    public void testIsFibonacciInvalid() {
        for(int n: new int[] {4,6,7,9,10,11,12,14,15,16,17,18})
            Assertions.assertFalse(validation.isFibonacci(n));
    }

    @Test
    public void testIsFibonacciThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->validation.isFibonacci(-1));
    }
}
