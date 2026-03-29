package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1FindTarget{

    public static int findTarget(int[] nums,int target){
        int n = nums.length;

        int s = 0;
        int e = n-1;
        int mid = 0;

        while(s <= e){
            mid = s + (e-s)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException{
        // step 1 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // step 2 : take size of array
        String line1 = br.readLine();
        if(line1 == null || line1.isEmpty())
            return;
        int n = Integer.parseInt(line1.trim());

        // step 3 : take input for array space separated
        String line2 = br.readLine();
        if(line2 == null || line2.isEmpty())
            return;
        StringTokenizer st = new StringTokenizer(line2);
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // step 4 : take target
        String line3 = br.readLine();
        if(line3 == null || line3.isEmpty())
            return;
        int target = Integer.parseInt(line3);

        System.out.println(findTarget(nums,target));

        br.close();
    }
}
