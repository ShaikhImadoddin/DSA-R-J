import java.util.*;

public class findkthSmallest {
    
    public static int findTheKthSmallest(int[] arr,int k){
        PriorityQueue<Integer> Que = new PriorityQueue<>();

        for (int a:arr){
            Que.add(a);
        }

        for(int i=0;i<k-1;i++){
            Que.poll();
        }

        return Que.poll();
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        // 1. Read the size
        if(!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();

        // 2. Read the elements into an array
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 3. kth element 
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println(findTheKthSmallest(arr,k));
        sc.close();
    }
}




