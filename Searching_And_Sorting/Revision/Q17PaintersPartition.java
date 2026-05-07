package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17PaintersPartition {

    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        if(line == null) return null;

        return line.trim();
    }

    public static boolean isPossible(int[] arr, int k, int mid){
        int n = arr.length;
        int timeSum = 0;
        int c = 1;

        for(int i=0;i<n;i++){
            if(arr[i] > mid){
                return false;
            }

            if(arr[i] + timeSum <= mid){
                timeSum += arr[i];
            }
            else{
                c++;
                timeSum = arr[i];
                if(c > k) return false;
            }
        }
        return true;
    }

    public static int minTime(int[] arr,int k){
        int n = arr.length;
        
        int s = 0;
        int e = 0;

        for(int i=0;i<n;i++){
            e += arr[i];
        }

        int mid = 0;
        int ans = -1;

        while(s <= e){
            mid = s + (e-s)/2;

            if(isPossible(arr,k,mid)){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }

        return ans; 
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ArrayInput
        String arrayLine = nextDataLine(br);
        if(arrayLine == null) return;
        try{
            StringTokenizer st = new StringTokenizer(arrayLine);
            int n = st.countTokens();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                try{
                    arr[i] = Integer.parseInt(st.nextToken().trim());
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Input");
                }
            }

            // Integer K input
            String kLine = nextDataLine(br);
            
            if(kLine == null) return;
            try{
                int k = Integer.parseInt(kLine);
                int ans = minTime(arr,k);
                System.out.println("Answer is: "+ ans);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input");
            }

        }
        catch(NumberFormatException e){
            System.out.println("Invalid Input");
        }

        

        

    }
}
