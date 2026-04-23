package HackerRank.Java;

import java.io.*;
import java.util.*;

public class Q8_JavaDatatypes {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T > 0){
            try{
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in: ");
                
                if(x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                
                if(x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                
                if(x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
            
                System.out.println("* long");
            }
            catch(Exception e){
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
            T--;
        }
    }
}
