
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String args[]) {
        FastScanner sc = new FastScanner();

        int testSize = sc.nextInt();

        for (int t = 0; t < testSize; t++) {
            int n = sc.nextInt();

            if (isSquareProduct2(n) || isSquareProduct4(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isSquareProduct2(int n) {
        if (n % 2 == 1) {
            return false;
        }

        n /= 2;

        int x = 2;

        while (x * x <= n) {
            if (n % (x * x) == 0) {
                n /= (x * x);
                x = 2;

            } else {
                x++;
            }
        }

        return n == 1;
    }

    public static boolean isSquareProduct4(int n) {
        if (n % 4 != 0) {
            return false;
        }

        n /= 4;

        int x = 2;

        while (x * x <= n) {
            if (n % (x * x) == 0) {
                n /= (x * x);
                x = 2;

            } else {
                x++;
            }
        }

        return n == 1;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
