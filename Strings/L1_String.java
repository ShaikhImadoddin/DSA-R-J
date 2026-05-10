package Strings;

import java.io.IOException;
import java.util.Scanner;

public class L1_String {

    // 2
    public static char[] convertLowertoUpper(char arr[], int size){
            char[] ans = arr.clone();
            for(int i=0;i<size;i++){
                if(arr[i] >= 'a' && arr[i] <= 'z'){
                    ans[i] = (char) (arr[i] - 'a' + 'A');
                }
            }
            return ans;
    }

    public static char[] convertUppertoLower(char arr[], int size){
            char[] ans = arr.clone();
            for(int i=0;i<size;i++){
                if(arr[i] >= 'A' && arr[i] <= 'Z'){
                    ans[i] = (char) (arr[i] - 'A' + 'a');
                }   
            }
            return ans;
    }

    //3

    public static char[] reverseArray(char arr[], int size){

        int l = 0;
        int h = size - 1;

        char[] charArray = arr.clone();

        while(l <= h){
            char  temp = charArray[l];
            charArray[l] = charArray[h];
            charArray[h] = temp;
            l++;
            h--;
        }

        return charArray;
    }

    public static void main(String[] args) throws IOException{

        // 1 
        // i/p Save trees save earth -> output SaveXtreesXsaveXearth
        /* 
            Scanner sc = new Scanner(System.in);
            
            if (sc.hasNextLine()) {
                String input = sc.nextLine();
                
                String result = input.replace(" ", "X");
                System.out.println(result);
            }
        */

        // 2 lower to upper, upper to lower
        /*
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            char[] charArray = new char[n];
            for(int i=0;i<n;i++){
                charArray[i] = sc.next().charAt(0);
            }

            // System.out.println(convertLowertoUpper(charArray, n));
            System.out.println(convertUppertoLower(charArray, n));
        */
        
        // 3 Reverse an char array

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] charArray = new char[n];
        for(int i=0;i<n;i++){
            charArray[i] = sc.next().charAt(0);
        }

        System.out.println(reverseArray(charArray,n));
        
        sc.close();

    }
}
