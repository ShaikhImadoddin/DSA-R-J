/*
Problem Statement:
Given an array of N integers and a target value K, find two numbers in the
array whose sum is equal to K.

Print the pair of numbers in the order they appear in the array.

If multiple pairs exist, print the first valid pair encountered while
traversing the array from left to right.

If no such pair exists, print "No Pair Found".

Input Format:
- First line contains an integer N, representing the number of elements.
- Second line contains N space-separated integers.
- Third line contains an integer K, representing the target sum.

Output Format:
- Print the two numbers separated by a space if a valid pair exists.
- Otherwise, print -1 -1.

Constraints:
2 <= N <= 100000
-10^9 <= A[i] <= 10^9
-10^9 <= K <= 10^9

Sample Input 1:
4
2 7 11 15
9

Sample Output 1:
2 7

Sample Input 2:
5
3 1 4 6 5
10

Sample Output 2:
4 6

Sample Input 3:
4
1 2 3 4
10

Sample Output 3:
-1 -1
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _6twoSum
{   
    public static String nextDataLine(BufferedReader br) throws IOException{
        
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty())
            line = br.readLine();
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] twoSum(int[] nums,int target){
        int n = nums.length;
        
        int [] pair = {-1, -1};
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    pair[0] = nums[i];
                    pair[1] = nums[j];
                    return pair;
                }
            }
        }
        return pair;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arraySize = nextDataLine(br);
		if(arraySize == null) 
		    return;
		
		int n;
		
		
		try{
		    n = Integer.parseInt(arraySize);
		} catch(NumberFormatException e){
		    return;
		}
		    
		
		String arrayElements = nextDataLine(br);
		if(arrayElements == null) 
		    return;
		
		StringTokenizer st = new StringTokenizer(arrayElements);
		int [] nums = new int [n];
		for(int i=0;i<n;i++){
		    String token = st.nextToken().trim();
		    try{
		        nums[i] = Integer.parseInt(token);
		    } catch(NumberFormatException e){
		        return;
		    }
		        
		}
		
		String targetLine = nextDataLine(br);
		if(targetLine == null) 
		    return;
		
		int target;
		try{
		   target = Integer.parseInt(targetLine);
		}
		catch(NumberFormatException e){
		    return;
		}
		
		System.out.println(Arrays.toString(twoSum(nums,target)));
		
	}
}
