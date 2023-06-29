import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by huhansan on 2017/12/19.
 * http://codeforces.com/problemset/problem/11/D
 * 参考 Petr http://codeforces.com/contest/11/submission/47646
 * 求所有不同的环的个数
 * 首先按长度分 C = C1+C2+...+Cn
 * 长度为i的环的数量的求解， 规定一个顺序，以最小值开头，按开头不同分治，再按不同结尾分治
 * 遍历所有排列，如果长度为i的排列成环，则对应的Ci值+1
 * 遍历方式的选择：
 * 1.integer实现bitmask，从1加到1<<n
 * 2.递归
 */

public class CF_11D {
    long[][] ways;  //ways[mask][endPointIndex]
    boolean[][] connect;
    int n, m, lowestIndex, mask;    //n 节点数， m边数    00000...0  <--> n:n-1:n-2.....1 bitmask
    private static int HEAD_POINT_INDEX = 0;

    public void solve() throws Exception {
        int a, b;
        long total = 0;
        n = nextInt();
        m = nextInt();
        connect = new boolean[n][n];
        ways = new long[1 << n][n];
        for (int i = 0; i < m; i++) {
            a = nextInt();
            b = nextInt();
            connect[a - 1][b - 1] = true;
            connect[b - 1][a - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            ways[1 << i][i] = 1;  //初始化，单定点也视为环
        }
        for (mask = 1; mask < 1 << n; mask++) {
            int tmp = mask, cnt = 0;
            while (tmp > 0) {
                tmp = tmp & (tmp - 1);
                cnt++;
            }
            lowestIndex = -1;
            for (int endPointIndex = 0; endPointIndex < n; endPointIndex++) {
                if ((mask & 1 << endPointIndex) != 0) {
                    if (lowestIndex < 0) {
                        lowestIndex = endPointIndex;
                    } else if (lowestIndex != endPointIndex) {
                        for (int i = lowestIndex; i < n; i++)
                            if (connect[i][endPointIndex]) {
                                ways[mask][endPointIndex] += ways[mask & ~(1 << endPointIndex)][i]; // P[(1,2,3)4]的数量 == 其它+P[1,2,3]的数量， 也就是1,2,3三个点可以组成的以1开头的排列数
                            }
                        if (connect[endPointIndex][lowestIndex] && cnt > 2) {  //以首尾定点分治，存在对称性，如 1-2-3-4-1 == 1-4-3-2-1
                            total += ways[mask][endPointIndex];
                        }
                    }
                }
            }
        }
        writer.println(total / 2);
    }

    public static void main(String[] args) {
        new CF_11D().run();
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

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
