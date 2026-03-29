package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2FindMissingElement {
    // Find the missing element in sorted array

    /*
    Find the missing element in array 

    Array is sorted in ascending order

    elements in array are from 0 to N;

    example 1
    nums = [0,1,2,4,5,6,7]
    n = 7
    output 3 

    example 2
    nums = [0,1,2,3,4]
    n = 5
    output 5
    */
    public static int findMissingElement(int[] nums){
        int n = nums.length;

        int s = 0;
        int e = n-1;
        int mid = 0;
        int ans = n;
        while(s <= e){
            mid = s + (e-s)/2;

            if(mid == nums[mid]){
                s = mid + 1;
            }
            else if(mid != nums[mid]){
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Take size of array as input
        int n = Integer.parseInt(br.readLine().trim());

        // Declare new array
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMissingElement(nums));


        br.close();
    }
}
