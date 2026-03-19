package Searching_And_Sorting;

import java.util.Scanner;

public class L3_Binary_Search {
    public static long solution(long dividend, long divisor){
        long s = 0;
        long e = dividend;

        long mid = 0;
        long ans = -1;

        while(s <= e){
            mid  = s + (e-s)/2;

            // check mid for valid answer
            if(divisor * mid == dividend)
                    return mid;
            else if(divisor * mid > dividend)
                    e = mid - 1;
            else{   
                    ans  = mid;
                    s = mid + 1;
            }
        }

        return ans;
    }

    public static long findQuotient(long dividend,long divisor){
        long ans  = solution(Math.abs(dividend), Math.abs(divisor));

        if((dividend>0 && divisor>0) || (dividend<0 && divisor < 0))
            return ans;
        else
            return (0-ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Find Quotient Without Using Division and Modulus Operators

        /*
        You have been given two integers, dividend and divisor, and your task is to compute the quotient resulting from dividing dividend by divisor without using the built-in division (/) or modulus (%) operators. The result should be the quotient of the division truncated towards zero, which means the fractional part of the result should be discarded.

        While implementing the function, handle the case of division by zero by returning the maximum positive integer value (INT_MAX).

        Examples:
        Example 1:
        Input:
        dividend = 10
        divisor = 3
        Output:
        3
        Explanation: Performing the division 10 / 3 results in 3.3333..., and after truncation towards zero, the result is 3.
        Example 2:
        Input:
        dividend = 7
        divisor = -3
        Output:
        -2
        Explanation: Performing the division 7 / -3 results in -2.3333..., and after truncation towards zero, the result is -2.
        Your task is to implement the function:


        int findQuotient(int dividend, int divisor)
        This function returns the integer quotient of dividing dividend by divisor with truncation towards zero.
         */
        System.out.println("Enter value of dividend: ");
        long dividend = sc.nextLong();
        System.out.println("Enter value of divisor: ");
        long divisor = sc.nextLong();
        long ans = findQuotient(dividend, divisor);
        System.out.println("Ans: "+ ans);

        sc.close();
    }
}
