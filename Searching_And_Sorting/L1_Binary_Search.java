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

    public static int firstOccurence(ArrayList<Integer> nums, int target){
         // array size
        int n = nums.size();

        int s = 0;
        int e = n-1;
        int mid = 0;
        int firstOccurence = -1;
        while(s <= e){
            mid = s + (e-s)/2;

            // check if target is equal to mid if yes store it and go to left side of array to find first occurence
            if(nums.get(mid) == target){
                firstOccurence = mid;
                e = mid -1;
            }
            else if(nums.get(mid) > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return firstOccurence;
    }

    public static int lastOccurence(ArrayList<Integer> nums, int target){
        // array size
        int n = nums.size();

        int s = 0;
        int e = n-1;
        int mid = 0;
        int lastOccurence = -1;
        while(s <= e){
            mid = s + (e-s)/2;

            // check if target is equal to mid if yes store it and go to right side of array to find last occurence
            if(nums.get(mid) == target){
                lastOccurence = mid;
                s = mid + 1;
            }
            else if(nums.get(mid) > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return lastOccurence;
    }

    public static ArrayList<Integer> searchRange(ArrayList<Integer> nums,int target){
        ArrayList<Integer> ans = new ArrayList<>();

        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);

        ans.add(first);
        ans.add(last);

        return ans;
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
        
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums = takeInputInArrayList(sc);

        // System.out.println("Enter the target: ");
        // int target = sc.nextInt();
        // int ans = findTargetUsingBinarySearch(nums,target);
        // System.out.println("Target found at index : "+ans);
        
        // Find the first occurence and last occurence of target

        /*
        You are given a sorted array of integers nums and an integer target. Your task is to identify the starting and ending positions of target in the array. If target does not exist in the array, return [-1, -1].

        This problem requires you to find both the first and last positions of target efficiently. Ideally, you should aim to achieve this in O(log N) time complexity using an appropriate algorithm.

        Example 1:

        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3, 4]
        */

        ArrayList<Integer> nums = new ArrayList<>();
        nums = takeInputInArrayList(sc);
        System.out.println("Enter the target: ");
        int target = sc.nextInt();
        ArrayList<Integer> range = searchRange(nums,target);
        System.out.println("Range is : " + range);

        sc.close();
    }
}
