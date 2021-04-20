package org.example;

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
    public void testIsPrimeValid() {
        for (int n: new int[]{2,3,5,7,11,13,17,19,23,29,31,37})
            Assertions.assertEquals(true, validation.isPrime(n));
    }

    @Test
    public void testIsPrimeInvalid() {
        for (int n: new int[]{4,6,8,9,10,12,14,15,16,18,20,21})
            Assertions.assertEquals(false, validation.isPrime(n));
    }

    @Test

    public void testIsPrimeForLessThan2() {
        for (int n: new int[]{1,0,-1,-2,-3})
            Assertions.assertFalse(validation.isPrime(n));
    }
}
