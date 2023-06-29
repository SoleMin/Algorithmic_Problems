
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1238/E>
 * @category dp
 * @date 19/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;

public class CF1238E {
    static long[][] Q;
    static int N;
    static int M;
    static long[] mem;
    static long[] sums;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            char[] S = in.readLine().toCharArray();
            Q = new long[M][M];
            mem = new long[1 << M];
            Arrays.fill(mem, -1);
            for (int i = 1; i < N; i++)
                Q[S[i - 1] - 'a'][S[i] - 'a'] = Q[S[i] - 'a'][S[i - 1] - 'a'] = Q[S[i - 1] - 'a'][S[i] - 'a'] + 1;
            calculateSums();
            for (int i = (1 << M) - 1; i >= 0; i--)
                f(i);
            System.out.println(f(0));
        }
    }

    static void calculateSums() {
        sums = new long[1 << M];
        Arrays.fill(sums, -1);
        for (int u = 0; u < (1 << M); u++) {
            if (sums[u] == -1) {
                sums[u] = 0;
                for (int j = 0; j < M; j++)
                    for (int k = j + 1; k < M; k++)
                        if (((u & (1 << j)) == 0 && (u & (1 << k)) != 0) ||
                                ((u & (1 << j)) != 0 && (u & (1 << k)) == 0))
                            sums[u] += Q[j][k];
                int neg = (~u) & ((1 << M) - 1);
                sums[neg] = sums[u];
            }
        }
    }

    static long f(int u) {
        if (bitCount(u) == M) return 0;
        if (mem[u] >= 0)
            return mem[u];
        long min = 10000000000L;
        for (int i = 0; i < M; i++)
            if ((u & (1 << i)) == 0) {
                u = u | (1 << i);
                min = Math.min(f(u) + sums[u], min);
                u = u ^ (1 << i);
            }
        return mem[u] = min;
    }
}
