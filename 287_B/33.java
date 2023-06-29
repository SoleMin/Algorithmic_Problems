/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package pipeline;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        long n=scan.nextLong(),k=scan.nextLong();
        if(n>((k-2)*(k-1))/2+k){
            System.out.println("-1");
        }
 else if(n==1){
            System.out.println("0");

 }
 else if(n<=k&&n>1){
            System.out.println("1");
 }
 else{
            n-=k;
            long start=k-2;
            long x;
            long left=1,right=k-2;
           // System.out.println(left+" "+right);
            while(left<=right){
            x=(left+right)/2;
            //    System.out.println(x);
                
            if(n>cumSum(x, start)){
            left=x+1;
          //  System.out.println("if");
            }
 else if(n<cumSum(x-1, start)){
 right=x-1;
            //    System.out.println("else if");
 }
 else{
                System.out.println(1+x);
                break;
 }
            }


 }

    }
    public static long cumSum(long x,long start){
    return (x*(2*start+1-x))/2;
    }

}
