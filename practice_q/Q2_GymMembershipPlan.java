package practice_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Gym Membership Plan

Description
A gym offers memberships based on specific durations. You are given an integer representing the exact number of months a customer wants to join.

The plans and costs are:

12 months: ₹15000

9 months: ₹12000

6 months: ₹7000

3 months: ₹5000

The system must check if the requested months are perfectly divisible by any of the plan durations, checking from largest (12) to smallest (3). If it is perfectly divisible, calculate the multiple, multiply it by the cost of that plan, and print the total. If it is not perfectly divisible by any of the plan durations, print "Error".

Example 1:
Input: 18
Output: 24000
Explanation: 18 % 12 != 0 (Skip)
18 % 9 == 0 (Match!). The multiple is 18 / 9 = 2. Cost is 2 * 12000 = 24000.

Example 2:
Input: 7
Output: Error
Explanation: 7 is not divisible by 12, 9, 6, or 3.

*/



public class Q2_GymMembershipPlan {

    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while(line !=  null && line.trim().isEmpty()){
            line = br.readLine();
        } 

        if(line == null) return null;

        return line.trim();
    }

    public static int checkGymMembershipCost(int n){
        if(n%12 == 0){
            return (n/12) * 15000;
        } 
        else if(n%9 == 0){
            return (n/9) * 12000;
        }
        else if(n%6 == 0){
            return (n/6) * 7000;
        }
        else if(n%3 == 0){
            return (n/3) * 5000;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String monthLine = nextDataLine(br);
        if(monthLine == null) return;
        int n = Integer.parseInt(monthLine.trim());

        int ans = checkGymMembershipCost(n);

        if(ans == -1){
            System.out.println("Error");
        }
        else{
            System.out.println(ans);
        }
    }
}
