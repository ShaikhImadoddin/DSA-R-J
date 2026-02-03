package patternPrinting;
import java.util.Scanner;

public class L2PatternPrinting {

    public static void hollowPyramidPattern(int row, int col){
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<row-i;j++){
                System.out.print(" ");
            }

            // for stars
            for(int j=0;j<(2*i)+1;j++){
                if(j==0 || i == row-1 || j == (2*i)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void solidDiamondPattern(int row, int col){
        // upper part 
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<row-i-1;j++){
                System.out.print(" ");
            }

            //for stars
            for(int j=0;j<(2*i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // lower part
        for(int i=0;i<row-1;i++){
            // for spaces
            for(int j=0;j<=i;j++){
                System.out.print(" ");
            }
            // for stars
            for(int j=0;j<(2*((row-1)-i)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowDiamondPattern(int row,int col){
        // upper part 
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<row-i-1;j++){
                System.out.print(" ");
            }

            //for stars
            for(int j=0;j<(2*i)+1;j++){
                if(j==0 || j==2*i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // lower part
        for(int i=0;i<row-1;i++){
            // for spaces
            for(int j=0;j<=i;j++){
                System.out.print(" ");
            }
            // for stars
            for(int j=0;j<(2*((row-1)-i)-1);j++){
                if(j==0 || j == ((2*((row-1)-i)-1) - 1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        System.out.print("Enter number of rows: " );
        int row = sc.nextInt();

        System.out.print("Enter number of cols: ");
        int col = sc.nextInt();

        hollowPyramidPattern(row, col);
        System.out.println();
        solidDiamondPattern(row, col);
        System.out.println();
        hollowDiamondPattern(row, col);
        System.out.println();
        sc.close();
    }
}
