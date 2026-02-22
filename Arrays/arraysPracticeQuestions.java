package Arrays;
import java.util.Scanner;

public class arraysPracticeQuestions {
    
    public static int[] takeInputInArray(int [] nums,int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.printf("Enter element at nums[%d]: ",i);
            nums[i] = sc.nextInt();
        }
        sc.close();
        return nums; 
    }

    public static int missingNumber(int[] nums) {
        int xor = nums.length;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i] ^ i;
        }

        return xor;
    }

    public static int removeDuplicates(int[] nums) {

        // Array size
        int n = nums.length;

        // Edge cases
        if (n==0) return 0;
        if (n==1) return 1;


        int j = 0; // The 'slow' pointer
        int i = j+1; // The 'fast' pointer (j + 1)

        while(i < n){
            if(nums[i] == nums[j]){
                i++;
            }
            else{
                // Move slow pointer and update with new unique value
                nums[++j] = nums[i++];
            }
        }
        // j is the index, so length is j + 1
        return j+1;
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // Missing Number

        // System.out.println("Enter size of array: ");
        // int n = sc.nextInt();

        // // declaring array of n size;
        // int[] nums = new int[n];

        // // take input in array of size n;
        // nums = takeInputInArray(nums, n);
        
        // int ans = missingNumber(nums);
        // System.out.println(ans);

        // Remove Duplicates from Sorted Array

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        // declaring array of size n
        int[] nums = new int[n];

        // take input in array of size n;
        nums = takeInputInArray(nums, n);

        int ans = removeDuplicates(nums);
        System.out.println(ans);

        // 

        sc.close();
    }
}
