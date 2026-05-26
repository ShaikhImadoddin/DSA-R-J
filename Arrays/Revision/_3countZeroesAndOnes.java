package Arrays.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class _3countZeroesAndOnes
{   
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int[] countZeroesAndOnes(int[] nums){
        int n = nums.length;
        int zc = 0;
        int oc;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zc++;
            }
        }
        oc = n-zc;
        
        return new int[] {zc,oc};
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arrayElementLine = nextDataLine(br);
		if(arrayElementLine == null){
		    System.out.println("No Data Entered");
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
                System.out.println("Invalid Data");
                return;
            }
        }		
		
	    int[] result = countZeroesAndOnes(nums);
	    
	    System.out.println(Arrays.toString(result));
	
	}
}
