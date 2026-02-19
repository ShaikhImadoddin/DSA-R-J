package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L4_Arrays {
    public static int diagonalSum(ArrayList<ArrayList<Integer>> matrix){
        int sum = 0;
        int n = matrix.size();

        // diagonal one sum
        for(int i=0;i<n;i++){
            sum += matrix.get(i).get(i);
        }

        // diagonal two sum
        for(int i=0;i<n;i++){
            if(i == n-i-1)
                continue;

            sum += matrix.get(i).get(n-i-1);
        }

        return sum;
    }

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> matrix){
        // Create new Array
        ArrayList<ArrayList<Integer>> transposeArray = new ArrayList<>();

        int rows = matrix.size();
        int cols = matrix.get(0).size();


        for(int j=0;j<cols;j++){
            ArrayList<Integer> rowArr = new ArrayList<>();
            for(int i=0;i<rows;i++){
                rowArr.add(matrix.get(i).get(j));
            }
            transposeArray.add(rowArr);
        }

        return transposeArray;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int sr=0, sc = 0;
        int er = rows - 1;
        int ec = cols - 1;

        while (sr <= er && sc <= ec) {

            // line a
            for(int i=sc;i<=ec;i++){
                spiralList.add(matrix[sr][i]);
            }
            sr++;

            // line b
            for(int i=sr;i<=er;i++){
                spiralList.add(matrix[i][ec]);
            }
            ec--;

            // line c
            if (sr <= er) {
                for(int i=ec;i>=sc;i--){
                    spiralList.add(matrix[er][i]);
                }
                er--;
            }

            // line d
            if(sc <= ec){
                for(int i=er;i>=sr;i--){
                    spiralList.add(matrix[i][sc]);
                }
                sc++;
            }
        }
        return spiralList;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        // Leetcode 1572. Matrix Diagonal Sum

        // System.out.print("Enter the size of the square matrix (n): ");
        // int n = sc.nextInt();

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // // Taking input

        // for(int i=0;i<n;i++){
        //     ArrayList<Integer> row = new ArrayList<>();
        //     for(int j=0;j<n;j++){
        //         System.out.printf("Enter element [%d][%d]: ", i, j);
        //         row.add(sc.nextInt());
        //     }
        //     matrix.add(row);
        // }

        // int ans = diagonalSum(matrix);
        // System.out.println("Answer is "+ans);

        // 867. Transpose Matrix Leetcode

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // System.out.println("Enter number of rows: ");
        // int rows = sc.nextInt();
        // System.out.println("Enter number of columns: ");
        // int cols = sc.nextInt();

        // // taking input
        // for(int i=0;i<rows;i++){
        //     ArrayList<Integer> rowArr = new ArrayList<>();
        //     for(int j=0;j<cols;j++){
        //         System.out.printf("Enter element [%d][%d]: ", i, j);
        //         rowArr.add(sc.nextInt());
        //     }
        //     matrix.add(rowArr);
        // }

        // ArrayList<ArrayList<Integer>> ans = transpose(matrix);
        // System.out.println("Original: "+matrix);
        // System.out.println("Transpose: "+ans);

        // 54. Spiral Matrix

        System.out.println("Enter the value of row: ");
        int row = sc.nextInt();

        System.out.println("Enter the value of col: ");
        int col = sc.nextInt();

        // declaring matrix
        int [][] matrix = new int[row][col];

        // taking input in matrix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // copy paste this input will work faster
        // 3 rows 4 cols
        // 1 2 3 4 5 6 7 8 9 10 11 12

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
        
        sc.close();
    }
}
