//never leave a uncompleted question in this file, always remove the code after submitting it.

import java.io.*;
import java.util.*;

public class run{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long k = in.nextInt();
        long ans = (-3 + (long)Math.sqrt(9+8*(n+k)))/2;
        System.out.println(n-ans);
    }
}