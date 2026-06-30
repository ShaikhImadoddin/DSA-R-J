/* 
You are given an array consisting only of 0s and 1s. Your task is to count the number of zeros and the number of ones present in the array.

Input Format:
A single line containing space-separated integers.

Output Format:
Print two space-separated integers:
- The count of zeros.
- The count of ones.

Constraints:
1 ≤ Total elements ≤ 100000
0 ≤ A[i] ≤ 1

Sample Input 1:
0 1 1 0 1 0 0 1

Sample Output 1:
4 4

Explanation:
The array contains 4 zeros and 4 ones.

Sample Input 2:
1 1 1 1 1

Sample Output 2:
0 5

Sample Input 3:
0 0 0 0 0

Sample Output 3:
5 0
*/



import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _3countZeroesAndOnes{
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()) line = br.readLine();
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] countZeroAndOnes(int[] nums){
        int n = nums.length;
        int countZero = 0;
        int countOne = 0;
        
        int pair [] = new int [2];
        for(int i=0;i<n;i++){
            
            if(nums[i] == 0)
                countZero++;
            
            
            if(nums[i] == 1) 
                countOne++;
        }
        
        pair[0] = countZero;
        pair[1] = countOne;
        
        return pair;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String arrayElementsLine = nextDataLine(br);
        
        if(arrayElementsLine == null) {
            System.out.println("No input data");
            return;
        }
        
        StringTokenizer st = new StringTokenizer(arrayElementsLine);
        
        int n = st.countTokens();
        int[] nums = new int[n];
        int i=0;
        
        while(st.hasMoreTokens()){
            String token = st.nextToken().trim();
            try{
                nums[i] = Integer.parseInt(token);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid data type");
                return;
            }
            i++;
        }
        
        System.out.println(Arrays.toString(countZeroAndOnes(nums)));
        
    }
}
