package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8twoSumArray {
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static void twoSum(int [] nums,int target){
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if(nums[i]+nums[j] == target){
                    System.out.println("Sum Found "+nums[i]+","+nums[j]+"="+target);
                    return;
                }
                
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String targetLine = nextDataLine(br);
		if(targetLine == null){
		    System.out.println("No Input data");
		    return;
		}
		
		int target;
		try{
		    target = Integer.parseInt(targetLine);
		}
		catch(NumberFormatException e){
		    System.out.println("Invalid Data Type: "+targetLine);
		    return;
		}
		
		String arrayElementLine = nextDataLine(br);
		if(arrayElementLine == null){
		    System.out.println("No Input data");
		    return;
		}
		StringTokenizer st = new StringTokenizer(arrayElementLine);
		int n = st.countTokens();
		int [] nums = new int[n];
		for(int i=0;i<n;i++){
		    String token = st.nextToken().trim();
		    try{
	            nums[i] = Integer.parseInt(token);
		    }
		    catch(NumberFormatException e){
		        System.out.println("Invalid Data Type: "+ token);
		        return;
		    }
		}
		
		twoSum(nums,target);
		
	}
}
