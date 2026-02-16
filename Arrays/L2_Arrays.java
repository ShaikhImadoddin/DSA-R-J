package Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
// import java.util.HashSet;

public class L2_Arrays {
    public static ArrayList<Integer> reverseArray(final List<Integer> arr){
        ArrayList<Integer> copyArray = new ArrayList<>(arr);

        // In built collections reverse
        // Collections.reverse(copyArray);


        int i = 0;
        int j = copyArray.size() - 1;

        // Two pointer approach
        while(i < j){
            Collections.swap(copyArray,i,j);
            i++;
            j--;
        }

        // return reversed array
        return copyArray;
    }

    public static int findUniqueElement(ArrayList<Integer> nums){
        // declared unique num
        int uniqueNum = 0;

        // linear search
        for(int i=0;i<nums.size();i++){
            // xor each element to get unique number
            uniqueNum ^= nums.get(i);
        }

        // return unique element
        return uniqueNum;
    }

    public static ArrayList<Integer> sortZerosAndOnes(ArrayList<Integer> nums){
        // copy nums
        ArrayList<Integer> copyNums = new ArrayList<>(nums);

        // use collections sort in ascending order
        // Collections.sort(copyNums);

        // use collections to sort array in descending order
        // Collections.sort(copyNums, Collections.reverseOrder());

        // counting method
        int zeroCount = 0;
        for(int num: nums)
            if (num == 0) zeroCount++;
        
        // for ones count in array
        // int oneCount = nums.size() - zeroCount;
        
        // storing elements in arraylist (sorting)
        for(int i=0;i<copyNums.size();i++){
            if(i < zeroCount) 
                copyNums.set(i,0);
            else 
                copyNums.set(i,1);
        }
        // return sorted array
        return copyNums;
    }

    public static void printAllPossiblePairs(ArrayList<Integer> nums){
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                System.out.print(nums.get(i)+","+nums.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void printAllUniquePairs(ArrayList<Integer> nums){
        for(int i=0;i<nums.size();i++){
            for(int j=i;j<nums.size();j++){
                System.out.print(nums.get(i)+","+nums.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void printAllTriplets(ArrayList<Integer> nums){
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                for(int k=j+1;k<nums.size();k++){
                    System.out.print(nums.get(i) + "," + nums.get(j) + "," + nums.get(k) + "  ");
                }
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> twoSum(ArrayList<Integer> nums,int target){
        // sum == target elements index storing arraylist  
        ArrayList<Integer> pairIndex = new ArrayList<>();

        // search the pair with loop
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i) + nums.get(j) == target){
                    pairIndex.add(i);
                    pairIndex.add(j);
                }
            }
        }
        return pairIndex;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums){
        // soting nums
        Collections.sort(nums);

        // declaring 2d arraylist
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // set for unique pairs
        // HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.size();i++){
            // condition to check previous element of i
            if(i>0 && nums.get(i).equals(nums.get(i-1))){
                continue;
            }
            for(int j=i+1;j<nums.size();j++){
                // condition to check previous element of j
                if(j>i+1 && nums.get(j).equals(nums.get(j-1))){
                    continue;
                }
                for(int k=j+1;k<nums.size();k++){
                    // condition to check previous element of i
                    if(k>j+1 && nums.get(k).equals(nums.get(k-1))){
                        continue;
                    }
                    ArrayList<Integer> sums = new ArrayList<>();
                    if((nums.get(i) + nums.get(j) + nums.get(k)) == 0){
                        sums.add(nums.get(i));
                        sums.add(nums.get(j));
                        sums.add(nums.get(k));
                        matrix.add(sums);
                        // set.add(sums);
                    }
                }
            }
        }
        // 2. IMPORTANT: Pass the set into the ArrayList constructor to "fill" the matrix
        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(set);
        return matrix;
    } 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        // Reverse a ArrayList

        // ArrayList<Integer> inputList = new ArrayList<>();
        // System.out.println("Enter numbers (type a non-integer to stop):");
        // while(sc.hasNextInt()){
        //     inputList.add(sc.nextInt());
        // }

        // // Make the list unmodifiable (read-only)
        // List<Integer> constList = Collections.unmodifiableList(inputList);

        // ArrayList<Integer> reversed =  reverseArray(constList);
        // System.out.println("Original : "+ constList);
        // System.out.println("Reversed : "+ reversed);

        // Find Unique element in ArrayList

        // ArrayList<Integer> nums = new ArrayList<>(List.of(2,3,5,4,5,3,4));
        // int ans = findUniqueElement(nums);
        // System.out.println(ans);

        // Sort an Array of 0s and 1s

        // ArrayList<Integer> nums = new ArrayList<>(List.of(0,1,0,1,0,1));
        // ArrayList<Integer> ans = sortZerosAndOnes(nums);
        // System.out.println("Original: " + nums);
        // System.out.println("Sorted: "+ ans);

        // Print all Possible pairs

        // ArrayList<Integer> nums = new ArrayList<>(List.of(10,20,30,40));

        // // // Array Literals decalaration
        // // // int[] normalArray = new int[]{10,20,30,40};

        // printAllPossiblePairs(nums);

        // System.out.println();

        // Print all unique layers

        // ArrayList<Integer> nums = new ArrayList<>(List.of(10,20,30,40));
        // printAllUniquePairs(nums);

        // print all triplets

        // ArrayList<Integer> nums = new ArrayList<>(List.of(10,20,30,40));
        // printAllTriplets(nums);

        // Two sum

        // ArrayList<Integer> nums = new ArrayList<>(List.of(2,7,11,15));
        // int target = 9;
        // ArrayList<Integer> ans = twoSum(nums, target);
        // System.out.println(ans);


        // Three sum

        ArrayList<Integer> nums = new ArrayList<>(List.of(-1, 0, 1, 2, -1, -4));
        ArrayList<ArrayList<Integer>> ans = threeSum(nums);
        System.out.println(ans);

        sc.close();
    }
}
