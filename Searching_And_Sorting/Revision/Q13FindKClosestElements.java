package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Q13FindKClosestElements{

    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }
        return line;
    }

    public static List<Integer> findClosestElementsTwoPointer(int [] arr,int k,int x){
        int n = arr.length;
        int l = 0;
        int h = n-1;

        while((h-l) >= k){
            if(Math.abs(x-arr[l]) > Math.abs(x-arr[h])){
                l++;
            }else{
                h--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=l;i<=h;i++){
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        // Array Line
        String arrayLine = nextDataLine(br);
        StringTokenizer st = new StringTokenizer(arrayLine,",");
        int n = st.countTokens();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken().trim());
        }

        // closest number of Integers
        String closestIntegers = nextDataLine(br);
        int k = Integer.parseInt(closestIntegers.trim());

        // target
        String target = nextDataLine(br);
        int x = Integer.parseInt(target.trim());

        List<Integer> ans = findClosestElementsTwoPointer(arr, k, x);
        
        System.out.println(ans);
    }
}