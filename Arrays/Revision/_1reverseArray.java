package Arrays.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1reverseArray {

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

    public static int[] reverseArray(int n,int[] arr){
        int[] reversedArray = Arrays.copyOf(arr, n);

        int i=0;
        int j = n - 1;

        while(i <= j){
            int temp = reversedArray[i];
            reversedArray[i] = reversedArray[j];
            reversedArray[j] = temp;
            i++;
            j--;
        }
        return reversedArray;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Array Size
        String arraySizeLine = nextDataLine(br); 
        if(arraySizeLine == null){
            System.out.println("No input found");
            return;
        }
        int n;
        try{
            n = Integer.parseInt(arraySizeLine);    
        }catch(NumberFormatException e){
            System.out.println("Invalid input");
            return;
        }

        if(n <= 0){
            System.out.println("Invalid array size");
            return;
        }

        // Array Elements
        String arrayElementsLine = nextDataLine(br);
        if(arrayElementsLine == null){
            System.out.println("No input found");
            return;
        }
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(arrayElementsLine);

        for(int i=0;i<n;i++){
            if(!st.hasMoreTokens()){
                System.out.println("Not Enough Elements");
                return;
            }

            String token = st.nextToken().trim();

            try{
                arr[i] = Integer.parseInt(token);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid integer value");
                return;
            }

        }

        System.out.println(Arrays.toString(reverseArray(n, arr)));
     
    }
}
