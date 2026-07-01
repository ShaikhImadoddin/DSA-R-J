/*
Problem: Sort an Array of 0s and 1s

Problem Statement:

You are given a binary sequence consisting only of 0s and 1s. Your task is to rearrange the elements so that all 0s appear before all 1s.

Input Format:
The first line contains a binary string S.

Output Format:
Print the sorted sequence as space-separated integers.

Constraints:
1 ≤ |S| ≤ 100000
S[i] ∈ {'0', '1'}

Sample Input 1:
010101

Sample Output 1:
0 0 0 1 1 1

Explanation:
The sequence contains three 0s and three 1s. After sorting, all 0s are placed before all 1s.

Sample Input 2:
11111

Sample Output 2:
1 1 1 1 1

Sample Input 3:
00000

Sample Output 3:
0 0 0 0 0.java
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5sortAnArrayOf0sAnd1s
{   
    public static String nextDataLine(BufferedReader br) throws IOException{
        
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty())
            line = br.readLine();
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] sortAnArrayOf0sAnd1s(int[] nums){
        int n = nums.length;
        
        int[] sorted = Arrays.copyOf(nums,n);
        System.out.println(Arrays.toString(sorted));
        
        int s = 0;
        int e = n-1;
        
        while(s < e){
            
            if(sorted[s] != 0 && sorted[e] != 1){
                int temp = sorted[s];
                sorted[s] = sorted[e];
                sorted[e] = temp;
                
                s++;
                e--;
            }
            else if(sorted[s] == 0 && sorted[e] == 1){
                s++;
                e--;
            }
            else if(sorted[e] == 1){
                e--;
            }
            else if(sorted[s] == 0 ){
                s++;
            }
            
            System.out.println("Inside: "+Arrays.toString(sorted));
            
            
        }
        return sorted;
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arrayLine = nextDataLine(br);
		
		if(arrayLine == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		char[] charArray = arrayLine.toCharArray();
		
		int n = charArray.length;
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++){
		    char token = charArray[i];
		    
		    if (token == '0' || token == '1') {
                // nums[i] = Character.getNumericValue(token);
                nums[i] = token - '0';
            }
            else{
                System.out.println("Invalid Input");
                return;
            }
		}
		
		int[] sortedArray = sortAnArrayOf0sAnd1s(nums);
		System.out.println(Arrays.toString(sortedArray));
	}
}