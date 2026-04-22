package HackerRank.Java;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true

public class Q7_JavaLoops2 {

    public static void createSeries(int a,int b,int n){
        int currentNumber = a;
        for(int i=0;i<n;i++){
            int nextNumber = (int)Math.pow(2,i)*b;
            currentNumber += nextNumber;
            System.out.printf("%d ",currentNumber);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        
        while(q > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            createSeries(a,b,n);
            q--;
        }
    }
}
