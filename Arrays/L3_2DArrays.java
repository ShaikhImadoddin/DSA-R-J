package Arrays;
import java.util.*;

public class L3_2DArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1. 2D ARRAY SECTION ---
        System.out.println("--- 2D Array (3x2) ---");
        int[][] matrix = new int[3][2];

        // Input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value for row " + i + " col " + j + ": ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Traversal & Print
        System.out.println("\nPrinting 2D Array:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // --- 2. 2D ARRAYLIST SECTION ---
        System.out.println("\n--- 2D ArrayList ---");
        ArrayList<ArrayList<Integer>> dynamicTable = new ArrayList<>();

        // Input: Adding 2 rows with different number of columns
        for (int i = 0; i < 2; i++) {
            dynamicTable.add(new ArrayList<>()); // Create the inner list (row)
            System.out.print("How many elements for row " + i + "? ");
            int cols = sc.nextInt();
            
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                dynamicTable.get(i).add(val); // Access row, then add element
            }
        }

        // Traversal & Print
        System.out.println("\nPrinting 2D ArrayList:");
        for (ArrayList<Integer> row : dynamicTable) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}