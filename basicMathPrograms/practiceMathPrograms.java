package basicMathPrograms;
import java.util.Scanner;
import java.util.ArrayList;


public class practiceMathPrograms {

    public static double convertKmToMiles(int Km) {
        double miles = 0.621371;
        return Km*miles;
    }

    public static int areaOfCircle(int radius) {
       return (int)(3.14 * Math.pow(radius,2));
    }

    public static boolean isPrime(int n) {
        // Your code here
        if(n==1) 
            return false;

        for(int i=2;i < n;i++){
            if(n%i == 0)
                return false;
        }

        return true;
    }

    public static ArrayList<Integer> printPrimes(int N){

        ArrayList<Integer> primes = new ArrayList<>();

        for(int i=2;i<=N;i++){
            if(isPrime(i) == true)
                primes.add(i);
        }
        return primes;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // Km to miles

        // int Km = 10;
        // double ans = convertKmToMiles(Km);
        // System.out.println(ans);

        // area of circle

        // int radius = 5;
        // int ans = areaOfCircle(radius);
        // System.out.println(ans);

        // check if given number is prime

        // System.out.print("Enter number: ");
        // int num = sc.nextInt();
        // boolean ans = isPrime(num);
        // System.out.println(ans);

        // Print All Prime Numbers from 1 to N

        System.out.print("Enter number: ");
        int num = sc.nextInt();
        ArrayList<Integer> ans = printPrimes(num);
        System.out.println(ans);

        sc.close();
    }
}
