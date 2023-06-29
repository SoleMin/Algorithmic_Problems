import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    FastScanner in = new FastScanner(System.in);
//    FastScanner in = new FastScanner(new File("test.txt"));
    
    PrintWriter out = new PrintWriter(System.out);

    public static void main (String[]args) {
        Main task = new Main();
        task.solve();
        task.close();
    }

    public void close () {
        in.close();
        out.close();
    }
    
    public void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        
        Team[]teams = new Team[n];
        
        for (int i = 0; i < n; i++) {
            Team t = new Team();
            t.tasks = in.nextInt();
            t.penalty = in.nextInt();
            teams[i] = t;
        }
        
        Arrays.sort(teams);
        
        Team t = teams[k - 1];
        int ans = 0;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].equals(t)) ans++;
        }
         
        System.out.println(ans);
            
        
    }
    class Team implements Comparable<Team>{
        int tasks;
        int penalty;
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + penalty;
            result = prime * result + tasks;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Team other = (Team) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (penalty != other.penalty)
                return false;
            if (tasks != other.tasks)
                return false;
            return true;
        }
        @Override
        public int compareTo(Team o) {
            if (this.tasks > o.tasks) return -1;
            else if (this.tasks == o.tasks) {
                if (this.penalty <= o.penalty) return -1;
                else return 1;
            }
            else return 1;
        }
        private Main getOuterType() {
            return Main.this;
        }
        
    }
    
    public int max (int a, int b) {
        if (a > b) return a;
        else return b;
    }
    
    
}


class Algebra {
    /****
     *       Number of co-prime numbers on [1, n].
     *       Number a is Co-prime if gcd (a, n) == 1
     *       O (sqrt(n))
     ****/
    public static int phi(int n) {
        int result = n;
        for (int i = 2; i*i <= n; ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    /****
     *       Raise number a to power of n.
     *       O (log n)
     ****/
    public static int binpow (int a, int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) == 1)
                res *= a;
            a *= a;
            n >>= 1;
        }
        return res;
    }

    /****
     *       Finding the greatest common divisor of two numbers.
     *       O (log min(a, b))
     ****/
    public static int gcd (int a, int b) {
        return (b != 0) ? gcd (b, a % b) : a;
    }

    /****
     *       Finding the lowest common multiple of two numbers.
     *       O (log min(a, b))
     ****/
    public static int lcm (int a, int b) {
        return a / gcd (a, b) * b;
    }

    /****
     *       Eratosthenes Sieve of numbers - [0..n]. True - simple, False - not simple.
     *       O (n log log n)
     ****/
    public static boolean[] sieveOfEratosthenes (int n) {
        boolean [] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i=2; i<=n; ++i) {
            if (prime[i]) {
                if (i * 1L * i <= n) {
                    for (int j=i*i; j<=n; j+=i) {
                        prime[j] = false;
                    }
                }
            }
        }
        return prime;
    }    
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    
    FastScanner(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    FastScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }
    
    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                System.err.println(e);
                return "";
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    float nextFloat() {
        return Float.parseFloat(next());
    }
    BigInteger nextBigInt() {
        return new BigInteger(next());
    }

    void close() {
        try {
            br.close();
        }
        catch (IOException e) {
        }
    }
}