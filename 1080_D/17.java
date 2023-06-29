
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
//        System.err.println(f(1));


//        System.err.println(f(4));
        int tc = sc.nextInt();
        out: while(tc-->0){
            long n = sc.nextInt();

            long k = sc.nextLong();
            if(n >= 32){
                pw.println("YES " + (n-1));
                continue;
            }

            long steps = 0;
            for (int i = 1;; i++) {
                long cnt = ((1l<<(i+1))-1);
                steps += ((1l<<(i))-1);
                if(steps > k)
                    break;
                if(steps > f(n))
                    break;
//                long rem = k-((1<<i)-1);
                long rem = k-steps;
//                System.err.println("steps:" + steps + " cnt:" + cnt + " f:"  + f(n-i));
//                System.err.println("rem: " + (f(n) - steps - cnt*f(n-i)));
                if(rem <= f(n) - steps - cnt*f(n-i)){
                    pw.println("YES " + (n-i));
                    continue out;
                }
            }

            pw.println("NO");
        }


        pw.flush();
        pw.close();
    }


    static long f(long n){
        if(n == 0)
            return 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 1l<<(2*i);
        }
        return ans;
    }

    static int[][] matMul(int[][] A, int[][] B, int p, int q, int r)	//C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
    {
        int[][] C = new int[p][r];
        for(int i = 0; i < p; ++i)
            for(int j = 0; j < r; ++j)
                for(int k = 0; k < q; ++k)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    /*
     * 4. Square Matrix Exponentiation
     */
    static int[][] matPow(int[][] base, int p)
    {
        int n = base.length;
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++)
            ans[i][i] = 1;
        while(p != 0)
        {
            if((p & 1) == 1)
                ans = matMul(ans, base, n, n, n);
            base = matMul(base, base, n, n, n);
            p >>= 1;
        }

        return ans;
    }


    static int[][] packU(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int f : from)
            p[f]++;
        for (int t : to)
            p[t]++;
        for (int i = 0; i < n; i++)
            g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) {
            g[from[i]][--p[from[i]]] = to[i];
            g[to[i]][--p[to[i]]] = from[i];
        }
        return g;
    }
    static int pow(int n, int p){
        int ans = 1;
        for (int i = 0; i < p; i++) {
            ans *= n;
        }
        return ans;
    }

    static int[][] packD(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int f : from) if(f != -1) p[f]++;
        for (int i = 0; i < n; i++) g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) if(from[i] != -1) {g[from[i]][--p[from[i]]] = to[i];}
        return g;
    }

    static void shuffle(int[] a)
    {
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            int r = i + (int)(Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    static class Scanner
    {
        StringTokenizer st; BufferedReader br;
        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(new File(s)));}
        public String next() throws IOException {while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public long nextLong() throws IOException {return Long.parseLong(next());}
        public String nextLine() throws IOException {return br.readLine();}
        public boolean ready() throws IOException {return br.ready();}
    }
}
