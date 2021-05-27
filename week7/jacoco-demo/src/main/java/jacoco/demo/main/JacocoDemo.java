package jacoco.demo.main;

import java.util.Scanner;

public class JacocoDemo {
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean valid = false;
        String s = "";
        do {
            try {
                s = scanner.nextLine();
                n = Integer.parseInt(s);
                valid = true;
            } catch (NumberFormatException e) {
                // -9223372036854775808L, 9223372036854775807L
                System.out.println("Please enter a number between "+Integer.MIN_VALUE+" and "+Integer.MAX_VALUE);
            }
        } while(!valid);
        return n;
    }

    public static boolean isPrime(int n) {
        if (n <= 3)
            return n > 1;
        if ((n % 2 == 0) || (n % 3 == 0))
            return false;
        int i = 5;
        while (i * i <= n) {
            if ((n % i == 0) || (n % (i + 2) == 0))
                return false;
            i += 6;
        }
        return true;
    }
}
