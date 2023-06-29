/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.text.*;

public class cf276d {

    static BufferedReader br;
    static Scanner sc;
    static PrintWriter out;

    public static void initA() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(System.in);
            //out = new PrintWriter("output.txt");
            out = new PrintWriter(System.out);
        } catch (Exception e) {
        }
    }

    public static void initB() {
        try {

            br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");

        } catch (Exception e) {
        }
    }

    public static String getString() {
        try {
            return br.readLine();
        } catch (Exception e) {
        }
        return "";
    }

    public static Integer getInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
        }
        return 0;
    }

    public static Integer[] getIntArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Integer temp2[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Integer.parseInt(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static Long[] getLongArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Long temp2[] = new Long[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Long.parseLong(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static String[] getStringArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            String temp2[] = new String[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = (temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static int getMax(Integer[] ar) {
        int t = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > t) {
                t = ar[i];
            }
        }
        return t;
    }

    public static void print(Object a) {
        out.println(a);
    }

    public static int nextInt() {
        return sc.nextInt();
    }

    public static double nextDouble() {
        return sc.nextDouble();
    }

    public static void main(String[] ar) {
        initA();
        solve();
        out.flush();
    }
    public static void print2(Object o){System.out.println(o);}

    public static void solve() {
        Long xx[] = getLongArr();
        long l = xx[0];
        long r = xx[1];
        BigInteger a = BigInteger.valueOf(l);
        BigInteger b = BigInteger.valueOf(r);
        
        if(l==r){
            print(0);return;
        }

        String a2 = a.toString(2);
        String b2 = b.toString(2);

        int selisihpjg = Math.abs(a2.length() - b2.length());

        while (selisihpjg-- > 0) {
            a2 = "0" + a2;
            //print2("wewe");
        }
        
        //print2(a2);
        //print2(b2);
        String out = "";

        for (int i = 0; i < b2.length(); i++) {
            //print2("i="+i);
            if (a2.charAt(i) != b2.charAt(i)) {
                
                for (int ii = i; ii < b2.length(); ii++) {
                    out += "1";
                }
                //print2(out);
                print2(new BigInteger(out, 2));
                return;
            }
        }

    }
}
