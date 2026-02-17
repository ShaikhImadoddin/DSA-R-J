package Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class L3_Arrays {
    public static ArrayList<Integer> reverse(ArrayList<Integer> nums, int start, int end){
        ArrayList<Integer> copyArray = new ArrayList<>(nums);

        // In built collections reverse
        // Collections.reverse(copyArray);

        int i = start;
        int j = end;

        // Two pointer approach
        while(i < j){
            Collections.swap(copyArray,i,j);
            i++;
            j--;
        }

        // return reversed array
        return copyArray;
    }

    public static ArrayList<Integer> shiftRightByOne(ArrayList<Integer> nums){
        int shift = 1;
        int i = 0;
        int j = nums.size()-1;
        ArrayList<Integer> numsCopy = new ArrayList<>(nums);
        nums = reverse(numsCopy, i, j);

        nums = reverse(nums,i+shift,j);
    
        return nums;
    }

    public static ArrayList<Integer> shiftRightByone_method_1(final ArrayList<Integer> nums){
        int n = nums.size();
        // copy nums
        ArrayList<Integer> numsCopy = new ArrayList<>(nums);

        // last element
        int lastElement = numsCopy.get(n-1);

        // rotating elements using loops linear algorithm
        for(int i=n-1;i>=0;i--){
            if(i != 0){
                numsCopy.set(i,numsCopy.get(i-1));
            }
            else{
                numsCopy.set(i,lastElement);
            }
        }

        // return copy
        return numsCopy;
    }

    public static ArrayList<Integer> rotateRight(ArrayList<Integer> nums,int k){
        int n = nums.size();
        if (n == 0) return nums;

        // 1. Modulo k to handle cases where k > n
        k %= n;
        if (k == 0) return nums;

        // 2. Create a copy of the original nums
        ArrayList<Integer> copyNums = new ArrayList<>(nums);

        // 3. Declare temp Array to store last k elements
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=n-k;i<n;i++){
            temp.add(nums.get(i));
        }
        
        // 4. Shifting remaining elements to the right by k in copyNums
        for(int i=n-k-1;i>=0;i--){
            copyNums.set(i+k,copyNums.get(i)); 
        }

        // 5. Place temp elements at the beginning of copyNums
        for(int i=0;i<k;i++){
            copyNums.set(i,temp.get(i));
        }

        return copyNums;
    }

    public static void printRowWise(int [][] arr){
        System.out.println("Row wise");

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
               System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void printColWise(int [][] arr){
        System.out.println("Col wise");

        int rowSize = arr.length;
        int colSize = arr[0].length;
        
        for(int j=0;j<colSize;j++){
            for(int i=0;i<rowSize;i++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void printRowWiseSum(int [][] arr){
        System.out.println("Row wise sum:");

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int i=0;i<rowSize;i++){
            int rowSum = 0;
            for(int j=0;j<colSize;j++){
                rowSum += arr[i][j];
            }
            System.out.println(i+" row sum "+rowSum);
            
        }
    }

    public static void printColWiseSum(int [][] arr){
        System.out.println("Col wise sum:");

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int j=0;j<colSize;j++){
            int colSum = 0;
            for(int i=0;i<rowSize;i++){
                colSum += arr[i][j];
            }
            System.out.println(j+" col sum "+colSum);
            
        }
    }

    public static void searchIn2DArray(int [][] arr,int target){
        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(arr[i][j] == target){
                    System.out.println("Found");
                    return;
                }
            }
        }

        System.out.println("Not Found");
    }

        public static void searchMaxAndMinIn2DArray(int [][] arr){
        int rowSize = arr.length;
        int colSize = arr[0].length;
        
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(Max < arr[i][j])
                    Max = arr[i][j];

                if(Min > arr[i][j])
                    Min = arr[i][j];
            }
        }

        System.out.println("Max Value is: "+Max);
        System.out.println("Min Value is: "+Min);
        
    }


    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        // Shift Array Elements by One Position

        /*
        In this problem, you are given an array of integers, and your task is to shift all its elements to the right by one position. This means that each element should move one place to the right, and the last element of the array should wrap around and move to the first position. This kind of operation is commonly known as a right rotation of the array.

        For example, consider an array [1, 2, 3, 4]. After performing a right shift, it will transform into [4, 1, 2, 3].

        Your task is to implement this rotation functionality efficiently, maintaining the circular nature of the shift.

        Example 1:
        Input: arr = [1]

        Output: [1]
        Explanation:A single-element array remains the same after shifting.

        Example 2:

        Input: arr = [1, 2]

        Output: [2, 1]
        Explanation:Array with two elements shifted by one position.

        Example 3:

        Input: arr = [1, 2, 3]

        Output: [3, 1, 2]
        Explanation:Array shifted by one position.
         */

        // ArrayList<Integer> nums = new ArrayList<>();
        // System.out.println("Enter numbers (type a non-integer to stop):");
        // while(sc.hasNextInt()){
        //     nums.add(sc.nextInt());
        // }
        // ArrayList<Integer> ans = new ArrayList<>();
        // ans = shiftRightByone_method_1(nums);
        // System.out.println("Original "+nums);
        // System.out.println("Rotated " + ans);
         

        // Rotate an Array

        /*
        You are given an array of integers nums and a non-negative integer k. Your task is to rotate the array to the right by k steps, and you must do this in-place with a space complexity of O(1), meaning that the operation should use minimal extra space. This problem challenges your understanding of array manipulation and in-place algorithms.

        In an array rotation, each element is shifted to the right. The last element moves to the first position, and all other elements are also shifted. When the array is rotated by k steps, an element that was at index i will move to index (i + k) % length of array.

        Example
        Example 1:
        Input:

        nums = [1, 2, 3, 4, 5, 6, 7], k = 3

        Output:

        [5, 6, 7, 1, 2, 3, 4]

        Explanation:

        Rotating the array to the right by 3 steps produces the array [5, 6, 7, 1, 2, 3, 4]. Elements are moved to the right, and the trailing elements are repositioned at the beginning of the array.
        Example 2:
        Input:

        nums = [-1, -100, 3, 99], k = 2

        Output:

        [3, 99, -1, -100]

        Explanation:

        Rotating the array to the right by 2 steps results in [3, 99, -1, -100]. The elements at the end wrap around to the start of the array.
        Note
        The number of rotations exceeds the array length in some cases. Take into consideration that rotating the array n times results in the same arrangement as rotating it n % length of array times, thus simplifying the problem.
        */

        // ArrayList<Integer> nums = new ArrayList<>();
        // System.out.println("Enter char value to stop input: ");
        // while(sc.hasNextInt()){
        //     nums.add(sc.nextInt());
        // }

        // sc.next();

        // System.out.println("Enter how much you want to rotate: ");
        // int k = sc.nextInt();
        // ArrayList<Integer> ans = rotateRight(nums, k);

        // System.out.println("Original: "+nums);
        // System.out.println("Rotated by "+k+" : "+ans);

        /* 2D Arrays */

        // static input

        // int[][] matrix = {
        //     {1, 2, 3}, // Row 0
        //     {4, 5, 6}, // Row 1
        //     {7, 8, 9}  // Row 2
        // };

        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6}
        // };

        // Dynamic Input from user

        // int [][] matrix = new int[3][3];

        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print("Enter value for row " + i + " col " + j + ": ");
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // printRowWise(matrix);
        // printColWise(matrix);
        // printRowWiseSum(matrix);
        // printColWiseSum(matrix);

        // Search target in 2d Array

        int [][] matrix = {
            {1,2,10},
            {11,21,22},
            {33,44,55}
        };

        int target = 55;
        searchIn2DArray(matrix,target);
        searchMaxAndMinIn2DArray(matrix);

        sc.close();
    }    
}
