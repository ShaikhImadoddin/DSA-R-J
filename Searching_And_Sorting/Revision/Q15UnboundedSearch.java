package Searching_And_Sorting.Revision;

import java.util.Scanner;

class InfiniteArray {
    private int[] arr;

    public InfiniteArray(int[] nums) {
        this.arr = nums;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE; 
        }
        return arr[index];
    }
}

public class Q15UnboundedSearch {

    public static int unboundedSearch(InfiniteArray arr, int target) {
    
        if (arr.get(0) == target) {
            return 0;
        }

        int left = 0;
        int right = 1;

        while (arr.get(right) < target) {
            left = right;
            right *= 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2; 
            int midVal = arr.get(mid);

            if (midVal == target) {
                return mid; 
            } else if (midVal < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        InfiniteArray infiniteArr = new InfiniteArray(nums);

        System.out.println("Simulated Infinite Array starts with: [1, 2, 4, 8, 16, 32, 64, 128, ...]");
        System.out.print("Enter the target value to search: ");
        
        if (scanner.hasNextInt()) {
            int target = scanner.nextInt();
            
            int result = unboundedSearch(infiniteArr, target);
            
            if (result != -1) {
                System.out.println("Output: " + result);
                System.out.println("Explanation: Target " + target + " is found at index " + result + ".");
            } else {
                System.out.println("Output: -1");
                System.out.println("Explanation: Target " + target + " is not present in the array.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}
