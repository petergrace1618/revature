package examples;

public class PalindromeDemo {
    public static void main(String[] args) {
        String[] testStrings = {
                "palindrome",
                "detartrated",
                "Don't have a cow, Man!",
                "Sir, I demand, I am a maid named Iris.",
                "Never odd or even.",
                "Poor Dan is in a droop.",
                "1234567890987654321",
                "100 Aker Wood West",
                "!@#$%^&*()_= ",
                ")!{<A>*(B^$}+B_+][';A/.,'])",
                ""
        };

        for (String s: testStrings) {
            System.out.println("\""+s+"\" : "+isPalindrome(s));
        }
    }

    // In palindromes, spacing, punctuation, and capitalization are usually ignored.
    // https://www.dictionary.com/e/palindromic-word/
    public static boolean isPalindrome(String s) {
        // ignore case
        s = s.toLowerCase();
        // remove all non-alphanumeric chars
        s = s.replaceAll("[^a-z0-9]+", "");
        if (s.isEmpty()) return false;

        // iterate from both ends of the string
        int i = 0, j = s.length() - 1;
        while(i < j)
            if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
