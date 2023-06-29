
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Andrew Porokhin, andrew.porokhin@gmail.com
 */
public class Problem111A implements Runnable {
    void solve() throws NumberFormatException, IOException {
        // TODO: Write your code here ...
        final int n = nextInt();
        final int[] a = new int[n];
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            final int nextInt = nextInt();
            sum += nextInt;
            a[i] = nextInt;
        }

        Arrays.sort(a);
        int currSum = 0;
        int maxCoins = 0;
        for (int j = a.length - 1; j >= 0; j--) {
            currSum += a[j];
            maxCoins++;
            if (sum - currSum < currSum) {
                break;
            }
        }
        System.out.println(maxCoins);
    }

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) {
        // Introduce thread in order to increase stack size
        new Problem111A().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
        } catch (Exception e) {
            System.exit(9000);
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
