import java.util.Scanner;

public class Method_L6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String sanitizedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = Palindrome.isPalindrome(sanitizedString);
        if (isPalindrome) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

class Palindrome {
    private String word;

    public Palindrome(String word) {
        this.word = word;
    }

    public static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }
}