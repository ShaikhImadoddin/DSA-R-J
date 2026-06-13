/*
Problem Statement: "The Matrix Auditor"
Context:
You are tasked with analyzing a sensor grid represented as an N x M matrix. 
The system requires specific statistics to ensure all sensors are 
functioning within operational parameters.
Input Format:
- The first line contains two space-separated integers, N and M 
(1 <= N, M <= 100), representing the number of rows and columns, 
respectively.
- The next N lines each contain M space-separated integers.
- Each integer A[i][j] in the matrix satisfies -10^5 <= A[i][j] <= 10^5.
Requirements:
Your program must process the matrix and output the following information:
1. Row Analysis: For each row (from index 0 to N-1), calculate and print 
the sum of its elements.
2. Column Analysis: For each column (from index 0 to M-1), calculate and 
print the sum of its elements.
3. Global Extremes: Identify and print the maximum value present in the 
entire matrix and the minimum value present in the entire matrix.
Output Format:
- Line 1 to N: Print the sum of each row on a new line.
- Line N+1 to N+M: Print the sum of each column on a new line.
- Final Line: Print the global maximum and global minimum separated 
by a space.
Example Scenario:
Input:
2 3
1 2 3
4 5 6
Expected Output:
6
15
5 7 9
6 1
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _112dArrays
{   
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static void rowSum(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<m;j++){
                sum = sum + matrix[i][j];
            }
            System.out.println(sum);
        }
    }
    
    public static void colSum(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n
            ;j++){
                sum = sum + matrix[j][i];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
    
    
    
    public static void maxMinInMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE
        ;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
                
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.print(max+" ");
        
        System.out.print(min);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String _2darraySize = nextDataLine(br);
		
		if(_2darraySize == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		StringTokenizer st = new StringTokenizer(_2darraySize);
		int l = st.countTokens();
		if(l != 2){
		    System.out.println("Wrong Input format");
		    System.out.println("First line should contain only two elements");
		    return;
		}
		int n = Integer.parseInt(st.nextToken().trim());
		int m = Integer.parseInt(st.nextToken().trim());
		int[][] nums2d = new int[n][m];
		for(int i=0;i<n;i++){
		    String arrayElementLine = nextDataLine(br);
		    
		    if(arrayElementLine == null){
		        System.out.println("No elements found");
		        return;
		    }
		    
		    StringTokenizer se = new StringTokenizer(arrayElementLine);
		    int elementCount = se.countTokens();
		    if(elementCount != m){
		        System.out.println("wrong format elements should be "+m);
		        return;
		    }
		    
		    for(int j=0;j<m;j++){
		        int token = Integer.parseInt(se.nextToken().trim());
		        nums2d[i][j] = token;
		    }
		}
		
		System.out.println(Arrays.deepToString(nums2d));
		rowSum(nums2d);
		colSum(nums2d);
		maxMinInMatrix(nums2d);
		
		
	}
}

