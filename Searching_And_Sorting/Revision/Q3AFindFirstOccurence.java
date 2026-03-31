package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Q3AFindFirstOccurence {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    public static int findFirstOccurence(int[] nums, int target){
         // array size
        int n = nums.length;

        int s = 0;
        int e = n-1;
        int mid = 0;
        int firstOccurence = -1;
        while(s <= e){
            mid = s + (e-s)/2;

            // check if target is equal to mid if yes store it and go to left side of array to find first occurence
            if(nums[mid] == target){
                firstOccurence = mid;
                e = mid -1;
            }
            else if(nums[mid] > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return firstOccurence;
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // step 1 take array size as input
        String line1 = nextDataLine(br);
        if(line1 == null || line1.isEmpty()){
            return;
        }
        int n = Integer.parseInt(line1);

        // step 2 take array elements as input
        String line2 = nextDataLine(br);
        if(line2 == null || line2.isEmpty()){
            return;
        }
        StringTokenizer st = new StringTokenizer(line2);
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        // step 3
        String line3 = nextDataLine(br);
        if(line3 == null || line3.isEmpty()){
            return;
        }
        int target = Integer.parseInt(line3);

        System.out.println(findFirstOccurence(nums, target));

        br.close();
    }   
}

