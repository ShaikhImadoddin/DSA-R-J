package Arrays;

import java.util.ArrayList;
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

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        // Leetcode 1572. Matrix Diagonal Sum

        System.out.print("Enter the size of the square matrix (n): ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // Taking input

        for(int i=0;i<n;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                System.out.printf("Enter element [%d][%d]: ", i, j);
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        int ans = diagonalSum(matrix);
        System.out.println("Answer is "+ans);

        sc.close();
    }
}
