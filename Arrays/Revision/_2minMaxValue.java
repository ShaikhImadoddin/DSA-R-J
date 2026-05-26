package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2minMaxValue {
     public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] findMinMax(int[] nums){
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
        
        int[] pair = new int[2];
        pair[0] = min;
        pair[1] = max;
        
        return pair;
    }
    
	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arrayElementLine = nextDataLine(br);

        if(arrayElementLine == null){
            System.out.println("No input found");
            return;
        }
		
		StringTokenizer st = new StringTokenizer(arrayElementLine);
		
		int n = st.countTokens();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
		  if(st.hasMoreTokens()){
		      String token = st.nextToken().trim();
		      
		      try{
		         nums[i] = Integer.parseInt(token);
		      }
		      catch(NumberFormatException e){
		          System.out.println("Invalid Data Input : Data type should be integer");
                  return;
		      }
		  }
		}

        if(n == 0){
            System.out.println("Array cannot be empty");
            return;
        }
		
		int[] result = findMinMax(nums);
		
		System.out.println(Arrays.toString(result));
	}
}
