package HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_JavaLoops1 {
    public static void printTable(int n){
        for(int i=1;i<=10;i++){
            int mul = n*i;
            System.out.printf("%d x %d = %d%n",n,i,mul);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        printTable(N);
        bufferedReader.close();
    }
}
