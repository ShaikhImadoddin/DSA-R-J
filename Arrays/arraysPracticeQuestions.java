package Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

public class arraysPracticeQuestions {
    
    public static int[] takeInputInArray(int [] nums,int n, Scanner sc){
        for(int i=0;i<n;i++){
            System.out.printf("Enter element at nums[%d]: ",i);
            nums[i] = sc.nextInt();
        }   
        return nums; 
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
    System.out.println("Enter size of array: ");
    int n = sc.nextInt();

    // declaring array of size n
    int[] arr = new int[n];
    
    // take input in array
    arr = takeInputInArray(arr, n,sc);

    // access kth most frequently occuring element
    System.out.println("Enter the kth element: ");
    int k = sc.nextInt();
    
    int ans = kthMostFrequent(arr, k);
    System.out.printf("%d^th occuring element is:  %d",k,ans);

    sc.close();
    }
}
