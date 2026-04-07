package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Find the Pivot Index of a Rotated Array

You are given an array that has been rotated at some pivot unknown to you beforehand. The array was initially sorted in increasing order, and then rotated at the pivot. Your task is to find the pivot index, which is the index of the highest element in the array (i.e., the last element of the unrotated sorted array).

A rotated sorted array means that you take a portion of a sorted array from some index k to the end, and move it to the front. For example, the sorted array [0, 1, 2, 4, 5, 6, 7] after being rotated at pivot index 3, becomes [4, 5, 6, 7, 0, 1, 2].

Your Task:
Write a function to return the index of the pivot.

Example:
Input: nums = [4, 5, 6, 7, 0, 1, 2]

Output: 3

Explanation: In this array, the pivot point is the index 3 because the array [4, 5, 6, 7], when combined with [0, 1, 2], forms the original sorted array [0, 1, 2, 4, 5, 6, 7].

Example 1:

Input: nums = [3, 4, 5, 1, 2]

Output: 2

Example 2:

Input: nums = [4, 5, 6, 7, 0, 1, 2]

Output: 3

Example 3:

Input: nums = [1, 2, 3, 4, 5]

Output:-1

Constraints

1 <= nums.length <= 105
-104 <= nums[i] <= 104
All integers in nums are unique.
*/

public class Q7FindThePivotIndexOfARotatedArray {
    // helper function for ignoring empty lines
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    // Binary Search to find the pivot index
    public static int findPivot(int[] nums) {
        int n = nums.length;
        
        // Edge case: Array is strictly increasing (not rotated or empty)
        if (n == 0 || nums[0] <= nums[n - 1]) {
            return -1;
        }
        
        int s = 0;
        int e = n-1;
        int mid = -1;

        while(s <= e){
            mid = s + (e-s)/2;

            if(mid < e && nums[mid] > nums[mid + 1]){
                return mid;
            }

            if(mid > s && nums[mid] < nums[mid - 1]){
                return mid-1;
            }

            if(nums[s] <= nums[mid]){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return mid;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the first valid line of input
        String inputLine = nextDataLine(br);
        if (inputLine == null) return;

        // Clean the input of brackets and commas in case it's pasted like [1, 2, 3, 4, 5]
        inputLine = inputLine.replaceAll("[\\[\\]\\,]", " ").trim();
        StringTokenizer st = new StringTokenizer(inputLine);

        // Initialize array and populate it
        int n = st.countTokens();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        // Find and print the pivot index
        System.out.println(findPivot(nums));

        br.close();
    }
}
