package HackerRank.Java;

import java.io.*;
import java.util.*;

public class Q2_JavaStdinandStdout1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int integerOne = sc.nextInt();
        int integerTwo = sc.nextInt();
        int integerThree = sc.nextInt();
        
        sc.close();
        
        System.out.println(integerOne);
        System.out.println(integerTwo);
        System.out.println(integerThree);
    }
}