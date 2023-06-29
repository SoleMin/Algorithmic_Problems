import java.io.*;
import java.util.*;


public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        float nextFloat() {
            return Float.parseFloat(nextToken());
        }
    }


    static FastReader f = new FastReader();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long[] fact;

    static int[] inputArray(int n) throws IOException {
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++) {
//            a[i] = (int) (Math.random()*1e5 + 1);
            a[i] = f.nextInt();
        }
        return a;
    }
    static long[] inputLongArray(int n) throws IOException {
        long[] a = new long[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = f.nextLong();
//            a[i] = (long) (Math.random() * 1e9 + 1);
        }
        return a;
    }

    static long gcd(long a , long b) {
        if(a == 0 || b == 0) {
            return Math.max(a , b);
        }
        //System.out.println("a - " + a + " b - " + b);
        if(a % b == 0) {
            return b;
        }
        return gcd(b , a % b);
    }

    static void initializeFact() {
        fact = new long[MAX_N];
        for(int i = 0 ; i < fact.length ; i++) {
            if(i == 0) {
                fact[i] = 1;
            }
            else {
                fact[i] = fact[i-1] * i % mod;
            }
        }
    }

    static long longModulus(long x , long m) {
        if(x < m) {
            return x;
        }
        long d = x / m;
        return x - d * m;
    }


    static BitSet sieveOfEratosthenes(int n)
    {
        BitSet isPrime = new BitSet(n+1);
        isPrime.set(0, n + 1);
        isPrime.set(0);
        isPrime.set(1);
        for(int i = 2; i * i <= n ; i++)
        {
            if(isPrime.get(i))
                for(int j = i * i ; j <= n; j += i)
                    isPrime.clear(j);
        }
        return isPrime;
    }

    static long moduloInversePrime(long a) {
        //System.out.println("modulo inverse of " + a + " -> " + ans);
        return modPow(a , mod - 2);
    }

    static long mult(long a, long b)
    {
        return (a * b % mod);
    }

    static long modPow(long a, int step)
    {
        long ans = 1;
        while(step != 0)
        {
            if((step & 1) != 0)
                ans = mult(ans , a);
            a = mult(a , a);
            step >>= 1;
        }
        return ans;
    }

    static int query(int l , int r) {
        System.out.println("? " + l + " " + r);
        System.out.flush();
        return f.nextInt();
    }

    static int sum(int n) {
        return n * (n + 1) / 2;
    }

    private static final int mod = (int) (1e9 + 7);
    static int MAX_N = (int) Math.sqrt(1e9);


    public static void main(String[] args) throws IOException {
        int test = f.nextInt();

//        System.out.println(MAX_N);

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1 ; i <= MAX_N ; i++) {
            set.add(i*i*2);
            set.add(i*i*4);
        }

//        System.out.println(set);

        for(int t = 1 ; t <= test ; t++) {
            int n = f.nextInt();
            if(set.contains(n)) {
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }

        }
        System.out.println(sb);
    }


}
