package Arrays;

import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


import java.util.ArrayList;

public class Ms_Arrays {
    public static void rotateImage(int[][] matrix){
        int n = matrix.length;
        
        // transpose it 
        for(int j=0;j<n;j++){
            for(int i=0;i<j;i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // reverse
        for(int i=0;i<n;i++){

            int left = 0;
            int right = n-1;

            while(left < right){
                // swap
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

        System.out.println(Arrays.deepToString(matrix));  
        
    }

    public static ArrayList<Integer> printExtremeElementsAlternatively(ArrayList<Integer> matrix){
        Collections.sort(matrix);

        int left = 0;
        int right = matrix.size() - 1;

        ArrayList<Integer> extremeElements = new ArrayList<>();

        while(left <= right){
        
            if(left == right)
                    extremeElements.add(matrix.get(left));
            else{
                extremeElements.add(matrix.get(left));
                extremeElements.add(matrix.get(right));
            }

            left++;
            right--;
            
        }
        return extremeElements;
    }

    public static ArrayList<Integer> sumPositiveNegative(ArrayList<Integer> arr){
        int positiveSum = 0;
        int negativeSum = 0;
        for(int a : arr){
            if(a > 0){
                positiveSum += a;
            }
            else{
                negativeSum += a;
            }
        }
        return  new ArrayList<Integer>(List.of(positiveSum,negativeSum));
    }

    public static int findFirstUnsortedIndex(ArrayList<Integer> arr){
        int n = arr.size();

        // Loop until n-1 to prevent index out of bounds when checking i+1
        for(int i=0;i<n-1;i++){
            if(arr.get(i) > arr.get(i+1))
                return i;
        }
        
        // If the loop completes, the array is sorted
        return -1;
    }

    public static int findMode(int[] arr) {
        // size of array
        int n = arr.length;

        if(n==0) return 0;
        // sort 
        Arrays.sort(arr);

        // declaring variable mode which means least number repeated most times
        int mode = arr[0];

        // count frequencies
        int currentFrequency = 1;
        int maxFrequency = 1;

        // main logic
        for(int i=1;i<n;i++){
            // if current element is equal to previous element increase curr freq then compare with max freq 
            if(arr[i-1] == arr[i]){
                currentFrequency++;
                if(currentFrequency > maxFrequency){
                    maxFrequency = currentFrequency;
                    mode = arr[i];
                }
            }
            else{
                currentFrequency = 1;
            }
        }
        // return element
        return mode;
    }

    public static int[] highestAndLowestFrequency(int[] arr){
        // size of array
        int n = arr.length;

        if (n == 0) return new int[]{0, 0};

        int[] ans = new int[2];

        // 1. Get the High Frequency (Mode)
        ans[0] = findMode(arr);

        // 2. Prepare for Low Frequency
        Arrays.sort(arr);
        int mode = arr[0];
        int currentFrequency = 1;
    
        // Start with a large number so the first group always becomes the new min
        int minFrequency = Integer.MAX_VALUE; 

        // Main logic for Lowest Frequency
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                currentFrequency++;
            } else {
                // A streak just ended! Compare the finished streak
                if (currentFrequency < minFrequency) {
                    minFrequency = currentFrequency;
                    mode = arr[i - 1]; // The number that just finished its streak
                }
                // Reset for the new number
                currentFrequency = 1;
            }
        }

        // FINAL CHECK: Handle the very last group after the loop finishes
        if (currentFrequency < minFrequency) {
            minFrequency = currentFrequency;
            mode = arr[n - 1];
        }

        ans[1] = mode;

        return ans;  
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 48. Rotate Image Leetcode

        // System.out.println("Enter the size of n*n array : ");
        // int n = sc.nextInt();
        
        // int[][] matrix = new int[n][n];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.printf("Enter the elements at [%d],[%d]: ",i,j);
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }
        // rotateImage(matrix);

        // Print Extreme Elements Alternately 

        /*
        Given an array of integers, your task is to output the elements in an alternating fashion starting with the smallest, then the largest, followed by the next smallest, the next largest, and so on.
        
        To achieve this, you will first sort the array. Then you will begin with the smallest element, followed by the largest, then the next smallest, and continue this pattern until all elements are printed.

        Example
        Input: [1, 3, 2, 4, 5]
        Output: 1 5 2 4 3
        */
  
        // ArrayList<Integer> matrix = new ArrayList<>();
        // System.out.println("Enter a non integer value to stop: ");
        // while(sc.hasNextInt()){
        //     matrix.add(sc.nextInt());
        // }

        // ArrayList<Integer> ans = printExtremeElementsAlternatively(matrix);
        // System.out.println(ans);

        //  Return Sum of Positive and Negative Elements in Array Using Pair

        /*
        Given an array of integers, your task is to implement a function that calculates two separate sums: one for all the positive integers in the array, and another for all the negative integers. The function should return these two sums as a pair (tuple) of integers.

        The first integer in the pair should be the sum of all positive numbers.
        The second integer should be the sum of all negative numbers.
        Example:
        Example 1:
        Input: [-1, 2, 3, -4, 5]

        Output: (10, -5)

        Here, the positive numbers are [2, 3, 5], whose sum is 10.
        The negative numbers are [-1, -4], whose sum is -5.
        This problem tests your ability to traverse an array and perform conditional aggregation based on the sign of each element.
        
        */

        // ArrayList<Integer> arr = new ArrayList<>();
        // System.out.println("Enter non integer value to stop: ");

        // while(sc.hasNextInt()){
        //     arr.add(sc.nextInt());
        // }

        // ArrayList<Integer> ans = sumPositiveNegative(arr);
        // System.out.println(ans);

        // Find First Unsorted Element in Array
        
        /*
        Given an array of integers, your task is to find the index of the first element that disrupts the sorted order of the array. In a non-decreasing order sequence, each element should be less than or equal to the next element.

        If the array is already sorted or maintains the non-decreasing order criterion throughout, return -1.

        Example
        Input: [1, 2, 3, 4, 6, 5, 7, 8]
        Output: 4
        In the given input, elements from index 0 to 3 (1, 2, 3, 4) are in non-decreasing order. The element at index 4 is 6, which is followed by 5 at index 5, violating the non-decreasing order since 6 is greater than 5. Hence, index 4 is the first unsorted element.

        Try to identify this pattern and apply the logic to solve the problem for any given input array.
        */

        // ArrayList<Integer> arr = new ArrayList<>();
        // System.out.println("Enter non integer value to stop: ");

        // while(sc.hasNextInt()){
        //     arr.add(sc.nextInt());
        // }
        // int ans = findFirstUnsortedIndex(arr);
        // System.out.println(ans);

        // Find the Mode of the Array

        /*
        Given an array of integers, determine the mode of the array. The mode is the element that appears most frequently in the array. If there is more than one element with the highest frequency of appearances, return the smallest of these elements.

        Example
        Example 1:
        Input: [3, 3, 2, 1, 5, 1]
        Output: 1
        Explanation: The numbers 3 and 1 both appear twice, but 1 is smaller than 3, so 1 is the mode.
        */

        // System.out.println("Enter the size of Array : ");
        // int n = sc.nextInt();

        // int[] arr = new int[n];

        // for(int i=0;i<n;i++){
        //     System.out.printf("Enter element at arr[%d]: ",i);
        //     arr[i] = sc.nextInt();
        // }
            
        
        // int ans = findMode(arr);
        // System.out.println("Mode Element is: " + ans);

        // Identify Elements with Highest and Lowest Frequency Separately

        /*
        Problem Description
        You are given an array of integers. Your task is to identify two elements: the one that appears with the highest frequency and the one that appears with the lowest frequency in the array. In the event that multiple elements share the same highest or lowest frequency, select the smallest element among those.

        Example:
        Input:

        [4, 4, 1, 2, 2, 2, 3, 3, 3, 3]

        Output:
        Highest Frequency Element: 3
        Lowest Frequency Element: 1
        */
        System.out.println("Enter the size of Array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            System.out.printf("Enter element at arr[%d]: ",i);
            arr[i] = sc.nextInt();
        }
            
        
        int[] ans = highestAndLowestFrequency(arr);
        // System.out.println("Mode Element is: " + ans);
        for(int a : ans)
            System.out.println(a);

        sc.close();
    }
}
