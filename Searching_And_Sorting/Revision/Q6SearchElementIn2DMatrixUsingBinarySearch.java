package Searching_And_Sorting.Revision;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Search an Element in a 2D Matrix

        /*
        You are provided with an m x n matrix, where each row and each column are sorted in ascending order. Your task is to find out whether a given target number exists in this matrix. The matrix is structured in such a way that facilitates efficient searching due to its sorted properties. Your goal is to implement the function bool searchMatrix(vector<vector<int>>& matrix, int target) that returns true if the target is present in the matrix, and false otherwise.

        Example 1:
        Input: matrix = [[1, 3, 5], [7, 9, 11], [13, 15, 17]], target = 9

        Output: true

        Example 2:

        Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], target = 10

        Output: false
        
        Constraints

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 300
        -109 <= matrix[i][j] <= 109
        All the integers in each row are sorted in ascending order.
        All the integers in each column are sorted in ascending order.
        -109 <= target <= 109
        */

public class Q6SearchElementIn2DMatrixUsingBinarySearch{
    // helper function for ignoring empty lines
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        if(line != null && line.trim().isEmpty()){
            line = br.readLine();
        }

        return line;
    }

    public static boolean searchElementIn2DMatrixUsingBinarySearch(int[][] matrix,int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int totalElements = rows * cols;

        int s = 0;
        int e = totalElements - 1;

        int mid = 0;

        while(s <= e){
            mid = s + (e-s)/2;

            int rowIndex = mid/cols;
            int colIndex = mid%cols;

            if(matrix[rowIndex][colIndex] == target){
                return true;
            }
            else if(matrix[rowIndex][colIndex] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* 
        3 3          // Number of rows (m) and columns (n)
        1 3 5        // Row 0
        7 9 11       // Row 1
        13 15 17     // Row 2
        9            // Target element
        */
        String sizeLine = nextDataLine(br);
        if (sizeLine == null) return;

        StringTokenizer st = new StringTokenizer(sizeLine);
        int m = Integer.parseInt(st.nextToken().trim());
        int n = Integer.parseInt(st.nextToken().trim());

        // Initialize the 2D array
        int[][] matrix = new int[m][n];

        // Loop 'm' times to read each row
        for(int i=0;i<m;i++){
            String rowLine = nextDataLine(br);
            st = new StringTokenizer(rowLine);
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken().trim());
            }
        }

        // Read the target element
        String targetLine = nextDataLine(br);
        int target = Integer.parseInt(targetLine.trim());

        System.out.println(searchElementIn2DMatrixUsingBinarySearch(matrix,target));

        br.close();
    }
}