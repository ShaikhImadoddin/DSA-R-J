package Searching_And_Sorting;
import java.util.ArrayList;
import java.util.Scanner;

public class L2_Binary_Search {

     public static ArrayList<Integer> takeInputInArrayList(Scanner sc){
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter the size of ArrayList: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.printf("Enter the element at nums[%d]: ",i);
            nums.add(sc.nextInt());
        }

        return nums;
    }

    public static int peakIndexInMountainArray(ArrayList<Integer> nums){
        int n = nums.size();

        int s = 0;
        int e = n-1;
        int mid = 0;
        int peakIndex = 0;

        while(s <= e){
            mid = s + (e-s)/2;
            
            if(nums.get(mid) < nums.get(mid+1)){
                // l1
                s = mid +1;
            }
            else if(nums.get(mid) > nums.get(mid+1) && (mid+1) < n){
                // l2
                peakIndex = mid;
                e = mid - 1;
            }
        }

        return peakIndex;
    }

    public static int mySqrt(int x){
        int s = 0;
        int e = x;
        int mid = 0;
        long product = 0;
        int ans = 0;
        while(s <= e){

            mid = s + (e-s)/2;

            product = mid * mid;

            if(product == x){
                return mid;
            }
            else if(product > x){
                e = mid - 1;
            }
            else if(product < x){
                ans = mid;
                s = mid + 1;
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> takeInputInMatrix(Scanner sc){
        ArrayList<ArrayList<Integer>> Matrix = new ArrayList<>();

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();


        System.out.println("Enter the number of cols: ");
        int cols = sc.nextInt();

        for(int i=0;i<rows;i++){
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int j=0;j<cols;j++){
                System.out.printf("Enter the element at Matrix[%d][%d]: ",i,j);
                rowList.add(sc.nextInt());
            }
            Matrix.add(rowList);
        }

        return Matrix;
    }
    
    public static boolean searchInMatrix(ArrayList<ArrayList<Integer>> matrix, int target){
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int totalElements = rows*cols;

        int s = 0;
        int e = totalElements-1;
        int mid = 0;

        while(s <= e){
            mid = s + (e-s)/2;

            int rowIndex = mid/cols;
            int colIndex = mid%cols;
            if(matrix.get(rowIndex).get(colIndex) == target){
                return true;
            }
            else if(matrix.get(rowIndex).get(colIndex) < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return false;
    }

    public static int findPivotIndex(ArrayList<Integer> nums){
        int n = nums.size();

        int s = 0;
        int e = n-1;

        int mid = 0;

        // if(nums.get(0) < nums.get(n-1)){
        //     return -1;
        // }

        while(s <= e){
            mid = s + (e-s)/2;
            if(s == e){
                return mid;
            }
           if(mid+1 < n && nums.get(mid) > nums.get(mid+1)){
                return mid;
           }
           else if(nums.get(mid) < nums.get(0)){
                e = mid - 1;
           }
           else if(nums.get(mid) >= nums.get(0)){
                s = mid + 1;
           }

        }

        return -1;
    }

    public static int binarySearch(int s,int e, ArrayList<Integer> nums, int target){
        int mid = 0;
        while( s <= e){
            mid = s + (e-s)/2;

            if(nums.get(mid) == target){
                return mid;
            }
            else if(nums.get(mid) < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int search(ArrayList<Integer> nums, int target) {
        
        int n  = nums.size();

        int pivotIndex = findPivotIndex(nums);

        if(target > nums.get(0) && target <= nums.get(pivotIndex)){
            return binarySearch(0, pivotIndex, nums, target);
        }
        else{
            return binarySearch(pivotIndex+1, n-1, nums, target);
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Find Peak Index in a Mountain Array

        /*  
        Example 1:
            Input: arr = [0, 2, 5, 3, 1]
            Output: 2

        In this example, the peak element is 5, located at index 2.

        Example 2:
            Input: arr = [1, 3, 5, 4, 2]
            Output:2
        */

        // ArrayList<Integer> nums = new ArrayList<>();
        // nums = takeInputInArrayList(sc);
        // int peakIndex = peakIndexInMountainArray(nums);
        // System.out.println("Peak index is: "+peakIndex);

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

        // System.out.println("Enter the number: ");
        // int x = sc.nextInt();
        // int ans = mySqrt(x);
        // System.out.println("Sqaure root of "+x+" is :"+ans);

        // mySqrt(x);

        // Search an Element in a 2D Matrix

        /*
        You are provided with an m x n matrix, where each row and each column are sorted in ascending order. Your task is to find out whether a given target number exists in this matrix. The matrix is structured in such a way that facilitates efficient searching due to its sorted properties. Your goal is to implement the function bool searchMatrix(vector<vector<int>>& matrix, int target) that returns true if the target is present in the matrix, and false otherwise.

        Example 1:
        Input: matrix = [[1, 3, 5], [7, 9, 11], [13, 15, 17]], target = 9

        Output: true

        Example 2:

        Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], target = 10

        Output: false
        
        Constraints

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 300
        -109 <= matrix[i][j] <= 109
        All the integers in each row are sorted in ascending order.
        All the integers in each column are sorted in ascending order.
        -109 <= target <= 109
        */

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // matrix = takeInputInMatrix(sc);

        // System.out.println("Enter the target: ");
        // int target = sc.nextInt();
        // boolean ans = searchInMatrix(matrix, target);


        // if(ans == true){
        //     System.out.println("Found");
        // }
        // else{
        //     System.out.println("Not Found");
        // }

        // Find the pivot index in rotated array

        // ArrayList<Integer> nums = new ArrayList<>();
        // nums = takeInputInArrayList(sc);
        // int pivot = findPivotIndex(nums);
        // System.out.println("Pivot index is: "+pivot);

        // Search in rotated sorted array

        ArrayList<Integer> nums = new ArrayList<>();
        nums = takeInputInArrayList(sc);
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        int ans = search(nums, target);
        System.out.println(ans);
        
        sc.close();
    }
}
