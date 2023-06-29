import java.io.*;
import java.util.*;
public class B {
    static FastScanner fs;
    public static void main(String[] args) {
        fs=new FastScanner();
        int t = fs.nextInt();
        while (t-->0)
            solve();
    }
    public static void solve() {
        int n = fs.nextInt()*2;
        int sq = (int)Math.sqrt(n);
        int sq2 = (int)Math.sqrt(n/2);
        if (sq*sq==n) System.out.println("YES");
        else if (sq2*sq2==n/2.0 && sq2%2==0) System.out.println("YES");
        else System.out.println("NO");
    }
    static int gcd(int a, int b) {
        if (a==0) return b;
        return gcd(b%a, a);
    }
    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static final Random random =new Random();
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static int[] reverse(int[] a) {
        int n=a.length;
        int[] res=new int[n];
        for (int i=0; i<n; i++) res[i]=a[n-1-i];
        return res;
    }
}