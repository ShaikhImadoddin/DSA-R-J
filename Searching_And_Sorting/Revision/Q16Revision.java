package Searching_And_Sorting.Revision;

import java.io.BufferedReader;
import java.io.IOException;

public class Q16Revision {
    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        if(line == null) return null;

        return line.trim();
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arrayLine = br.nextDataLine(br);

        
    }
}
