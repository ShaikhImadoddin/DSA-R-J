package basicMathPrograms;
import java.util.Scanner;

public class L1basicMathPrograms {
    public static int sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum +=(num % 10);
            num /= 10;
        }
        return sum;
    }

    public static int smallestDigit(int num){
        int min = Integer.MAX_VALUE;
        while(num > 0){
            int singleDigit = num % 10;
            /*
            if(singleDigit < min){
                min = singleDigit;
            }
            */
            min = Integer.min(singleDigit,min);
            num /= 10;
        }
        return min;
    }

    public static boolean evenOdd(int num){
        boolean even = false;
        if(num%2 == 0)
            even = true;
        return even;
    }

    public static boolean isOdd(int num){
        return (num & 1) == 1;
    }

    public static int reverseNumber(int num){
        int reversedNumber = 0;
        if(num == 0)
            return 0;

        while(num > 0){
            // ans =  ans * 10 + remainder
            reversedNumber = (reversedNumber * 10) + (num%10);
            num /= 10;
        }
        return reversedNumber;
    } 

    // two pointer approach
    public static String isPalindrome(int num){
        String numStr = String.valueOf(num);
        int i = 0;
        int j = numStr.length()-1;
        while(i<j){
            if(numStr.charAt(i) != numStr.charAt(j)){
                return "No palindrome";
            }
            i++;
            j--;
        }
        return "Palindrome";
    }

    // modulo approach 
    public static boolean isPalindrome_2(int num) {
        if (num < 0) return false; // Negative numbers are not palindromes
    
        int original = num;
        int reversed = 0;
    
        while (num > 0) {
            int lastDigit = num % 10;
            reversed = (reversed * 10) + lastDigit;
            num /= 10;
        }
        return original == reversed;
    }

    // reverse integer
    public static long reverseInteger (long num){
        boolean flag = true;
        long reversedNumber = 0;
        if (num == 0)
            return 0;
        else{

            if(num > 0)
                flag = true;
            else
                flag = false;
            
            num = Math.abs(num);

            while(num > 0){
                reversedNumber = (reversedNumber*10) + (num%10);
                num /= 10;
            }

            if (flag == false)
                reversedNumber = 0 - reversedNumber;
        }
        if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE)
            return 0;
        else
            return (int)reversedNumber;
    }

    public static String isPowerOfTwo(int num){
        if (num <= 0) {
            return "No power of two";
        }
        if((num & (num-1)) == 0){
            return "Yes power of two";
        }
        else{
            return "No power of two";
        }
    }

    public static String isPowerOfTwoUsingRightShift(int num){
        if (num <= 0) {
            return "No power of two";
        }
        int count = 0;
        while(num != 0){
            // Check if the last bit is 1
        count += (num & 1);
        
        // Unsigned right shift by 1 position
        num = num >>> 1;
        }

        if ( count == 1)
            return "Power of two";
        else
            return "Not power of two";
    }

    public static String isPrime(int num){
        if(num == 1)
            return "No";
        else if(num == 2 || num == 3)
            return "Yes";
        else{
            int start = 2;
            int end = num - 1;

            for(int i=start;i<=end;i++){
                if(num%i == 0)
                    return "No";
            }
        }
        return "Yes";

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 1 sum of digits

        // System.out.println("Enter the number value");
        // int num = sc.nextInt();
        // int sumAns = sumOfDigits(num);
        // System.out.println("Sum of digit is: " + sumAns);

        // 2 smallest digit 

        /*
        Problem Description
        Given a non-negative integer num, your task is to 
        determine the smallest digit present in 
        this number. For every individual digit within the 
        number, evaluate them to identify which is the smallest.
        */

        // System.out.println("Enter the number value");
        // int num = sc.nextInt();
        // int smallNum = smallestDigit(num);
        // System.out.println("Small number is "+smallNum);

        // 3 Check if a Number is Even or Odd

        // System.out.println("Enter the number value");
        // int num = sc.nextInt();
        // boolean isEvenOrOdd = evenOdd(num);
        // if(isEvenOrOdd)
        //     System.out.println("Given number " + num + " is even");
        // else
        //     System.out.println("Given number "+ num + " is odd");

        // 4 Reverse a Number

        // System.out.println("Enter the number value: ");
        // int num = sc.nextInt();
        // int reversedNumber = reverseNumber(num);
        // System.out.println("Reversed number : " + reversedNumber);

        // 5 Palindrome Number

        // System.out.println("Enter the number value: ");
        // int num = sc.nextInt();
        // String palindromeNumber = isPalindrome(num);
        // System.out.println(palindromeNumber);
        

        // Reverse an integer

        // System.out.println("Enter the integer value: ");
        // long num = sc.nextLong();
        // long reversedInteger = reverseInteger(num);
        // System.out.println("Reversed Integer is: " + reversedInteger);

        // give this input
        // case 1 : 1534236469

        // check if number is power of 2

        // question logic
        // 2&1(10 & 01) == 0 then 2 ka power wala number
        // 4&3(100 & 011) == 0 then 2 ka power wala number
        // 5&4(101 & 100) == 0 false 2 ka power wala number nhe hai

        // question basic logic
        // convert num into binary num then count set bit if set bit is only one then number is 2 ka power wala number

        // System.out.println("Enter the number: ");
        // int num = sc.nextInt();
        // String ans = isPowerOfTwoUsingRightShift(num);
        // System.out.println(ans);

        // homework count set bit using bit >>(right shift) operator  dpne
        // homework completed

        // Check Prime Number
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        String ans = isPrime(num);
        System.out.println(ans);
        
        sc.close();
    }
}
