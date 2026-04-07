package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10FindAnElementInNearlySortedArrayElementsCanBeSwappedWithAdjacentOnes {
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    public static int findElementInNearlySortedArray(int[] nums,int target){
        int n = nums.length;

        int s = 0;
        int e = n-1;

        int mid = -1;

        while(s<=e){
            mid = s + (e-s)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(mid + 1 <= e && nums[mid + 1] == target ){
                return mid+1;
            }
            else if(mid - 1 >= s && nums[mid - 1] == target){
                return mid -1;
            }
            else if(nums[mid] < target){
                s = mid + 2;
            }
            else if(nums[mid] > target){
                e = mid - 2;
            }
        }
        return mid;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine= nextDataLine(br);

        arrayLine = arrayLine.replaceAll("[\\[\\]\\,]"," ");
        StringTokenizer st = new StringTokenizer(arrayLine);

        int n = st.countTokens();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken().trim());
        }

        String targetLine = nextDataLine(br);
        int target= Integer.parseInt(targetLine);

        System.out.println(findElementInNearlySortedArray(nums,target));
    }
}
