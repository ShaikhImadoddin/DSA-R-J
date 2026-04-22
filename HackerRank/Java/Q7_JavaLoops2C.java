package HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_JavaLoops2C {
    public static void createSeries(int a,int b,int n){
        int currentNumber = a;
        for(int i=0;i<n;i++){
            int nextNumber = (int)Math.pow(2,i)*b;
            currentNumber += nextNumber;
            System.out.printf("%d ",currentNumber);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(br.readLine().trim());
        
        // sc.nextLine();
        while(q > 0){
            String[] query = br.readLine().trim().split(" ");
            
            int a = Integer.parseInt(query[0].trim());
            int b = Integer.parseInt(query[1].trim());
            int n = Integer.parseInt(query[2].trim());
            
            createSeries(a,b,n);
            q--;
        }
    }
}
