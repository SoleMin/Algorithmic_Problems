import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner t=new Scanner(System.in);
        long l=t.nextLong();
        long r=t.nextLong();
        if(r-l<2) System.out.println(-1);
        else if(r-l<3 && l%2!=0){
            if(l%3!=0) System.out.println(-1);
            else if ((l+3)%2==0) System.out.println(-1);
                else System.out.println(l+" "+(l+1)+" "+(l+3));
        } else{
            while (l%2!=0) l++;
            System.out.println(l+" "+(l+1)+" "+(l+2));
        }
    }
}