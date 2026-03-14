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

        ArrayList<Integer> nums = new ArrayList<>();
        nums = takeInputInArrayList(sc);
        int peakIndex = peakIndexInMountainArray(nums);
        System.out.println("Peak index is: "+peakIndex);

    }
}
