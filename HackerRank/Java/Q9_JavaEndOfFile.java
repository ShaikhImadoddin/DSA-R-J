package HackerRank.Java;

import java.util.Scanner;

public class Q9_JavaEndOfFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineCount = 1;
        while(sc.hasNext()){
            String line = sc.nextLine();
            System.out.printf("%d %s%n",lineCount++,line);
        }
    }
}
