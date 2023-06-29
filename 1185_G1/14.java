import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;

public class l {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMMMM      MMMMMM      OOO      OOO        SSSS   SSS     EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEE           MMMM MMM  MMM MMMM    OOO          OOO    SSSS       SSS   EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM  MMMMMM  MMMM   OOO            OOO   SSSS             EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM  OOO              OOO   SSSSSSS         EEEEE          /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO      SSSSSS       EEEEEEEEEEE    /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO         SSSSSSS   EEEEEEEEEEE    /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM   OOO            OOO              SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM    OOO          OOO     SSS       SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM      OOO      OOO        SSS    SSSS    EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static long mod = (int) (1e9 + 7);
    static int n;
    static StringBuilder sol;

    static class pair implements Comparable<pair> {
        int L,R;
        public pair( int x,int y) {
            L=x;R=y;
        }


        public int compareTo(pair o) {
            if (L!=o.L)return L-o.L;
            return o.R-R;
        }
        public String toString(){
            return L+" "+R;
        }
    }

    static boolean is;
    static int [][][]memo;
    static int[]val,gen;
    static int dp(int last,int rem,int msk){
        if (rem==0)return 1;
        if (memo[last][rem][msk]!=-1)return memo[last][rem][msk];
        int ans =0;
        for (int i =0;i<n;i++){
            if ((msk&1<<i)==0){
                if (gen[i]!=last&&val[i]<=rem){
                    ans+=dp(gen[i],rem-val[i],msk|1<<i);
                    ans%=mod;
                }
            }
        }
        return memo[last][rem][msk]=ans;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //FileWriter f = new FileWriter("C:\\Users\\Ibrahim\\out.txt");
        PrintWriter pw = new PrintWriter(System.out);
         n = sc.nextInt();
        int t = sc.nextInt();
        gen= new int[n];
        val= new int[n];
        for (int i =0;i<n;i++){
            val[i]=sc.nextInt();
            gen[i]=sc.nextInt();
        }
        memo= new int[4][t+1][1<<n];
        for (int[][]x:memo)for (int[]a:x)Arrays.fill(a,-1);
        pw.println(dp(0,t,0));
        pw.flush();
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
        public boolean ready() throws IOException {
            return br.ready();
        }

    }

}