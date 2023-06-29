import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    static void sieveOfEratosthenes(int n, int factors[], ArrayList<Integer> ar) 
    { 
        factors[1]=1;
        int p;
        for(p = 2; p*p <=n; p++) 
        { 
            if(factors[p] == 0) 
            { 
                ar.add(p);
                factors[p]=p;
                for(int i = p*p; i <= n; i += p) 
                    factors[i] = p; 
            } 
        } 
        for(;p<=n;p++){
            if(factors[p] == 0) 
            { 
                ar.add(p);
            } 
        }
    }

    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static void sort1(long ar[]) {
        int n = ar.length;
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }

    static int findMax(int a[], int n, int vis[], int i, int d){
        if(i>=n)
            return 0;
        if(vis[i]==1)
            return findMax(a, n, vis, i+1, d);
        int max = 0;
        for(int j=i+1;j<n;j++){
            if(Math.abs(a[i]-a[j])>d||vis[j]==1)
                continue;
            vis[j] = 1;
            max = Math.max(max, 1 + findMax(a, n, vis, i+1, d));
            vis[j] = 0;
        }
        return max;
    }

    public static void solve(InputReader sc, PrintWriter pw){
        int i, j = 0;
        // int t = 1; 
        int t = sc.nextInt();
        u: while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(0);
            for(i=0;i<1000;i++){
                ar.add(0);
            }
            int m = 1;
            for(i=0;i<n;i++){
                a[i] = sc.nextInt();
                if(a[i]==1){
                    ar.set(m,1);
                    m++;
                }
                else{
                    while(m>0&&ar.get(m-1)!=a[i]-1){
                        m--;
                    }
                    ar.set(m-1,a[i]);
                }
                pw.print(ar.get(1));
                for(j=2;j<m;j++){
                    pw.print("."+ar.get(j));
                }
                pw.println();
            }
        }
    }

    static long findOne(int n, int sz[], ArrayList<Integer> ar){
        long paths = n-1;
        long till = 0;
        for(int v:ar){
            paths += till*sz[v];
            till += sz[v];
        }
        return paths;
    }

    static void assignAnc(ArrayList<Integer> ar[],int sz[], int pa[] ,int curr, int par){
        sz[curr] = 1;
        pa[curr] = par;
        for(int v:ar[curr]){
            if(par==v)
                continue;
            assignAnc(ar, sz, pa, v, curr);
            sz[curr] += sz[v];
        }
    }

    static int findLCA(int a, int b, int par[][], int depth[]){
        if(depth[a]>depth[b]){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        int diff = depth[b] - depth[a];
        for(int i=19;i>=0;i--){
            if((diff&(1<<i))>0){
                b = par[b][i];
            }
        }
        if(a==b)
            return a;
        for(int i=19;i>=0;i--){
            if(par[b][i]!=par[a][i]){
                b = par[b][i];
                a = par[a][i];
            }
        }
        return par[a][0];
    }

    static void formArrayForBinaryLifting(int n, int par[][]){
        for(int j=1;j<20;j++){
            for(int i=0;i<n;i++){
                if(par[i][j-1]==-1)
                    continue;
                par[i][j] = par[par[i][j-1]][j-1];
            }
        }
    }

    static long lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    static class Pair1 {
        long a;
        long b;
        
        Pair1(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;
        int c;
        
        Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
 
        public int compareTo(Pair p) {
            // if(a!=p.a)
            //     return a-p.a;
            // return b-p.b;
            return p.c - c;
        }
    }

    // static boolean isPrime(long n) {
    //     if (n <= 1)
    //         return false;
    //     if (n <= 999)
    //         return true;
    //     if (n % 2 == 0 || n % 999 == 0)
    //         return false;
    //     for (int i = 5; i * i <= n; i = i + 6)
    //         if (n % i == 0 || n % (i + 2) == 0)
    //             return false;
    //     return true;
    // }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 9992768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}