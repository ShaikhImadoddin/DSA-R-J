package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class L1_Arrays{

    public static int searchElement(int[] numbers, int target){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == target)
                return numbers[i];
        }
        return -1;
    }

    public static double findAverage(int[] numbers){
        // Edge case: handle empty arrays to avoid Division by Zero error
        if (numbers == null || numbers.length == 0) 
            return 0.0;

        int totalsum = 0;
        for(int i=0;i<numbers.length;i++){
            totalsum += numbers[i];
        }
        return (double)totalsum/numbers.length;
    }

    public static void minMaxValue(int[] numbers){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<numbers.length;i++){

            if(numbers[i] > max){
                max = numbers[i];
            }

            if(numbers[i] < min){
                min = numbers[i];
            }

        }

        System.out.println("MIN is " + min);
        System.out.println("Max is "+ max);
    }

    public static void multiplyByTen(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }
    }

    public static int[] countZeroesAndOnes(int[] nums){
        int zeroCount = 0;
        int oneCount = 0;
        for(int num : nums){
            if(num == 0)
                zeroCount++;
            else if(num == 1)
                oneCount++;
        }
        return new int[] {zeroCount,oneCount};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /*  
            DECLARATION & INITIALIZATION
            1D Array: int[] arr = new int[size];
            2D Array: int[][] matrix = new int[rows][cols];
        */

        // System.out.print("Enter size of array: ");
        // int n = sc.nextInt();
        // int[] numbers = new int[n];

        // Taking Input

        // System.out.println("Enter " + n + " elements:");
        // for (int i = 0; i < n; i++) {
        //     numbers[i] = sc.nextInt();
        // }

        // 1. Accessing & Length
        // Use .length property (not a method like .length())

        // System.out.println("Array length is: " + numbers.length);

        // 2. Linear Search

        // int [] numbers = {10,20,30,40,50};
        // System.out.print("Enter element to search: ");
        // int target = sc.nextInt();
        // int index = searchElement(numbers, target);
        // System.out.println("Element found at index: " + index);

        // 3. Find the Average

        // int[] numbers = {10,20,30,40,50};
        // System.out.println("Average: " + findAverage(numbers));

        //4. find min and max

        // int[] numbers = {10,20,30,40,50};
        // minMaxValue(numbers);

        // 5. Multiply by 10

        // int[] numbers = {10,20,30,40,50};
        // multiplyByTen(numbers);
        // System.out.println("After multiplying by 10: " + Arrays.toString(numbers));

        // 6. syntax to copy array

        // int[] numbers = {10,20,30,40,50};
        // int[] copyArray = Arrays.copyOf(numbers, numbers.length);
        // System.out.println("Copied array is :" + Arrays.toString(copyArray));

        // 7. count zeroes and ones

        // int[] nums = {0,1,0,0,0,1,1,1,0};
        // int[] ans = countZeroesAndOnes(nums);
        // System.out.println("Zero count "+ans[0]);
        // System.out.println("One count "+ans[1]);


        // 8. fill array function
        int[] namefillArray = new int[100];
        Arrays.fill(namefillArray,7);
        System.out.println(Arrays.toString(namefillArray));
        sc.close();
    }
}