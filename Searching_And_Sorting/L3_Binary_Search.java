package Searching_And_Sorting;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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

    public static int findElementInNearlySortedArray(ArrayList<Integer> arr, int K){
        int size = arr.size();

        int s = 0;
        int e = size-1;
        int mid = -1;

        while(s <= e){

            mid = s + (e-s)/2;

            if(arr.get(mid) == K){
                return mid;
            }

            if(arr.get(mid+1) == K){
                return mid+1;
            }

            if(arr.get(mid-1) == K){
                return mid-1;
            }

            if(K > arr.get(mid)){
                s = mid +1;
            }
            else{
                e = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
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

        // System.out.println("Enter value of dividend: ");
        // long dividend = sc.nextLong();
        // System.out.println("Enter value of divisor: ");
        // long divisor = sc.nextLong();
        // long ans = findQuotient(dividend, divisor);
        // System.out.println("Ans: "+ ans);

        // Find an element in nearly sorted array elements can be swapped with adjacent ones

        /*
        In a nearly sorted array, elements are expected to be in sorted order except that each element can be swapped with its adjacent elements. This means that any element at index i in a sorted array could appear at index i-1, i, or i+1 in a nearly sorted array. Your task is to determine the index of a given target element K within this array. If the element K is not present, return -1.

        Example 1: 
        n = 5
        arr = [3, 5, 10, 9, 11]
        K = 10
        Output
        2

        Constraints

        1 ≤ n ≤ 10^4
        -10^9 ≤ arr[i], K ≤ 10^9
        n is the number of elements in the array.
        */

        // Step 1: Initialize BufferedReader to read from System.in

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Step 2: Read the first line (n)

        String line1 = br.readLine();

        if(line1 == null || line1.isEmpty())
            return;

        int n = Integer.parseInt(line1.trim());

        // step 3 : read the second line array and tokenize it

        ArrayList<Integer> arr = new ArrayList<>();
        String line2 = br.readLine();
        if (line2 == null) return;

        StringTokenizer st =  new StringTokenizer(line2);

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // Step 4: Read the target K
        String line3 = br.readLine();
        if(line3 == null || line2.isEmpty()) return;
        int K = Integer.parseInt(line3.trim());

        // Output the result
        System.out.println(findElementInNearlySortedArray(arr, K));

        sc.close();
    }
}
