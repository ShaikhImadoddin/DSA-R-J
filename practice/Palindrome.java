import java.util.*;

public class Palindrome{
    public static boolean isPalindrome(String s){
        if (s == null) return false;
        
        String reversed = new StringBuilder(s).reverse().toString();
        
        return s.equalsIgnoreCase(reversed);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();
        boolean ans = isPalindrome(s);
        if (ans){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        sc.close();
    }
}