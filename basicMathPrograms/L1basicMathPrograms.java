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
        System.out.println("Enter the number value");
        int num = sc.nextInt();
        int smallNum = smallestDigit(num);
        System.out.println("Small number is "+smallNum);

        sc.close();

    }
}
