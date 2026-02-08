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

    public static void butterFlyPattern(int row,int col){
        // upper part
        for(int i=0;i<row;i++){
            // for fp star
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }

            // for space
            for(int j=0;j<(2*(row-i-1));j++){
                System.out.print(" ");
            }

            // for sp star
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // lower part 
        for(int i=0;i<row;i++){
            // for fp star
            for(int j=0;j<row-i;j++){
                System.out.print("*");
            }

            // for space
            for(int j=0;j<(2*i);j++){
                System.out.print(" ");
            }

            // for sp star
            for(int j=0;j<row-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pascalTriangle(int row, int col){
        for(int i=1;i<=row;i++){
            int c = 1;
            for(int j=1;j<=i;j++){
                System.out.print(c);
                c = c * (i-j)/j;
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
        butterFlyPattern(row,col);
        System.out.println();
        pascalTriangle(row,col);
        System.out.println();
        sc.close();
    }
}
