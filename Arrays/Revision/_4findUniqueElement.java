package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4findUniqueElement {
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line =  br.readLine();
        
        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        
        if(line == null) return null;
        
        return line.trim();
    }
    
    public static int findUniqueElement(int[] nums){
        int n = nums.length;
        int  uniqueNum = 0;
        for(int i=0;i<n;i++){
            uniqueNum ^= nums[i];
        }
        
        return uniqueNum;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Started");
        String arrayElementLine = nextDataLine(br);
        
        if(arrayElementLine == null){
            return;
        }
        
        StringTokenizer st = new StringTokenizer(arrayElementLine);
        
        int n = st.countTokens();
        int nums[] = new int[n];
        
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
        
        int ans = findUniqueElement(nums);
        System.out.println("Unique Element is: "+ans);
    }
}
