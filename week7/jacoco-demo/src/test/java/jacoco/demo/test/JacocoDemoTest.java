package jacoco.demo.test;

import jacoco.demo.main.JacocoDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JacocoDemoTest {

    @Test
    void isPrimeInputPrime() {
        for (int n: new int[]{2,3,5,7,11,13,17,19,23,29,31,37})
            Assertions.assertTrue(JacocoDemo.isPrime(n));
    }

    @Test
    void isPrimeInputComposite() {
        for (int n : new int[]{4,6,8,9,10,12,14,15,16,18,20,21})
            Assertions.assertFalse(JacocoDemo.isPrime(n));
    }

    @Test
    void isPrimeInputLessThan2() {
        for (int n : new int[]{-3,-2,-1,0,1})
            Assertions.assertFalse(JacocoDemo.isPrime(n));
    }
}