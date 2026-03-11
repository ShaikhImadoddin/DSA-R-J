package Searching_And_Sorting;
import java.util.Scanner;
import java.util.ArrayList;

public class L1_Binary_Search {
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

    public static int findTargetUsingBinarySearch(ArrayList<Integer> nums,int target){
        // array size
        int n = nums.size();
        
        int s = 0; // start index
        int e = n-1; // end index
        int mid = 0;
        while(s <= e){
            // Safe way to calculate mid to avoid integer overflow
            mid = s + (e-s)/2;

            // Check if target is equal to mid
            if(nums.get(mid) == target){
                return mid;
            }
            // If mid is greater than target, search the left half
            else if(nums.get(mid) > target){
                e = mid - 1;
            }
            // If mid is less than target, search the right half
            else{
                s = mid + 1;
            }
        }
        // Target not found
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Binary Search Implementation

        /*
        In this problem, you are provided with a sorted array of integers arr and an integer target. Your task is to implement a binary search algorithm to find the index of target in arr. If the target does not exist in the array, you should return -1.

        Example 1:
        Input: arr = [-1, 0, 3, 5, 9, 12], target = 9
        Output: 4
        Explanation: The number 9 is located at index 4 in the array.
        */
        
        ArrayList<Integer> nums = new ArrayList<>();
        nums = takeInputInArrayList(sc);

        System.out.println("Enter the target: ");
        int target = sc.nextInt();
        int ans = findTargetUsingBinarySearch(nums,target);
        System.out.println("Target found at index : "+ans);
        sc.close();
    }
}
