import java.util.*;

public class IDCount {
    public static int maxIdCount(ArrayList<Integer> nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        // counting in hashmap
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int maxId = -1;
        int maxFrequency = -1;
        // accessing value from hashmap
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxFrequency){
                maxFrequency = entry.getValue();
                maxId = entry.getKey();
            } // if count same and want smaller id
            else if(entry.getValue() == maxFrequency){
                if(entry.getKey() < maxId){
                    maxId = entry.getKey();
                }
            }
        }

        return maxId;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter non integer value to stop");
        int i = 0;

        ArrayList<Integer> nums = new ArrayList<>();

        System.out.printf("Enter element at nums[%d]: ", i);

        while(sc.hasNextInt()){
            
            nums.add(sc.nextInt());
            i++;

            System.out.printf("Enter element at nums[%d]",i);
        }

        int ans = maxIdCount(nums);
        System.out.println(ans);
        sc.close();
    }
}
