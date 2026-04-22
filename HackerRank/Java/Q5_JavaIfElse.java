package HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Task
Given an integer,n, perform the following conditional actions:

If  is odd, print Weird
If  is even and in the inclusive range of 2 to 5, print Not Weird
If  is even and in the inclusive range of 6 to 20, print Weird
If  is even and greater than 20, print Not Weird

Complete the stub code provided in your editor to print whether or not n is weird.

Input Format

A single line containing a positive integer, .

Constraints
1 <= n <= 100

Output Format
Print Weird if the number is weird; otherwise, print Not Weird.

*/
public class Q5_JavaIfElse {
    public static void checkConditionalActions(int n){
        if((n%2==0) && n>=2 && n<=5){
            System.out.print("Not Weird");
        }
        else if((n%2==0) && n>=6 && n<=20){
            System.out.print("Weird");
        }
        else if((n%2==0) && n>20){
            System.out.print("Not Weird");
        }
        else{
            System.out.print("Weird");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        checkConditionalActions(N);
        bufferedReader.close(); 
    }
}
