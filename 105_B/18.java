import java.awt.*;
import java.io.*;
import java.math.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound81_B implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new BetaRound81_B(), "", 256 * (1L << 20)).start();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    /** http://pastebin.com/j0xdUjDn */
    static class Utils {

        private Utils() {}

        public static void mergeSort(int[] a) {
            mergeSort(a, 0, a.length - 1);
        }

        private static final int MAGIC_VALUE = 50;

        private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
            if (leftIndex < rightIndex) {
                if (rightIndex - leftIndex <= MAGIC_VALUE) {
                    insertionSort(a, leftIndex, rightIndex);
                } else {
                    int middleIndex = (leftIndex + rightIndex) / 2;
                    mergeSort(a, leftIndex, middleIndex);
                    mergeSort(a, middleIndex + 1, rightIndex);
                    merge(a, leftIndex, middleIndex, rightIndex);
                }
            }
        }

        private static void merge(int[] a, int leftIndex, int middleIndex, int rightIndex) {
            int length1 = middleIndex - leftIndex + 1;
            int length2 = rightIndex - middleIndex;
            int[] leftArray = new int[length1];
            int[] rightArray = new int[length2];
            System.arraycopy(a, leftIndex, leftArray, 0, length1);
            System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
            for (int k = leftIndex, i = 0, j = 0; k <= rightIndex; k++) {
                if (i == length1) {
                    a[k] = rightArray[j++];
                } else if (j == length2) {
                    a[k] = leftArray[i++];
                } else {
                    a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
                }
            }
        }

        private static void insertionSort(int[] a, int leftIndex, int rightIndex) {
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                int current = a[i];
                int j = i - 1;
                while (j >= leftIndex && a[j] > current) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = current;
            }
        }

    }

    // solution

    int n, k, A;
    int[] b, l, c;
    
    void solve() throws IOException {
        n = readInt();
        k = readInt();
        A = readInt();
        b = new int[n];
        l = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = readInt();
            l[i] = readInt();
        }
        c = new int[n];
        rec(0, 0);
        out.printf("%.12f\n", ans);
    }
    
    double ans = 0;
    
    void rec(int sum, int i) {
        if (i > n) return;
        if (sum > k) return;
        if (i == n) {
            ans = max(ans, p());
            return;
        }
        if (l[i] + c[i]*10 <= 100) {
            int can = min(k - sum, (100 - (l[i] + c[i]*10)) / 10);
            for (int set = can; set >= 0; set--) {
                c[i] += set;
                rec(sum + set, i + 1);
                c[i] -= set;
            }
        }
    }

    double p() {
        int n = c.length;
        int need = n / 2 + 1;
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = l[i] + c[i]*10;
            if (L[i] > 100) {
                throw new RuntimeException();
            }
        }
        
        double p = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            double q = 1;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) != 0) {
                    q *= L[i] / 100.0;
                } else {
                    q *= 1 - (L[i] / 100.0);
                }
            }
            if (q == 0) continue;
            if (Integer.bitCount(mask) >= need) {
                p += q;
            } else {
                int B = 0;
                for (int i = 0; i < n; i++) {
                    if (((1 << i) & mask) == 0) {
                        B += b[i];
                    }
                }
                double q2 = ((double) A) / (A + B);
                p += q * q2;
            }
        }
        return p;
    }
    
}
