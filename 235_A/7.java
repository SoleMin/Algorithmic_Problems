/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Sourav Kumar Paul
 */
public class A235 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        //int gcd = gcd(924,923);
        //System.out.println(gcd);
       // System.out.println(gcd(923,461));
        if(n<=2)
            System.out.println(n);
        else if(n==3)
            System.out.println("6");
        
        else if(n % 2== 0)
       {
           if(n % 3 == 0)
           {
               System.out.println((n-3)*(n-1)*(n-2));
           }
           else
               
           System.out.println(n * (n-1) * (n-3) );
       }
        else
            System.out.println(n*(n-1)*(n-2));
    }
     private static int gcd(int i, int j) {
        int a = Math.min(i,j);
        int b = Math.max(i,j);
       while(a != 0)
       {
           int temp = b % a;
           b = a;
           a = temp;
       }
       return b;
    }
}
