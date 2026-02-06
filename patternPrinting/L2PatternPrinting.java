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
    
    public static void rhombusPattern(int row, int col){
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<(row-i-1);j++){
                System.out.print(" ");
            }

            // for stars
            for(int j=0;j<row;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hourGlassPattern(int row,int col){
        // upper part
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            // for stars
            for(int j=0;j<2*(row-i);j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // lower part
        for(int i=0;i<row;i++){
            // for spaces
            for(int j=0;j<(row-i-1);j++){
                System.out.print(" ");
            }

            // for stars
            for(int j=0;j<2*(i + 1) ;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void zigZagPattern(int row, int col) {
    // Upper part (Inverted V shape)
    // 'row' acts as 'n' (the distance from the edge to the center)
    for (int i = 0; i <= row; i++) {
        // 1. Leading spaces
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }

        // 2. Stars at boundaries
        int width = 2 * (row - i) + 1;
        for (int j = 0; j < width; j++) {
            if (j == 0 || j == width - 1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Lower part (V shape)
    for (int i = 1; i <= row; i++) {
        // 1. Leading spaces (decreasing)
        for (int j = 0; j < row - i; j++) {
            System.out.print(" ");
        }

        // 2. Stars at boundaries (expanding)
        int width = 2 * i + 1;
        for (int j = 0; j < width; j++) {
            if (j == 0 || j == width - 1) {
                System.out.print("*");
            } else {
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
        rhombusPattern(row, col);
        System.out.println();
        hourGlassPattern(row,col);
        System.out.println();
        zigZagPattern(row,col);
        sc.close();
    }
}
