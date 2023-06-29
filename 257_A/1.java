import java.io.*;
import java.util.*;

// device can plug the supply-line filter
// plugged to electricity if it is either plugged to one of k electrical sockets

public class A {
    private static final int[] TYPES_OF_APARTMENTS = new int[]{3, 5, 7};

    public static void main(String[] args) {
        try {
            FastScanner in = new FastScanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
            // # supply-line filters, # devices, # sockets
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = in.nextInt();

            out.println(solve(array, m, k));

            out.close();

        } catch(Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    private static int solve(int[] supplies, int device, int socket) {
        Arrays.sort(supplies);
        int cnt = 0;
        for (int i = supplies.length - 1; i >= 0; i--) {
            if (device <= socket) return cnt;
            if (socket > 0) {
                socket += supplies[i];
            }
            socket--;
            cnt++;
        }
        return device <= socket ? cnt : -1;
    }

    private static String print(int[] values) {
        if (values == null) return "-1";
        StringBuilder sb = new StringBuilder();
        sb.append(values[0]).append(" ").append(values[1]).append(" ").append(values[2]);
        return sb.toString();
    }

    //@
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if (st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        //#
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
    //$
}
