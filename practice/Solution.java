/*
Problem: The Unique Server ID
Scenario:IBM ISDL manages thousands of servers. Each server has a unique integer ID. Due to a system error, some server IDs have been recorded multiple times. Your task is to read an unknown number of server IDs and find the sum of all unique IDs.
Input Format:
A single line containing an unknown number of space-separated integers.
The input ends when a non-integer character (like a letter) is encountered or the stream ends.Constraints:
Each ID can be up to $10^9$.
There can be up to $10^5$ IDs.
Time Limit: 2.0 seconds.
Example:Input: 10 20 10 30 20 40 50 stop
Unique IDs: 10, 20, 30, 40, 50
Output: 150
*/

import java.util.*;

public class Solution{
    public static long uniqueIdsSum(ArrayList<Integer> ids){
        int n = ids.size();
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;

        for(int i=0;i<n;i++){
            set.add(ids.get(i));
        }

        for(int add : set){
            sum += add;
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> ids = new ArrayList<>();

        while(sc.hasNextInt()){
            ids.add(sc.nextInt());
        }
        long sum = uniqueIdsSum(ids);
        System.out.println(sum);
        sc.close();
    }
}