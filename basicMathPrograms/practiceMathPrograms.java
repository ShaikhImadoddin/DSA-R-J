package basicMathPrograms;
import java.util.Scanner;
import java.util.ArrayList;
// import java.util.List;
import java.util.Collections;

public class practiceMathPrograms {

    public static double convertKmToMiles(int Km) {
        double miles = 0.621371;
        return Km*miles;
    }

    public static int areaOfCircle(int radius) {
       return (int)(3.14 * Math.pow(radius,2));
    }

    public static boolean isPrime(int n) {
        // Your code here
        if(n==1) 
            return false;

        for(int i=2;i < n;i++){
            if(n%i == 0)
                return false;
        }

        return true;
    }

    public static ArrayList<Integer> printPrimes(int N){

        ArrayList<Integer> primes = new ArrayList<>();

        for(int i=2;i<=N;i++){
            if(isPrime(i) == true)
                primes.add(i);
        }
        return primes;
    }

    public static int setKthBit(int n, int k) {
        // Complete the logic here
        int value = 1 << k;

        return n | value;
    }

    public static double convertTemperature(double temp, String conversionType) {
        // Implement the conversion here
        if (conversionType.equalsIgnoreCase("CtoF")){
            return (double)(temp * 9.0/5.0 + 32);
        }
        else if(conversionType.equalsIgnoreCase("FtoC")){
            return (double)((temp - 32) * 5.0/9.0);
        }
        return temp;
    }

    public static int countTotalSetBits(int n) {
        // Implement logic here
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // Fix: Use Java's built-in bit counter
            count += Integer.bitCount(i);
        }
        return count;
    }

    public static Long createLargestNumber(ArrayList<Integer> digits) {
    
        // step 1: array sorting in descending order
        Collections.sort(digits, Collections.reverseOrder());

        // declare largest Number Variable
        Long largestNum = 0L;
        // step 2: accessing each element and multplying with 
        for(int i=0;i<digits.size();i++){
            largestNum = largestNum*10 + digits.get(i);
        }
        return largestNum;

    }

    public static void printDigits(long N){
        String sN = String.valueOf(N);

        for(int i=0;i<sN.length();i++){
            System.out.print(sN.charAt(i));
            if(i != sN.length()-1)
                System.out.print("*");
        }

        System.out.println("");
        System.out.println("Done Math Practice Problems");
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // Km to miles

        // int Km = 10;
        // double ans = convertKmToMiles(Km);
        // System.out.println(ans);

        // area of circle

        // int radius = 5;
        // int ans = areaOfCircle(radius);
        // System.out.println(ans);

        // check if given number is prime

        // System.out.print("Enter number: ");
        // int num = sc.nextInt();
        // boolean ans = isPrime(num);
        // System.out.println(ans);

        // Print All Prime Numbers from 1 to N

        // System.out.print("Enter number: ");
        // int num = sc.nextInt();
        // ArrayList<Integer> ans = printPrimes(num);
        // System.out.println(ans);

        // Set the Kth Bit

        /*
        Approach

        Identify the bit to manipulate: Understand that bits are indexed from 0 (least significant bit) to 31.

        Create a mask: Shift the binary number 1 to the left by k bits. This mask will have a 1 in the k-th position and 0 in all other positions. For example, if k = 2, 1 << k becomes 0000 0100.

        Apply the mask using OR: Use the bitwise OR operation to merge the mask with the original number n. This operation sets the k-th bit of n based on the mask. If the k-th bit is already 1, it remains 1.

        Return the result: The resulting number now has the k-th bit set to 1.This efficient manipulation ensures only the desired bit is modified, leaving the rest of the bits intact.
         */

        // int ans = setKthBit(10,2);
        // System.out.println(ans);

        // Convert Temperature Between Celsius and Fahrenheit

        /*
        Examples:
        
        Example 1:
        Input:

        temp = 0, conversion = "CtoF"
        Output: 32.00

        Explanation: 0 degrees Celsius is equivalent to 32 degrees Fahrenheit.

        Example 2:
        Input:

        temp = 32, conversion = "FtoC"
        Output: 0.00

        Explanation: 32 degrees Fahrenheit is equivalent to 0 degrees Celsius.

        For "CtoF": Calculate the Fahrenheit value using F = C * 9/5 + 32.
        For "FtoC": Calculate the Celsius value using C = (F - 32) * 5/9.
        */
        
        // System.out.println("Enter the Temp Value");
        // double temp = sc.nextDouble();
        // System.out.println("Enter CtoF of FtoC: ");
        // String conversionType = sc.next();
        // double ans = convertTemperature(temp, conversionType);
        // System.out.println(ans);

        // Count Total Set Bits in a Number

        // System.out.println("Enter the Number");
        // int num = sc.nextInt();
        // int ans = countTotalSetBits(num);
        // System.out.println("Total set bits are: "+ans);

        // Create a Number Using Given Digits

        // ArrayList<Integer> digits = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,0));
        // Long ans = createLargestNumber(digits);
        // System.out.println(ans);
        
        // Print all Digits of an Integer

        /*
        Description
        Your task is to write a program that takes a non-negative integer N and prints each of its individual digits, separated by a single space. The digits must be printed in their original order, from left to right (from the most significant digit to the least significant digit).

        For example, if the input is 12345, the output should be: 1 2 3 4 5

        If the input is 908, the output should be: 9 0 8
         */
        System.out.println("Enter the value of No: ");
        int N = sc.nextInt();
        printDigits(N);
        sc.close();
    }
}
