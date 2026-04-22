package HackerRank.Java;

import java.io.*;
import java.util.*;

public class Q2_JavaStdinandStdout1C {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = br.readLine();
        int myIntegerOne = Integer.parseInt(line1);
        
        String line2 = br.readLine();
        int myIntegerTwo = Integer.parseInt(line2);
        
        String line3 = br.readLine();
        int myIntegerThree = Integer.parseInt(line3);
        
        System.out.println(myIntegerOne);
        System.out.println(myIntegerTwo);
        System.out.println(myIntegerThree);

        br.close();
    }
}
