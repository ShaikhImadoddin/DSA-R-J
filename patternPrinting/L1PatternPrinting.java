package patternPrinting;

import java.util.Scanner;

public class L1PatternPrinting {

    public static void solidSquarePattern(int row, int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    
    public static void main (String [] args){
        Scanner sc =  new Scanner(System.in);

        System.out.print("Enter number of rows: " );
        int row = sc.nextInt();

        System.out.print("Enter number of cols: ");
        int col = sc.nextInt();

        solidSquarePattern(row, col);
        
        sc.close();
    }
}
