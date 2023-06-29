import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem solution template.
 * @author Andrew Porokhin, andrew.porokhin@gmail.com
 */
public class Problem17A implements Runnable {
    void solve() throws NumberFormatException, IOException {
        
        
        
        int n = nextInt();
        int k = nextInt();

        ArrayList<Integer> primes = new ArrayList<Integer>(n + 1); 
        boolean[] simplePrime = new boolean[n + 1];
        Arrays.fill(simplePrime, 0, simplePrime.length, true);
        simplePrime[0] = simplePrime[1] = false;
        
        for (int i = 2; i <= n; i++) {
            if (simplePrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    simplePrime[j] = false;
                }
                
                primes.add(i);
            }
        }
        
        
        int actualK = 0;
        for (int i = 1; i < primes.size(); i++) {
            int val = primes.get(i - 1) + primes.get(i) + 1;
            if (val <= n) {
                if (simplePrime[val]) {
                    // System.out.printf("%d + %d + 1 = %d%n", primes.get(i - 1), primes.get(i), val);
                    actualK++;
                }
            } else {
                break;
            }
        }
        // System.out.printf("req: %d actual: %d%n", k, actualK);
        System.out.println((k <= actualK ? "YES" : "NO"));
    }

    
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;
    
    public static void main(String[] args) {
        new Problem17A().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }
}
