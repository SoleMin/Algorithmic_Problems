import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;
public class Test11   {  
    public static void main(String[] Args)   {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s0 = sc.nextLine();
        int s = 0; // S
        int m = 0;
        int l = 0;
        int s1 = 0;
        int l1 = 0;
        int s2 = 0;
        int l2 = 0;
        int s3 = 0;
        int l3 = 0;
        for (int i = 0; i < n; i++)  {
            s0 = sc.nextLine();
            if (s0.charAt(0) == 'S') s++;
            if (s0.charAt(0) == 'M') m++;
            if (s0.charAt(0) == 'L') l++;
            if (s0.charAt(0) == 'X' && s0.length() == 2 && s0.charAt(s0.length() - 1) == 'S') s1++;
            if (s0.charAt(0) == 'X' && s0.length() == 3 && s0.charAt(s0.length() - 1) == 'S') s2++;
            if (s0.charAt(0) == 'X' && s0.length() == 4 && s0.charAt(s0.length() - 1) == 'S') s3++;
            if (s0.charAt(0) == 'X' && s0.length() == 2 && s0.charAt(s0.length() - 1) == 'L') l1++;
            if (s0.charAt(0) == 'X' && s0.length() == 3 && s0.charAt(s0.length() - 1) == 'L') l2++;
            if (s0.charAt(0) == 'X' && s0.length() == 4 && s0.charAt(s0.length() - 1) == 'L') l3++;
        }    
        int rs = 0; // S
        int rm = 0;
        int rl = 0;
        int rs1 = 0;
        int rl1 = 0;
        int rs2 = 0;
        int rl2 = 0;
        int rs3 = 0;
        int rl3 = 0;
        for (int i = 0; i < n; i++)  {
            s0 = sc.nextLine();
            if (s0.charAt(0) == 'S') rs++;
            if (s0.charAt(0) == 'M') rm++;
            if (s0.charAt(0) == 'L') rl++;
            if (s0.charAt(0) == 'X' && s0.length() == 2 && s0.charAt(s0.length() - 1) == 'S') rs1++;
            if (s0.charAt(0) == 'X' && s0.length() == 3 && s0.charAt(s0.length() - 1) == 'S') rs2++;
            if (s0.charAt(0) == 'X' && s0.length() == 4 && s0.charAt(s0.length() - 1) == 'S') rs3++;
            if (s0.charAt(0) == 'X' && s0.length() == 2 && s0.charAt(s0.length() - 1) == 'L') rl1++;
            if (s0.charAt(0) == 'X' && s0.length() == 3 && s0.charAt(s0.length() - 1) == 'L') rl2++;
            if (s0.charAt(0) == 'X' && s0.length() == 4 && s0.charAt(s0.length() - 1) == 'L') rl3++;
        }     
        int ans = Math.abs(s1 - rs1) + Math.abs(s2 - rs2) + Math.abs(s3 - rs3) + (Math.abs(s - rs) + Math.abs(l - rl) + Math.abs(m - rm))/2;
        System.out.println(ans);
            
   }
}