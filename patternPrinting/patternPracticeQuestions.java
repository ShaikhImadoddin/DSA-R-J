package patternPrinting;

import java.util.Scanner;

public class patternPracticeQuestions {
    public static void numericHollowHalfPyramid(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<i+1;j++){
                if(j==0 || i==(row-1) || i==j)
                    System.out.print(j+1);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of row: ");
        int row = sc.nextInt();
        System.out.println("Enter the value of col: ");
        int col = sc.nextInt();
        numericHollowHalfPyramid(row,col);
        System.out.println();

        sc.close();
    }
}
