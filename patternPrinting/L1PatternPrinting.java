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

    public static void rightAngleTriangle(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollowSquarePattern(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==(row-1) || j==0 || j==(col-1) ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void hollowRightAngleTriangle(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==(row-1) || i==j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void invertedRightAngleTriangle(int row, int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<row-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solidPyramidPattern(int row, int col){
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<row-i-1;j++){
                System.out.print(" ");
            }
            // for stars
            for(int j=0;j<(2*i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void invertedSolidPyramidPattern(int row, int col){
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            // for stars
            for(int j=0;j<(2*(row-i)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void numberTrianglePattern(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }

    public static void floydsTrianglePattern(int row,int col){
        int num = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                System.out.print(num++ + " ");
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
        System.out.println();
        rightAngleTriangle(row, col);
        System.out.println();
        hollowSquarePattern(row, col);
        System.out.println();
        hollowRightAngleTriangle(row, col);
        System.out.println();
        invertedRightAngleTriangle(row, col);
        System.out.println();
        solidPyramidPattern(row,col);
        System.out.println();
        invertedSolidPyramidPattern(row, col);
        System.out.println();
        numberTrianglePattern(row, col);
        System.out.println();
        floydsTrianglePattern(row, col);
        System.out.println();
        sc.close();
    }
}
