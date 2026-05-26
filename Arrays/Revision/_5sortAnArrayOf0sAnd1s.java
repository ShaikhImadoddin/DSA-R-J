package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5sortAnArrayOf0sAnd1s{
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] sortAnArrayOf0sAnd1s(int [] nums){
        int n = nums.length;
        int countOnes = 0;
        int [] result = new int[n];
        
        for(int i=0;i<n;i++){
            if(nums[i] == 1) countOnes++;
        }
        
        for(int i= (n)-countOnes;i<n;i++){
            result[i] = 1;
        }
        
        return result;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//
		String arrayElementLine = nextDataLine(br);
		if(arrayElementLine == null){
		    System.out.println("No Input Data: ");
		    return;
		}
		
		StringTokenizer st = new StringTokenizer(arrayElementLine);
		
		int n = st.countTokens();
		int [] nums = new int [n];
		for(int i=0;i<n;i++){
		    String token = st.nextToken().trim();
		    try{
		        nums[i] = Integer.parseInt(token);
		        // validation
                if(nums[i] != 0 && nums[i] != 1){
                    System.out.println("Array must contain only 0s and 1s");
                    return;
                }
		    }
		    catch(NumberFormatException e){
		        System.out.println("Invalid data");
		        return;
		    }
		}
		
		int [] sortedArray = sortAnArrayOf0sAnd1s(nums);
		
		System.out.println(Arrays.toString(sortedArray));
	}
}