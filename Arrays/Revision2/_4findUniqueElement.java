/* 
Problem: Find the Unique Element

Problem Statement:

You are given an array of integers in which every element appears exactly twice except for one element that appears only once. Your task is to identify and print the unique element.

Input Format:
The input may span multiple lines.
Each line contains one or more space-separated integers.
Consider all the integers across all lines as a single array.
Input terminates at End of File (EOF).

Output Format:
Print the element that occurs exactly once.

Constraints:
1 ≤ Total elements ≤ 100000
The total number of elements is always odd.
-10^9 ≤ A[i] ≤ 10^9
Exactly one element appears once, and every other element appears exactly twice.

Sample Input 1:
2 3 5
4 5
3 4

Sample Output 1:
2

Explanation:
The elements 3, 4, and 5 occur exactly twice, while 2 appears only once.

Sample Input 2:
10 20
30 10
20

Sample Output 2:
30

Sample Input 3:
-1 7
8 8
7

Sample Output 3:
-1
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class _4findUniqueElement{
    
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()) 
            line = br.readLine();
        
        if(line == null) 
            return null;
        
        return line.trim();
    }
    
    public static int findUniqueElement(int [] nums){
        int n = nums.length;
        int uniqueElement = 0;
        
        for(int i=0;i<n;i++){
            uniqueElement = uniqueElement ^ nums[i];
        }
        
        return uniqueElement;
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        String line;
        
        while ((line = nextDataLine(br)) != null) {

            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
    
                String token = st.nextToken().trim();
    
                try {
                    list.add(Integer.parseInt(token));
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid data type");
                    return;
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println("No input data");
            return;
        }
    
        int[] nums = new int[list.size()];
    
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    
        System.out.println(findUniqueElement(nums));
    }
} 