package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// Search in rotated sorted array Leetcode 33


public class Q8SearchInRotatedSortedArray {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        return line;
    }

    public static int binarySearchForQ8(int[] nums,int target,int s,int e){
        int mid = s + (e-s)/2;

        while(s <= e){
            mid = s + (e-s)/2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target){
        int n = nums.length;

        int pivotIndex = Q7FindThePivotIndexOfARotatedArray.findPivot(nums);

        if(target >= nums[0] && target <= nums[pivotIndex]){
            return binarySearchForQ8(nums,target,0,pivotIndex);
        }
        else{
            return binarySearchForQ8(nums,target,pivotIndex+1,n-1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = nextDataLine(br);

        arrayLine = arrayLine.replaceAll("[\\[\\]\\,]"," ");
        StringTokenizer st = new StringTokenizer(arrayLine);
        int n = st.countTokens();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        String targetLine = nextDataLine(br);

        int target = Integer.parseInt(targetLine.trim());
        System.out.println(search(nums,target));
    }
}
