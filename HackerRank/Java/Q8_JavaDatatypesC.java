package HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8_JavaDatatypesC {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String numberOfTestCases = br.readLine();
        int T = Integer.parseInt(numberOfTestCases);
        
        while(T > 0){
            String testCase = br.readLine();
            try{
                Long x = Long.parseLong(testCase);
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
                System.out.println( testCase + " can't be fitted anywhere.");
            }
            T--;
        }
    }
}
