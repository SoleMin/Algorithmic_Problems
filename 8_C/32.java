import java.io.*;
import static java.lang.Math.*;
import java.util.*;
import java.util.function.*;
import java.lang.*;

public class Main {
    final static boolean debug = false;
    final static String fileName = "";
    final static boolean useFiles = false;

    public static void main(String[] args) throws FileNotFoundException {
        long start;
        if (debug)
            start = System.nanoTime();
        InputStream inputStream;
        OutputStream outputStream;
        if (useFiles) {
            inputStream = new FileInputStream(fileName + ".in");
            outputStream = new FileOutputStream(fileName + ".out");
        } else {
            inputStream = System.in;
            outputStream = System.out;
        }
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task(in, out);
        solver.solve();
        if(debug)
            out.println((System.nanoTime() - start) / 1e+9);
        out.close();
    }
}
class Task {
    int[][] dist, pre;
    int[] x, y, d, prev;
    String[] leafDescription;
    String[] linerDescription;
    String[][] allDescriptions;
    int xs, ys, n;

    int dist(int i, int j) {
        return (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
    }

    void go(int[] prev, String[] leafDescription, int[] d, int len, int add, String description){
        for (int mask = 0; mask < d.length; mask++) {
            if ((mask & add) != add)
                continue;
            int newValue = d[mask & (~add)] + len;
            if (d[mask] > newValue){
                d[mask] = newValue;
                leafDescription[mask] = description;
                prev[mask] = mask & (~add);
            }
        }
    }

    int rec(int mask) {
        if (d[mask] != -1)
            return d[mask];
        int lowest = 0;
        for (; ((1 << lowest) & mask) == 0; lowest++) ;

        int newMask = mask & (~(1 << lowest));
        d[mask] = rec(newMask) + dist[lowest][n];
        prev[mask] = newMask;
        leafDescription[mask] = linerDescription[lowest];

        for (int bit = lowest + 1; bit < n; bit++) {
            if (((1 << bit) & mask) > 0) {
                newMask = mask & (~(1 << bit)) & (~(1 << lowest));
                int newValue = rec(newMask) + pre[bit][lowest];
                if (newValue < d[mask]) {
                    d[mask] = newValue;
                    prev[mask] = newMask;
                    leafDescription[mask] = allDescriptions[lowest][bit];
                }
            }
        }
        return d[mask];
    }

    public void solve() {
        final int inf = (int) 1e+9;
        xs = in.nextInt();
        ys = in.nextInt();

        n = in.nextInt();
        x = new int[n + 1];
        y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        x[n] = xs;
        y[n] = ys;

        allDescriptions = new String[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                allDescriptions[i][j] = (i + 1) + " " + (j + 1) + " ";
            }
        }

        linerDescription = new String[n];
        for (int i = 0; i < n; i++){
            linerDescription[i] = (i + 1) + " ";
        }

        dist = new int[n + 1][n + 1];
        pre = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dist[i][j] = 2 * dist(i, j);
                pre[i][j] = dist(i, n) + dist(i, j) + dist(j, n);
            }
        }

        d = new int[1 << n];
        Arrays.fill(d, -1);
        d[0] = 0;
        prev = new int[1 << n];
        leafDescription = new String[1 << n];
//        Arrays.fill(d, inf);
//        prev[0] = 0;
//        d[0] = 0;
//        for (int i = 0; i < n; i++) {
//            int add = 1 << i;
//            int len = 2 * dist[n][i];
//            String description = (i + 1) + " ";
//
//            go(prev, leafDescription, d, len, add, description);
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int add = (1 << i) | (1 << j);
//                int len = dist[n][i] + dist[i][j] + dist[n][j];
//                String description = (i + 1) + " " + (j + 1) + " ";
//
//                go(prev, leafDescription, d, len, add, description);
//            }
//        }
//        Debug.printObjects(out, d);
//        Debug.printObjects(out, prev);
//        Debug.printObjects(out, leafDescription);
        int result = rec((1 << n) - 1);
        String answer = "";
        for (int curr = d.length - 1; prev[curr] != curr; curr = prev[curr] ){
            answer += "0 " + leafDescription[curr];
        }
        answer += "0";
        out.println(result);
        out.println(answer);
    }

    private InputReader in;
    private PrintWriter out;

    Task(InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }

    public byte nextByte(){
        return Byte.parseByte(next());
    }
}