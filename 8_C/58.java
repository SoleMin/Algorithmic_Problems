import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainC {

    private FastScanner in;
    private PrintWriter out;

    private int N;
    private Dist[] dists;
    private int countDists;
    private int[][] minLeft;// startsFrom, count

    private int[] minOrder;
    private int minOrderCount = 10000000;

    public void solve() throws IOException {
        int xb = in.nextInt();
        int yb = in.nextInt();
        N = in.nextInt();
        int[] x, y;
        boolean isOdd;
        if (N % 2 == 0) {
            x = new int[N];
            y = new int[N];
            isOdd = false;
        }
        else {
            x = new int[N + 1];
            y = new int[N + 1];
            isOdd = true;
        }
        for (int i = 0; i < N; i++) {
            x[i] = in.nextInt() - xb;
            y[i] = in.nextInt() - yb;
        }
        if (N % 2 == 1) {
            N++;
            x[N - 1] = 0;
            y[N - 1] = 0;
        }

        countDists = N * (N - 1) / 2;
        dists = new Dist[countDists];
        int c = 0;
        int commonSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                dists[c] = new Dist();
                dists[c].from = i;
                dists[c].to = j;
                dists[c].dist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
                                * (y[i] - y[j]);
                dists[c].dist = Math.min(dists[c].dist, x[i] * x[i] + y[i]
                                * y[i] + x[j] * x[j] + y[j] * y[j]);
                c++;
            }
            commonSum += x[i] * x[i] + y[i] * y[i];
        }

        Arrays.sort(dists);

        minLeft = new int[countDists][N + 1];
        for (int i = 0; i < countDists; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i + j - 1 < countDists) {
                    sum = sum + dists[i + j - 1].dist;
                    minLeft[i][j] = sum;
                }
                else {
                    minLeft[i][j] = 100000000;
                }
            }
        }

        order(0, new int[N], 0, 0);

        out.println(minOrderCount + commonSum);
        for (int i = 1; i <= N / 2; i++) {
            int first = -1;
            int second = -1;
            for (int j = 0; j < N; j++) {
                if (minOrder[j] == i) {
                    if (first == -1) {
                        first = j;
                    }
                    else {
                        second = j;
                    }
                }
            }

            if (isOdd && (first == N - 1 || second == N - 1)) {
                first++;
                second++;
                out.print("0 " + (first + second - N) + " ");
            }
            else if (x[first] * x[first] + y[first] * y[first] + x[second]
                            * x[second] + y[second] * y[second] < (x[first] - x[second])
                            * (x[first] - x[second])
                            + (y[first] - y[second])
                            * (y[first] - y[second])) {
                first++;
                second++;
                out.print("0 " + first + " 0 " + second + " ");
            }
            else {
                first++;
                second++;
                out.print("0 " + first + " " + second + " ");
            }
        }

        out.println("0");
    }

    private void order(int countOrdered, int[] order, int startsFrom, int sum) {
        if (countOrdered == N) {
            if (sum < minOrderCount) {
                minOrder = Arrays.copyOf(order, N);
                minOrderCount = sum;
            }
            return;
        }

        while (startsFrom < countDists) {
            if (order[dists[startsFrom].from] == 0
                            && order[dists[startsFrom].to] == 0) {
                if (minLeft[startsFrom][(N - countOrdered) / 2] + sum >= minOrderCount) {
                    break;
                }
                order[dists[startsFrom].from] = countOrdered / 2 + 1;
                order[dists[startsFrom].to] = countOrdered / 2 + 1;
                order(countOrdered + 2, order, startsFrom + 1, sum
                                + dists[startsFrom].dist);
                order[dists[startsFrom].from] = 0;
                order[dists[startsFrom].to] = 0;
            }
            startsFrom++;
        }
    }

    private class Dist implements Comparable<Dist> {

        int from;
        int to;
        int dist;

        @Override
        public int compareTo(Dist o) {
            if (dist < o.dist) {
                return -1;
            }
            if (dist == o.dist) {
                return 0;
            }
            return 1;
        }
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
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
    }

    public static void main(String[] arg) {
        new MainC().run();
    }
}
