package patternPrinting;

import java.util.Scanner;

public class MsPatternPrinting {

    public static void numericPyramidPattern(int row,int col){
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<row-i-1;j++){
                System.out.print(" ");
            }
            // for nums
           for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    public static void symmetricNumberPyramid(int row,int col){
        int revnum = 0;
        for(int i=0;i<row;i++){
            // for num
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            // for spaces
            for(int j=0;j<((row-i-1)*2);j++){
                System.out.print(" ");
            }
            // for revnum
            revnum = i+1;
            for(int j=0;j<=i;j++){
                System.out.print(revnum--);
            }
            System.out.println();
        }   
    }

    public static void invertedAlphabetTrianglePattern(int row, int col){
        
        for(int i=0;i<row;i++){
            char ch = 'A';
            for(int j=0;j<row-i;j++){
                System.out.print(ch++);
            }
            System.out.println();
        }
    }

    public static void printAlphabetTriangle(int row,int col){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tha value for row: ");
        int row = sc.nextInt();

        System.out.println("Enter the value for col: ");
        int col =  sc.nextInt();

        numericPyramidPattern(row,col);
        System.out.println();
        symmetricNumberPyramid(row,col);
        System.out.println();
        invertedAlphabetTrianglePattern(row,col);
        System.out.println();
        printAlphabetTriangle(row,col);
        System.out.println();

        sc.close();
    }
}
