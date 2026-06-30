import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1reverseArray
{   
    // for skipping empty lines
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
        
    }
    
    public static int[] reverseArray(int[] arr,int n){
        int[] reversedArray = Arrays.copyOf(arr, n);
        
        int l = 0;
        int h = n-1;
        
        while(l < h){
            int temp = reversedArray[l];
            reversedArray[l] = reversedArray[h];
            reversedArray[h] = temp;
            l++;
            h--;
        }
        
        return reversedArray;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Array Size
		String arraySize = nextDataLine(br);
		if(arraySize == null){
		    System.out.println("No Input Input");
		    return;
		}
		
		int n;
		
		try{
		    n = Integer.parseInt(arraySize);
		} catch(NumberFormatException e){
		    System.out.println("Invalid Input");
		    return;
		}
		
		if(n <= 0){
		    System.out.println("Invalid array size");
		    return;
		}
		
		// Array Elements
		
		String arrayElementsLine = nextDataLine(br);
		
		if(arrayElementsLine == null){
		    System.out.println("No Input Data");
		    return;
		}
		
		StringTokenizer st = new StringTokenizer(arrayElementsLine);
		
		int [] arr = new int[n];
		int nt = st.countTokens();
		if(n == nt){
		    for(int i=0;i<n;i++){
		        String token = st.nextToken().trim();
		        try{
		            arr[i] = Integer.parseInt(token);
		        }catch(NumberFormatException e){
		            System.out.println("Invalid Integer Value");
		            return;
		        }
		    }
		}
		else{
		    System.out.println("Enter only "+n+" elements in array");
		    return;
		}
		
	    System.out.println(Arrays.toString(reverseArray(arr,n)));
	}
}
