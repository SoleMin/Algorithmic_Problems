import java.util.Scanner;
import java.io.*;
import java.util.*;
public class ReallyBigNumbers817c {
     static long sd(String s) {
        long c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += s.charAt(i);
        }
        return c - s.length() * 0x30;
    }
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long s = in.nextLong(); // number
         // level -- > (n + 8) / 9 * 9; --- > s
        long i = (s/10+1)*10 ;
        if (n<10||n-sd(n+"")<s) {
            System.out.println(0);
            return;
        }
        while(!(i-sd(i+"")>=s)){
        i+=10;
        
        }
        System.out.println(n-i+1);
       
    }
    
	}

