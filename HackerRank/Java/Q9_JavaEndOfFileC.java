package HackerRank.Java;

import java.io.IOException;

public class Q9_JavaEndOfFileC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int lineCount = 1;
        while((line = br.readLine()) != null){
            System.out.println(lineCount++ +" "+line);
        }
    }
}
