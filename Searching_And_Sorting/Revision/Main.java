package Searching_And_Sorting.Revision;

import java.io.*;
import java.util.*;

/**
 * TCS NQT / Competitive Programming - Robust Java Template
 * Handles: 
 * 1. Empty lines between inputs
 * 2. Trailing/Leading spaces
 * 3. Multiple test cases (if needed)
 */
public class Main {

    // Helper method to skip empty/null lines and find the next line with actual content
    public static String nextDataLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        // The "Filter": While line exists (not null) AND is just empty/whitespace (both true)
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine(); // "Both True" -> Skip and read next
        }
        return line; // Returns the first line that actually has data
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* VARIATION 1: Standard Input
           Input:
           5
           1 2 4 5 6
        */

        String line1 = nextDataLine(br);
        if (line1 == null) return;
        int n = Integer.parseInt(line1.trim());

        /* VARIATION 2: Empty line before Array
           Input:
           5
           (blank line)
           (blank line)
           1 2 4 5 6
        */
        
        String line2 = nextDataLine(br);
        if (line2 == null) return;
        
        StringTokenizer st = new StringTokenizer(line2);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            // Variation 3: Array elements spread across multiple lines
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(nextDataLine(br));
            }
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Search Logic
        System.out.println("Missing element is: " + findMissingElement(nums));
    }

    public static int findMissingElement(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        int ans = n;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == mid) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }
}
