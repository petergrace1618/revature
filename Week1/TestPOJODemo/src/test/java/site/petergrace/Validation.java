package site.petergrace;

import org.junit.jupiter.api.function.Executable;

public class Validation {
    public boolean isFibonacci(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return true;
        int Fn_2 = 0, Fn_1 = 1, Fn;
        do {
            Fn = Fn_2 + Fn_1;
            if (Fn == n) return true;
            Fn_2 = Fn_1;
            Fn_1 = Fn;
        } while (Fn < n);
        return false;
    }
}
