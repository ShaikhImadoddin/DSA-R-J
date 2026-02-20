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

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter non integer value to stop: ");

        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        int ans = findFirstUnsortedIndex(arr);
        System.out.println(ans);


        sc.close();
    }
}
