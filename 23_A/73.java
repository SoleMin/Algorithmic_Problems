import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class StringsProb {
    private void solve() throws IOException {
        String s = nextToken();
        int res = 0;
        Map<String , Integer> m = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j <= s.length(); j++) {
                if (i > j) continue;
                String a = s.substring(i , j);
                if (a.equals("")) continue;
                if (m.containsKey(a)) {
                    m.put(a, m.get(a) + 1);
                }
                else
                    m.put(a, 1);
            }
        for (Entry<String , Integer> e : m.entrySet()) {
            if (e.getValue() >= 2)
                res = Math.max(res, e.getKey().length());
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        new StringsProb().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    long[] readLongArray(int size) throws IOException {
        long[] res = new long[size];
        for (int i = 0; i < size; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    double[] readDoubleArray(int size) throws IOException {
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
