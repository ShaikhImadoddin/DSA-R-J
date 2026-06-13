package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10rotateArray {
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if (line == null) return null;
        
        return line.trim();
    }
    
    public static int[] reverseArray(int[] nums,int start,int end){
        int n = nums.length;
        int[] reversedArray = Arrays.copyOf(nums,n);
        while(start <= end){
            int temp = reversedArray[start];
            reversedArray[start] = reversedArray[end];
            reversedArray[end] = temp;
            start++;
            end--;
        }
        return reversedArray;
    }
    
    public static int[] rotateArray(int[] nums,int k){
        int n = nums.length;
        int [] rotatedArray = Arrays.copyOf(nums,n);
        int i=0;
        int j=n-1;
        k %= n;
        
        rotatedArray= reverseArray(rotatedArray,i,j);
        rotatedArray= reverseArray(rotatedArray,i,k-1);
        rotatedArray= reverseArray(rotatedArray,k,j);
        
        return rotatedArray;
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		        System.out.println("Invalid Data Type: "+ token);
                return;
		    }
		}
		
		String kLine = nextDataLine(br);
		if(kLine == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		int k=0;
		
		try{
		    k = Integer.parseInt(kLine);
		}
		catch(NumberFormatException e){
		    System.out.println("Invalid Data Type: "+kLine);
		}
		
		int [] ans = rotateArray(nums,k);
		System.out.println(Arrays.toString(ans));
	}
}
