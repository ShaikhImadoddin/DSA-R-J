package Arrays.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _6printAllPossiblePairs
{   
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static void printAllPossiblePairs(int [] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(nums[i] +","+nums[j]+" ");
            }
            System.out.println();
        }
    }
    
    
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Program Started: ");
		String arrayElementLine = nextDataLine(br);
		if(arrayElementLine == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		StringTokenizer st = new StringTokenizer(arrayElementLine);
		
		int n = st.countTokens();
		
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++){
		    String token = st.nextToken().trim();
		    
		    try{
		        nums[i] = Integer.parseInt(token);
		    }
		    catch(NumberFormatException e){
		        System.out.println("Invalid Datatype: " + token);
		        return;
		    }
		}
		
		printAllPossiblePairs(nums);
	}
}

