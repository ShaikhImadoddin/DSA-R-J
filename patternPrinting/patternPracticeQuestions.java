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

    public static void spiralMatrix(int row,int col){
        int num = 1;
        int top = 0, bottom = row - 1, left = 0, right = row - 1;
        int[][] matrix = new int[row][row];

        while(top <= bottom && left <= right){
            for (int i = left; i <= right; i++) 
                matrix[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++) 
                matrix[i][right] = num++;
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                     matrix[bottom][i] = num++;
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) 
                    matrix[i][left] = num++;
                left++;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(matrix[i][j]);
                if (j < row - 1) System.out.print(" ");
            }
            System.out.println();
        }

    }

        public static void printPattern(int N, char C) {
        int mid = N / 2;

        // Upper pyramid including middle line
        for (int i = 0; i <= mid; i++) {
            for (int j = 0; j < i; j++) 
                System.out.print(" ");
            for (int j = 0; j < N - 2*i; j++) 
                System.out.print(C);
            System.out.println();
        }

        // Lower inverted pyramid
        for (int i = mid - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) 
                System.out.print(" ");
            for (int j = 0; j < N - 2*i; j++) 
                System.out.print(C);
            System.out.println();
        }
    }

    public static void fancyPattern2(int N) {
        for (int i = 1; i <= N; i++) {
            // Print leading spaces
            for (int s = 0; s < N - i; s++) 
                System.out.print(" ");

            // Print increasing numbers
            for (int j = 1; j <= i; j++) 
                System.out.print(j);
            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) 
                System.out.print(j);
            System.out.println();
        }
    }

    public static void printHourglass(int N, char C) {
        int mid = N / 2;

        // Upper inverted pyramid
        for (int i = 0; i <= mid; i++) {
            for (int s = 0; s < i; s++) 
                System.out.print(" ");
            for (int j = 0; j < N - 2*i; j++) 
                System.out.print(C);

            System.out.println();
        }

        // Lower pyramid
        for (int i = mid-1; i >= 0; i--) {
            for (int s = 0; s < i; s++) 
                System.out.print(" ");
            for (int j = 0; j < N - 2*i; j++) 
                System.out.print(C);

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
        spiralMatrix(row,col);
        System.out.println();
        // fancy pattern 1
        printPattern(5, '$');
        System.out.println();
        fancyPattern2(row);
        // fancy pattern 3
        System.out.println();
        printHourglass(5, '@');
        sc.close();
    }
}
