package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
public class Q9_FindQuotient{

    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        return line;
    }

    public static long solution(long dividend, long divisor) {
        long s = 0;
        long e = dividend;
        long mid = 0;
        long ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;

            if (divisor * mid == dividend) {
                return mid;
            } else if (divisor * mid > dividend) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    public static long findQuotient(int dividend,int divisor){
        // Handle the edge case of division by zero
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // Cast to long BEFORE calling Math.abs() to handle Integer.MIN_VALUE safely
        long safeDividend = Math.abs((long) dividend);
        long safeDivisor = Math.abs((long) divisor);

        // Pass the safe, positive longs into the binary search
        long ans = solution(safeDividend, safeDivisor);

        // Determine if the final answer should be positive or negative
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return ans;
        } else {
            return -ans;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = nextDataLine(br);
        if(line1 == null)
            return;
        int dividend = Integer.parseInt(line1);

        String line2 = nextDataLine(br);
        if(line2 == null)
            return;
        int divisor = Integer.parseInt(line2);

        System.out.println(findQuotient(dividend, divisor));
    }
}
