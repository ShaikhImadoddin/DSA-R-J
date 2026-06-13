package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7printAllUniquePairs {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null){
            return null;
        }
        
        return line.trim();
    }
    
    public static void printAllUniquePairs(int [] nums){
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<=i;j++){
                System.out.print(nums[i]+","+nums[j]+" ");
            }
            System.out.println();
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = nextDataLine(br);
		if(line == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		StringTokenizer st = new StringTokenizer(line);
		
		int n = st.countTokens();
		int [] nums = new int[n];
		
		for(int i=0;i<n;i++){
		    String token = st.nextToken().trim();
		    
		    try{
		        nums[i] = Integer.parseInt(token);
		    }
		    catch(NumberFormatException e){
		        System.out.println("Invalid Data Type: "+token);
		        return;
		    }
		}
		
		printAllUniquePairs(nums);
	}
}
