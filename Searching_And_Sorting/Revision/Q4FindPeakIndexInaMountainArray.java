package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

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

public class Q4FindPeakIndexInaMountainArray {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        return line;
    }

    public static int findPeakIndexInaMountainArray(int[] nums){
        int n = nums.length;

        if(n==1){
            return 0;
        }

        if(n==2){
            return 1;
        }

        int s = 0;
        int e = n-1;
        int mid = 0;
        int ans = -1;

        while(s<=e){
            mid = s + (e-s)/2;
            if(nums[mid] > nums[mid+1]){
                ans = mid;
                e = mid - 1;
            }
            else if(nums[mid] < nums[mid+1]){
                s = mid + 1;
            }else{
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line1 = nextDataLine(br);
        if (Line1 == null)
            return;
        // StringTokenizer st = new StringTokenizer(Line1);
        // To this (adding "," as a delimiter):
        StringTokenizer st = new StringTokenizer(Line1, ",");
        int n = st.countTokens();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        System.out.println(findPeakIndexInaMountainArray(nums));

        br.close();
    }
}
