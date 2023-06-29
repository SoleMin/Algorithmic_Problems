import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        
        int n = nextInt(), k = nextInt();
        int[] primes = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                primes[i] = 1;
                for (int j = i * 2; j <= n; j += i)
                    primes[j] = 2;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> p = new HashSet<Integer>(), v = new HashSet<Integer>();
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1) {
                res.add(i);
                p.add(i);
            }
        }
        int c = 0;
        if (res.size() >= 3) {
            for (int i = 2; i < res.size(); i++) {
                int zz = res.get(i - 2) + res.get(i - 1) + 1;
                if (p.contains(zz))
                    v.add(zz);
            }
            c = v.size();
        }
        if (c >= k) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        in.close();
        out.close();
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    static String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextString());
    }

    static double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextString());
    }
}
