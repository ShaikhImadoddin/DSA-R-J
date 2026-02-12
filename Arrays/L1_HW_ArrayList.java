package Arrays;

import java.util.ArrayList;
// import java.util.List;

public class L1_HW_ArrayList {
    public static void main(String[] args) {
        
        // 1. Declaration (Vector<int> v; equivalent)
        ArrayList<Integer> list = new ArrayList<>();

        // 1 a
        // Creates an immutable list

        // List<Integer> temp = List.of(10, 20, 30, 40, 50);
        

        // If you want a modifiable ArrayList (to add/remove elements like a C++ vector)

        // ArrayList<Integer> list2 = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        // 2. Adding Elements (v.push_back(10); equivalent)
        list.add(10);
        list.add(20);
        list.add(30);

        // 3. Removing Elements (v.pop_back(); equivalent)
        list.remove(list.size() - 1);

        // 4. Accessing Elements (v[i]; equivalent)
        int element = list.get(0); 
        System.out.println("Element is: "+element);
        // 5. Updating Elements (v[i] = 50; equivalent)
        list.set(0, 50);

        // 6. Size (v.size(); equivalent)
        System.out.println("Size is: " + list.size());

        // 7. Checking if empty (v.empty(); equivalent)
        System.out.println("Is empty? " + list.isEmpty());
    }
}
