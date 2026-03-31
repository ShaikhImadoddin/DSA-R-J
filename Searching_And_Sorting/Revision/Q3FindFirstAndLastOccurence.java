package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays; // Added to print the array properly

// Find First and Last Occurrence of an Element in a Sorted Array

/*
You are given a sorted array of integers nums and an integer target. Your task is to identify the starting and ending positions of target in the array. If target does not exist in the array, return [-1, -1].

This problem requires you to find both the first and last positions of target efficiently. Ideally, you should aim to achieve this in O(log N) time complexity using an appropriate algorithm.

Example 1:

Input: 
    nums = [5,7,7,8,8,10], target = 8
Output: 
    [3, 4]

Example 2:

Input: 
    nums = [5,7,7,8,8,10], target = 6
Output: 
    [-1, -1]
*/

public class Q3FindFirstAndLastOccurence {
    // Helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
           line = br.readLine();
        }
        return line;
    }

    public static int[] findFirstAndLastOccurence(int[] nums,int target){
        int[] pair = new int[2];


        int firstIndex = Q3AFindFirstOccurence.findFirstOccurence(nums, target);
        int lastIndex =  Q3BFindLastOccurence.findLastOccurence(nums, target);

        pair[0] = firstIndex;
        pair[1] = lastIndex;

        return pair;
    }
    
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input array
        String line1 = nextDataLine(br);
        if(line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);
        int n = st.countTokens();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        // target
        String line2 = nextDataLine(br);
        if(line2 == null) return;
        int target = Integer.parseInt(line2.trim());

        int [] arr = findFirstAndLastOccurence(nums,target);
        System.out.println(Arrays.toString(arr));

        br.close();
    }   
}
