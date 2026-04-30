package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16AllocateMinimumPages {

    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        if(line == null) return null;

        return line.trim();
    }

    public static boolean allocateBooks(int[] arr,int mid,int k){
        
        int arrSize = arr.length;
        int sum = 0;
        int students = 1;
        
        for(int i=0;i<arrSize;i++){
            if(arr[i] > mid) return false;
        
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else{
                students++;
                sum = arr[i];
            }
        }
        
        return k >= students;
        
    }
    
    public static int findPages(int[] arr, int k) {
         // code here
        int arrSize = arr.length;
        
        if(arrSize < k){
            return -1;
        }

        if (k <= 0) return -1;
        
        int s = 0;
        int e = 0;
        int mid = 0;
        int ans = -1;
        
        for(int i=0;i<arrSize;i++){
            e += arr[i]; 
            s = Math.max(s, arr[i]);
        }
        
        while(s<=e){
            mid = s + (e-s)/2;
            
            boolean isPossible = allocateBooks(arr,mid,k);
            
            if(isPossible){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        
        return ans;
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = nextDataLine(br);
        if(arrayLine == null){
            System.out.println("Invalid Data Input");
            return;
        }
        StringTokenizer st = new StringTokenizer(arrayLine);

        int arrSize = st.countTokens();
        int[] arr = new int[arrSize];

        for(int i=0;i<arrSize;i++){
            try{
                arr[i] = Integer.parseInt(st.nextToken().trim());
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input Detected");
                return;
            }
        }

        String numberOfStudents = nextDataLine(br);

        if (numberOfStudents == null) {
            System.out.println("Invalid Input Detected");
            return;
        }

        try{
            int k = Integer.parseInt(numberOfStudents.trim());
            System.out.println(findPages(arr,k));
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input Detected");
        }
        
        
    }
}
