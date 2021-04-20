package org.example;

public class Validation {

    public boolean isPrime(int n) {
        if (n == 2) return true;
        if (n < 2 || (n & 1) == 0) return false;
        for (int i = 3; i < n; i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
