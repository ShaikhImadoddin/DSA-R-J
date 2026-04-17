package practice_q;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Problem Statement: Fraudulent Bank Transactions

You are given an array of strings transactions of size N. Each string represents a single bank transaction formatted as "Sender Receiver Amount Timestamp", where the values are separated by a single space.

A transaction is considered fraudulent if there exists at least one other transaction in the array such that both of the following conditions are met:

1.The Sender, Receiver, and Amount are exactly the same.
2.The absolute difference between their Timestamp values is <= 60 seconds.

Return a list of all fraudulent transactions. You may return the answer in any order. If a transaction is flagged as fraudulent because it matches multiple other transactions, it should only appear in the output list once.

Example 1 
Input: 
5
javatransactions = ["ANU JON 200.50 1000",
                    "ANU JON 200.50 1050",
                    "RAM SAM 300.00 2000",
                    "ANU JON 200.50 2000",
                    "RAM SAM 300.00 2050"]

**Output:** ```java
[
  "ANU JON 200.50 1000", 
  "ANU JON 200.50 1050", 
  "RAM SAM 300.00 2000", 
  "RAM SAM 300.00 2050"
]
Explanation: * Transaction 0 and Transaction 1 have identical details ("ANU JON 200.50") and their timestamp difference is 50 seconds ($1050 - 1000 \le 60$). Both are fraud.
Transaction 2 and Transaction 4 have identical details ("RAM SAM 300.00") and their timestamp difference is 50 seconds ($2050 - 2000 \le 60$). Both are fraud.
Transaction 3 has identical details to 0 and 1, but its timestamp (2000) is 950 seconds away from the closest match (1050). It is not fraud.

 */

public class Q1_DetectingFraudulentBankTransactions{

    // helper function
    public static String nextDataLine(BufferedReader br) throws IOException{
        String line = br.readLine();

        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
    
        if (line == null)
            return null;
    
        return line.trim();
    }
    
    // basic solution
    public static List<String> getFraudTransactions(String[] transactions) {
        int n = transactions.length;
    
        String[] senders = new String[n];
        String[] receivers = new String[n];
        String[] amounts = new String[n];
        int[] times = new int[n];
        
        // This array keeps track of which transactions are fraud
        boolean[] isFraud = new boolean[n]; 
        
        for (int i = 0; i < n; i++) {
            String[] details = transactions[i].split(" ");
            senders[i] = details[0];
            receivers[i] = details[1];
            amounts[i] = details[2];
            times[i] = Integer.parseInt(details[3]); 
        }
        
    
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {           
                if (senders[i].equals(senders[j]) && 
                    receivers[i].equals(receivers[j]) && 
                    amounts[i].equals(amounts[j])) { 
                    if (Math.abs(times[i] - times[j]) <= 60) {
                
                        isFraud[i] = true;
                        isFraud[j] = true;
                    }
                }
            }
        }
        
        List<String> fraudList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isFraud[i]) {
                fraudList.add(transactions[i]);
            }
        }
        return fraudList;
    }

    // hashmap solution
    public static List<String> getFraudTransactionsUsingHashMap(String[] transactions) {
        int n = transactions.length;
        boolean[] isFraud = new boolean[n];
        int[] times = new int[n];

        // HashMap to group identical transactions instantly
        // Key: "Sender Receiver Amount"
        // Value: List of original array indices
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] details = transactions[i].split(" ");
            
            // Create the unique grouping key
            String key = details[0] + " " + details[1] + " " + details[2];
            times[i] = Integer.parseInt(details[3]);

            // Add the index to the correct group in the map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }

        // Process each group of identical transactions
        for (List<Integer> indices : map.values()) {
            // If a transaction has no identical twins, skip it
            if (indices.size() < 2) continue;

            // Sort the indices for this specific group based on their timestamps
            indices.sort((a, b) -> Integer.compare(times[a], times[b]));

            // Because the times are sorted, we only need to check adjacent pairs
            for (int i = 1; i < indices.size(); i++) {
                int currIndex = indices.get(i);
                int prevIndex = indices.get(i - 1);

                if (times[currIndex] - times[prevIndex] <= 60) {
                    isFraud[currIndex] = true;
                    isFraud[prevIndex] = true;
                }
            }
        }

        // Collect results using the boolean checklist to maintain original order
        List<String> fraudList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isFraud[i]) {
                fraudList.add(transactions[i]);
            }
        }
        
        return fraudList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sizeLine = nextDataLine(br);
        if(sizeLine == null) return;

        int n = Integer.parseInt(sizeLine.trim());

        String[] transactions = new String[n];

        for(int i=0;i<n;i++){
            String transactionLine = nextDataLine(br);
            if (transactionLine == null) return;
            transactions[i] = transactionLine;
        }

        /*
            String[] transactions = {
                "ANU JON 200.50 1000",
                "ANU JON 200.50 1050",
                "RAM SAM 300.00 2000",
                "ANU JON 200.50 2000",
                "RAM SAM 300.00 2050"
            };
        */
            
            
            // List<String> result = getFraudTransactions(transactions);

            List<String> result = getFraudTransactionsUsingHashMap(transactions);
            
            System.out.println("Fraudulent Transactions:");
            for (String t : result) {
                System.out.println(t);
            }
        }
}