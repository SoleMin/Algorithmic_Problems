/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        long l= sc.nextLong();
        long r = sc.nextLong();
        if(l%2==0){
            if(r>=l+2){
                System.out.println(l + " " + (l+1) + " " + (l+2));
            }
            else{
                System.out.println(-1);
            }
        }
        else{
            if(r>=l+3){
                System.out.println((l+1) + " " + (l+2) + " " + (l+3));
            }
            else{
                System.out.println(-1);
            }
        }
    }
}