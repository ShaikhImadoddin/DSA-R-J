package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3BFindLastOccurence {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    public static int findLastOccurence(int [] nums,int target){
        int n = nums.length;

        int s = 0;
        int e = n-1;
        int mid = 0;
        int ans = -1;
        while(s <= e){
            mid = s + (e-s)/2;

            if(nums[mid] == target){
                ans = mid;
                s = mid + 1;
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //for n
        String line1 = nextDataLine(br);
        if(line1 == null) return;
        int n = Integer.parseInt(line1.trim());

        // for array elements
        String line2 = nextDataLine(br);
        if(line2== null) return;
        StringTokenizer st = new StringTokenizer(line2);
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        // for target
        String line3 = nextDataLine(br);
        if(line3==null) return;
        int target = Integer.parseInt(line3);

        System.out.println(findLastOccurence(nums, target));

        br.close();
    }
}
