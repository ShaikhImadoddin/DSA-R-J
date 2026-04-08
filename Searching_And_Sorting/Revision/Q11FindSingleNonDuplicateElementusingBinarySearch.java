package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Find Single Non-Duplicate Element using Binary Search

/*
    You are given a sorted array consisting of n integers where every element appears exactly twice, except for one element which appears exactly once. Your task is to find this single non-duplicate element in the array. The array is structured in such a way that it guarantees that exactly one element appears once, while every other element appears twice.

    To solve this problem efficiently, you should implement an algorithm with O(log n) runtime complexity.

    Example:

    Input: nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]

    Output: 2

    Explanation: Here, each element appears twice except for 2, which appears only once. Therefore, 2 is the single non-duplicate element in the array.

    Example 2:

    Input: [3,3,7,7,10,11,11]

    Output:10

    Explanation:The unique element in the array is 10.

    Example 3:

    Input: [1,1,2,2,3]

    Output:3

    Explanation:The unique element in the array is 3.

    Constraints:

    The length of the array `n` is odd.
    1 <= n <= 10000
    0 <= nums[i] <= 10^5
    nums must contain exactly one element that appears once.
    The rest elements appear exactly twice.
*/

public class Q11FindSingleNonDuplicateElementusingBinarySearch{

    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        if(line  != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    public static int findSingleNonDuplicateElementusingBinarySearch(int [] nums){
        int n = nums.length;
        
        // If the array has only one element
        if (n == 1) {
            return nums[0];
        }

        // If the first element is the unique one
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // If the last element is the unique one
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        
        int s = 1;
        int e = n - 2;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // even/odd index logic to move s or e
            boolean isEvenIndex = (mid % 2 == 0);
            
            if (isEvenIndex) {
                if (nums[mid] == nums[mid + 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1; 
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = nextDataLine(br);

        StringTokenizer st = new StringTokenizer(arrayLine, ",");
        int n = st.countTokens();

        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        System.out.println(findSingleNonDuplicateElementusingBinarySearch(nums));
    }
}