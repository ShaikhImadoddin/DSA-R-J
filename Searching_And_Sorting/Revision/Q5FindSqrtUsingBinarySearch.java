package Searching_And_Sorting.Revision;

import java.util.Scanner;

// Find Square Root using Binary Search

/*
    Example 1:
    Input: x = 16

    Output: 4

    Explanation: The integer part of the square root of 16 is 4 since 4 * 4 = 16.

    Example 2:
    Input: x = 8

    Output: 2

    Explanation: The integer part of the square root of 8 is 2 since 3 * 3 = 9 (which is greater than 8), and 2 * 2 = 4, which is less than 8.

    some key words to remember
    Search solution
*/


public class Q5FindSqrtUsingBinarySearch {
    public static int findSqrtUsingBinarySearch(int num){
        int s = 0;
        int e = num;
        int mid = 0;
        long product = 0;
        int ans = 0;

        while ( s <= e){
            mid = s + (e-s)/2;
            product = (long)(mid * mid);
            if(product > num){
                e = mid - 1;
            }
            else if(product < num){
                ans = mid;
                s = mid + 1;
            }
            else{
                return mid;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num  = sc.nextInt();

        System.out.println(findSqrtUsingBinarySearch(num));
        sc.close();
    }
}
