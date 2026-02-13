package basicMathPrograms;

import java.util.Scanner;

public class MSbasicMathPrograms {
    
    public static int countDivisors(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num%i == 0)
                count++;
        }
        return count;
    }

    public static long factorial(int num){
        // if 0 or 1
        long f  = 1; 
        if(num == 0 || num == 1)
            return f;

        for(int i=num;i>1;i--){
            f = f * i;
        }
        return f;
    }

    public static int twos_2sComplement(int num){
        // Step 1: Invert all bits (1's Complement)
        int ones_Complement = ~num;

        // Step 2: Add 1 to the result
        int _2sComplement = ones_Complement + 1;

        return _2sComplement;
    }

    public static int gcdEucledian(int a,int b){
        // Handle 0 cases safely (optional but good practice)
        if(a==0)
            return b;

        if(b==0)
            return a;

        // Keep subtracting the smaller from the larger until they are equal
        while(a != b){
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }

        // When a == b, that value is the GCD
        return a;
    }

    public static int lcm(int a,int b){
        int gcd = gcdEucledian(a, b);

        int lcm = (a*b) / gcd;

        return lcm;
    }
    
    public static String isNarsasstic(int num){
        // declare temp for saving original num
        int temp = num;
        int count = 0;
        int num2 = 0;
        
        // count digits in num
        while(temp > 0){
            temp /= 10;
            count++;
        }

        // reset
        temp = num;

        // take each digit from num power it to the count
        while(temp > 0){
            int digit = temp%10;
            num2 += Math.pow(digit, count);
            temp /=10;
        }
        return num == num2 ? "Yes": "No";       
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // count divisors of a number

        // System.out.print("Enter the number: ");
        // int num = sc.nextInt();
        // int count = countDivisors(num);
        // System.out.println("Total number of Divisors of "+num+" are "+count);


        // factorial of number

        // System.out.print("Enter the number: ");
        // int num = sc.nextInt();
        // long ans = factorial(num);
        // System.out.println("Factorial of "+num+ " is " + ans);

        // find 2's Complement of a number

        // System.out.print("Enter the number: ");
        // int num = sc.nextInt();
        // int Complement = twos_2sComplement(num);
        // System.out.println(num + " complement is "+ Complement);


        // find gcd of two numbers

        // int a = 18;
        // int b = 48;
        // int ans = gcdEucledian(a, b);
        // System.out.println("GCD is "+ans);

        // find lcm of two numbers
        
        // int a = 5;
        // int b = 4;
        // int ans = lcm(a, b);
        // System.out.println("LCM is "+ans);

        // Check if a Number is a Narcissistic Number

        int num = 153;
        String ans = isNarsasstic(num);
        System.out.println(ans);
        sc.close();
    }
}
