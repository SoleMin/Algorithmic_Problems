import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    protected static final double EPS = 1e-11;
    private static StreamTokenizer in;
    private static Scanner ins;
    private static PrintWriter out;
    protected static final Double[] BAD = new Double[]{null, null};
    private boolean[][] layouts;
    private int c;
    private int b;
    private int a;
    private String word;

    public static void main(String[] args) {

        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(System.out);
            try {
                if (System.getProperty("xDx") != null) {
                    in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
                    ins = new Scanner(new FileReader("input.txt"));
                    out = new PrintWriter(new FileWriter("output.txt"));
                }
            } catch (Exception e) {
                in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
                ins = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                out = new PrintWriter(System.out);
            }
            new Main().run();
        } catch (Throwable e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    private double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    private String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

    private char nextChar() throws IOException {
        in.nextToken();
        return (char) in.ttype;
    }

    private void run() throws Exception {
        /*int t = nextInt();
        for (int i = 0; i < t; i++) {
            out.printf(Locale.US, "Case #%d: %d\n", i + 1, solve());
        }*/
        solve();
    }

    private void solve() throws IOException {
        int n = ins.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ins.nextInt();
        }

        Map<Long, Integer> map = new HashMap<>();

        BigInteger res = BigInteger.ZERO;
        long sum = 0;
        long amount = 0;

        for (int i = n - 1; i >= 0; i--) {
            long cur = a[i];
            Pair same = getZeroAmount(cur, map);

            res = res.add(BigInteger.valueOf((sum - same.sum) - cur * (amount - same.amount)));
            amount++;
            sum += cur;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        out.println(res);
    }

    class Pair {
        long amount;
        long sum;

        public Pair(long amount, long sum) {
            this.amount = amount;
            this.sum = sum;
        }
    }

    private Pair getZeroAmount(long cur, Map<Long, Integer> map) {
        long amount = 0;
        long sum = 0;
        for (long i = cur - 1; i <= cur + 1; i++) {
            long amountI = map.getOrDefault(i, 0);
            amount += amountI;
            sum += amountI * i;
        }
        return new Pair(amount, sum);
    }

    private List<Integer> iterate(List<Integer> a) {
        ArrayList<Integer> b = new ArrayList<>();
        int prev = -1;
        for (int x : a) {
            if (x == prev) {
                b.add(x);
            } else {
                prev = x;
            }
        }
        return b;
    }

    private long gcd(long a, long b) {
        while (a > 0 && b > 0) {
            long k = a % b;
            a = b;
            b = k;
        }

        return a | b;
    }

}