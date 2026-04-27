package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14ExponentialSearch{
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        if(line == null) return null;

        return line.trim();
    }

    // BinarySearch

    public static int binarySearch(List<Integer> nums, int s, int e,int target){
        int mid = 0;
        while(s <= e){
            mid = s + (e-s)/2;

            if(nums.get(mid) == target){
                return mid;
            }
            else  if(nums.get(mid) < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return -1;
    }

    public static int exponentialSearch(List<Integer> nums,Integer target){

        int numsSize = nums.size();

        if(numsSize < 2){
            System.out.println(nums.get(0) + " " + "is at index "+0);
        }
        
        if(nums.get(0).equals(target)){
            System.out.println(nums.get(0) + " " + "is at index "+0);
        }

        int i = 1;

        while(i <= numsSize-1 && nums.get(i) <= target  ){
            i = i*2;
        }

        int index =  binarySearch(nums,i/2,Math.min(i,numsSize-1),target);
        return index;
        
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = nextDataLine(br);
        StringTokenizer st = new StringTokenizer(arrayLine);
        
        int arraySize = st.countTokens();

        List<Integer> nums = new ArrayList<>();

        for(int i=0;i<arraySize;i++){
            Integer element = Integer.parseInt(st.nextToken().trim());
            nums.add(element);
        }

        String targetLine = nextDataLine(br);
        Integer target = Integer.parseInt(targetLine);

        System.out.println(exponentialSearch(nums,target));

        br.close();

    }
}
