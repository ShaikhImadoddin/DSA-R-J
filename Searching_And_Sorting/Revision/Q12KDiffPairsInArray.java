package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 532. K-diff Pairs in an Array Leetcode 532

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

 

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
 

Constraints:

1 <= nums.length <= 104
-107 <= nums[i] <= 107
0 <= k <= 107
 */

public class Q12KDiffPairsInArray {

    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        return line;
    }

    public static int bs(int[] nums, int start, int x) {
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == x) {
                return mid;
            } else if (x > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Searching for nums[i] + k in the remainder of the array
            if (bs(nums, i + 1, nums[i] + k) != -1) {
                ans.add(Arrays.asList(nums[i], nums[i] + k));
            }
        }
        
        return ans.size();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = nextDataLine(br);
        StringTokenizer st = new StringTokenizer(arrayLine);
        int n = st.countTokens();

        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        String kLine = nextDataLine(br);
        int K = Integer.parseInt(kLine.trim());

        System.out.println(findPairs(nums,K));
    }   
}
