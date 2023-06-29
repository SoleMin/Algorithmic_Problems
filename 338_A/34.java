
import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    StreamTokenizer in;
    PrintWriter out;
    //deb////////////////////////////////////////////////

    public static void deb(String n, Object n1) {
        System.out.println(n + " is : " + n1);
    }

    public static void deb(int[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(long[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(BigInteger[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(long[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(String[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }
    /////////////////////////////////////////////////////////////

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    class Pair<X, Y> {

        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public void setX(X x) {
            this.x = x;
        }

        public void setY(Y y) {
            this.y = y;
        }
    }

    boolean inR(int x, int y) {
        return (x >= 0) && (x < nn) && (y >= 0) && (y < nn);
    }
    static int nn;

    void run() throws IOException {
        //  in = new StreamTokenizer(new BufferedReader(new FileReader("circles.in")));
        //  out = new PrintWriter(new FileWriter("circles.out"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
    static long MOD=1000000009;
static long modPow(long a, int pow) {
        long res = 1;
        while (pow > 0) {
            if ((pow & 1) != 0) {
                res = res * a % MOD;
            }
            pow >>= 1;
            a = a * a % MOD;
        }
        return res;
    }

    void solve() throws IOException {
        //   BufferedReader re= new BufferedReader(new FileReader("C:\\Users\\ASELA\\Desktop\\A.in"));
       // BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n=nextInt(),m=nextInt(),k=nextInt();
        int an=(n/k)*(k-1)+n%k;
        long ans=0;
        if(an>=m){
            System.out.println(m);
            return;
        }
        int rem=m-an;
        ans=modPow(2, rem+1)-2;
        ans*=k;
        ans+=m-rem*k;
        ans%=MOD;
       // System.out.println("sjkd"+rem);
        if(ans<0)ans+=MOD;
        System.out.println(ans);
    }
}