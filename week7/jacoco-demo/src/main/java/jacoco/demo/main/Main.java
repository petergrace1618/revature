package jacoco.demo.main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter an integer: ");
        int n = JacocoDemo.getInt();
        System.out.println((JacocoDemo.isPrime(n))
                ? n+" is prime."
                : n+" is not prime."
        );
    }
}
