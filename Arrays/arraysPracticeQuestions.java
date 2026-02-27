package Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
// import java.util.List;
import java.util.ArrayList;

public class arraysPracticeQuestions {
    
    public static int[] takeInputInArray(int [] nums,int n, Scanner sc){
        for(int i=0;i<n;i++){
            System.out.printf("Enter element at nums[%d]: ",i);
            nums[i] = sc.nextInt();
        }   
        return nums; 
    }

    public static ArrayList<ArrayList<Integer>> takeInputIn2dArray(Scanner sc) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            // Create a new inner list for each row
            ArrayList<Integer> row = new ArrayList<>();
            System.out.printf("Enter %d elements for row %d: ", cols, i);
            for (int j = 0; j < cols; j++) {
                row.add(sc.nextInt());
            }
            // Add the completed row to our 2D list
            matrix.add(row);
        }
        return matrix;
    }

    public static int missingNumber(int[] nums) {
        int xor = nums.length;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i] ^ i;
        }

        return xor;
    }

    public static int removeDuplicates(int[] nums) {

        // Array size
        int n = nums.length;

        // Edge cases
        if (n==0) return 0;
        if (n==1) return 1;


        int j = 0; // The 'slow' pointer
        int i = j+1; // The 'fast' pointer (j + 1)

        while(i < n){
            if(nums[i] == nums[j]){
                i++;
            }
            else{
                // Move slow pointer and update with new unique value
                nums[++j] = nums[i++];
            }
        }
        // j is the index, so length is j + 1
        return j+1;
    }

    public static int kthMostFrequent(int [] arr, int k) {
        // array size
        int n = arr.length;

        // step 1:  counting frequencies of each using hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        // step 2: declaring priorityQueue for maintaining order as below

        // Logic: If frequencies are different, higher frequency wins.
        // If frequencies are same, smaller number wins.

        // syntax of priorityqueue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA != freqB) 
                return freqB - freqA;

            return a - b;
        });

        // step 3: accessing kth element 

        // Check if k is valid first (Avoid IndexOutOfBounds equivalent)
        if (k > map.size()) {
            return -1;
        }

        // Add all unique elements to the PriorityQueue
        pq.addAll(map.keySet());

        // Remove the first k-1 elements
        for (int i = 0; i < k - 1; i++) {
            pq.poll(); 
        }

        // The head of the queue is now your kth most frequent element
        return pq.poll();
    }

    public static ArrayList<Integer> rowSum(ArrayList<ArrayList<Integer>> matrix){
        int row = matrix.size();
        
        ArrayList<Integer> rowSumArray = new ArrayList<>();
        // outer loop for row
        for(int i=0;i<row;i++){
            int sum = 0;
            int col =  matrix.get(i).size();
            // inner loop for col
            for(int j=0;j<col;j++){
                sum += matrix.get(i).get(j);
            }
            rowSumArray.add(sum);
        }

        // return array
        return rowSumArray;
    }

    public static ArrayList<Integer> colSum(ArrayList<ArrayList<Integer>> matrix){
        int rows = matrix.size();
        int cols = matrix.get(0).size(); // Assuming all rows are same length
        ArrayList<Integer> colSumList = new ArrayList<>();

        // Outer loop moves through COLUMNS
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            // Inner loop moves through ROWS
            for (int i = 0; i < rows; i++) {
                sum += matrix.get(i).get(j);
            }
            colSumList.add(sum);
        }

        return colSumList;
    }

    public static ArrayList<Integer> wavePrintMatrix(ArrayList<ArrayList<Integer>> matrix){

        // Check if the entire matrix is null or has 0 rows
        if (matrix == null || matrix.isEmpty()) {
            return new ArrayList<>(); 
        }
        
        int row = matrix.size();
        int col = matrix.get(0).size();

        ArrayList<Integer> wavePrintArray = new ArrayList<>();
        // outer loop for col
        for(int j=0;j<col;j++){
            // inner loop for row
            for(int i=0;i<row;i++){
                if((j%2) == 0){
                    wavePrintArray.add(matrix.get(i).get(j));
                }
                else{
                    wavePrintArray.add(matrix.get(row-i-1).get(j));
                }
            }
        }
        return wavePrintArray;
    }

    public static ArrayList<Integer> spiralPrintMatrix(ArrayList<ArrayList<Integer>> matrix){
        // Check if the entire matrix is null or has 0 rows
        if (matrix == null || matrix.isEmpty()) {
            return new ArrayList<>(); 
        }

        ArrayList<Integer> result = new ArrayList<>();

        int top = 0, bottom = matrix.size() - 1;
        int left = 0, right = matrix.get(0).size() - 1;

        while (top <= bottom && left <= right) {

            // top row
            for(int i=left;i<=right;i++){
                result.add(matrix.get(top).get(i));
            }
            top++;

            // right row
            for (int i = top; i <= bottom; ++i) {
                result.add(matrix.get(i).get(right));
            }
            right--;

            // bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    result.add(matrix.get(bottom).get(i));
                }
                --bottom;
            }

            // left row
            if (left <= right) {
                for (int i = bottom; i >= top; --i){
                    result.add(matrix.get(i).get(left));
                } 
                ++left;
            }
        }
        return result;
        
    }

    public static int pivotIndex(int [] nums){
        // Array size
        int n = nums.length;

        // Declaring two arrays in java intialized with zero by default
        int rightSumArr[] = new int[n];
        int leftSumArr[] = new int[n];

        // declaring two variables to store sum

        int leftSum = 0;
        int rightSum = 0;

        // left sum calculation
        for(int i=1;i<n;i++){
            leftSum += nums[i-1];
            leftSumArr[i] += leftSum;
        }


        // right sum calculation
        for(int i=n-2;i>=0;i--){
            rightSum += nums[i+1];
            rightSumArr[i] += rightSum;
        }

        // check index which is having common value
        for(int i=0;i<n;i++){
            if(leftSumArr[i] == rightSumArr[i])
                return i;
        }

        return -1;
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // Missing Number

        // System.out.println("Enter size of array: ");
        // int n = sc.nextInt();

        // // declaring array of n size;
        // int[] nums = new int[n];

        // // take input in array of size n;
        // nums = takeInputInArray(nums, n);
        
        // int ans = missingNumber(nums);
        // System.out.println(ans);

        // Remove Duplicates from Sorted Array

        // System.out.println("Enter size of array: ");
        // int n = sc.nextInt();

        // // declaring array of size n
        // int[] nums = new int[n];

        // // take input in array of size n;
        // nums = takeInputInArray(nums, n);

        // int ans = removeDuplicates(nums);
        // System.out.println(ans);

        // Find the kth Most Frequent Element

        /*
You need to find the kth most frequently occurring element in a given array of integers. The frequency of an element is defined by the number of times it appears in the array. If multiple elements have the same frequency, the element with the smaller numerical value is considered more frequent.

In case there are fewer than k unique elements in the array, return -1.

Example
Example 1:
Input: array = [1, 1, 1, 2, 2, 3, 4], k = 2
Output: 2
The frequencies are:

1 occurs 3 times
2 occurs 2 times
3 and 4 occur 1 time each
The 2nd most frequent element is 2.

Example 2:
Input: array = [4, 4, 1, 1, 2, 3], k = 3
Output: 2
The frequencies are:

4 and 1 both occur 2 times each
2 and 3 occur 1 time each
Resolving a tie by order, the 3rd most frequent element is 2.

Example 3:
Input: array = [5, 6, 5, 7], k = 10
Output: -1
There are only 3 unique elements, so the 10th most frequent element doesn't exist.
*/
    // System.out.println("Enter size of array: ");
    // int n = sc.nextInt();

    // // declaring array of size n
    // int[] arr = new int[n];
    
    // // take input in array
    // arr = takeInputInArray(arr, n,sc);

    // // access kth most frequently occuring element
    // System.out.println("Enter the kth element: ");
    // int k = sc.nextInt();
    
    // int ans = kthMostFrequent(arr, k);
    // System.out.printf("%d^th occuring element is:  %d",k,ans);
    
    // Print the Sum of Each Row in a 2D Array

    // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    // matrix = takeInputIn2dArray(sc);
    // System.out.println(rowSum(matrix));

    // Print the Sum of Each Col in a 2D Array

    // System.out.println(colSum(matrix));
    
    // Wave print A Matrix
    // Spiral print A matrix

    // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    // matrix = takeInputIn2dArray(sc);
    // ArrayList<Integer> ans = wavePrintMatrix(matrix);
    // ArrayList<Integer> ans2 = spiralPrintMatrix(matrix);
    // System.out.println(ans);
    // System.out.println(ans2);

    // Find Pivot Index  leetcode 724

    System.out.println("Enter the size of Array: ");
    int n = sc.nextInt();

    int [] nums = new int [n];
    nums = takeInputInArray(nums, n, sc);
    int ans = pivotIndex(nums);
    System.out.printf("Pivot index is %d",ans);

    sc.close();
    }
}
