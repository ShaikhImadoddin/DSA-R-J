/*
Find the Minimum and Maximum Element

Problem Statement:
You are given a list of integers separated by spaces. Your task is to determine the smallest and largest values among them.

Input:
A single line containing space-separated integers.

Output:
Print the minimum value and the maximum value separated by a space.

Constraints:
1 ≤ Total elements ≤ 100000
-10^9 ≤ Each element ≤ 10^9

Example 1:

Input:
10 20 30 40 50

Output:
10 50
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _2minMaxValue {
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty())
            line = br.readLine();
            
        if(line == null)
            return null;
            
        return line.trim();
        
    }
    
    public static int[] minMaxValue(int[] nums){
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            
            if(nums[i] < min){
                min = nums[i];
            }
            
            if(nums[i] > max){
                max = nums[i];
            }
            
        }
        
        int [] pair = new int[2];
        
        pair[0] = min;
        pair[1] = max;
        
        return pair;
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String arrayLine = nextDataLine(br);
        
        if(arrayLine == null){
            System.out.println("No Input Data");
            return;
        }
        
        StringTokenizer st = new StringTokenizer(arrayLine);
        
        int n = st.countTokens();
        int nums[] = new int[n];
        System.out.println("The number of tokens are: "+n);
        int i =0;
        while(n > 0){

            if(!st.hasMoreTokens()){
                System.out.println("Not Enough Elements");
                return;
            }
            
            String token = st.nextToken().trim();
            
            try{
                nums[i] = Integer.parseInt(token);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid integer value");
                return;
            }
            i++;
            n--;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(minMaxValue(nums)));
    }
}
