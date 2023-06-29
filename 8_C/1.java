import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LookingForOrder {
    private int[][] distance;
    private int[] dp;
    private int[] prev;

    public static void main(String[] args) throws IOException {
        new LookingForOrder().solve();
    }

    public void solve() throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(f.readLine());
        int[][] coords = new int[n + 1][2];
        coords[0][0] = x;
        coords[0][1] = y;
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(f.readLine());
            x = Integer.parseInt(tokenizer.nextToken());
            y = Integer.parseInt(tokenizer.nextToken());
            coords[i][0] = x;
            coords[i][1] = y;
        }

        this.distance = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                distance[i][j] += (coords[i][0] - coords[j][0]) * (coords[i][0] - coords[j][0]);
                distance[i][j] += (coords[i][1] - coords[j][1]) * (coords[i][1] - coords[j][1]);
            }
        }

        int lastSet = 1 << n;
        this.prev = new int[lastSet];

        this.dp = new int[lastSet];
        Arrays.fill(dp, Integer.MAX_VALUE);
        this.dp[0] = 0;
       // this.getMinPath(lastSet);

        for (int i = 1; i < lastSet; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0 && this.dp[i ^ (1 << j)] + distance[0][j + 1] * 2 < this.dp[i]) {
                    //System.out.println(Integer.toBinaryString(i) + " " + Integer.toBinaryString(j) + " " + this.dp[i ^ (1 << j)]);
                    this.dp[i] = this.dp[i ^ (1 << j)] + distance[0][j + 1] * 2;
                    this.prev[i] = i ^ (1 << j);
                }
            }
            //System.out.println(this.dp[i]);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (int k = j + 1; k < n; k++) {
                        if ((i & (1 << k)) != 0) {
                           // System.out.println(i + " " + j + " " + (i ^ (1 << j) ^ (1 << k)));
                            if (this.dp[i ^ (1 << j) ^ (1 << k)] + this.distance[0][j + 1] + this.distance[0][k + 1] + this.distance[j + 1][k + 1] < this.dp[i]) {
                                this.dp[i] = this.dp[i ^ (1 << j) ^ (1 << k)] + this.distance[0][j + 1] + this.distance[0][k + 1] + this.distance[j + 1][k + 1];
                                this.prev[i] = i ^ (1 << j) ^ (1 << k);
                            }
                        }
                    }

                    break;
                }
            }
          //  System.out.println(this.dp[i]);
        }

        lastSet--;
        PrintWriter out = new PrintWriter(System.out);
        out.println(dp[lastSet]);
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        boolean started = false;
        while (lastSet != 0) {
            // System.out.println(lastSet);
            stack.addFirst(0);
            int diff = lastSet - prev[lastSet];
            //System.out.println(diff);
            for (int i = 1, j = 1; j <= n; j++, i *= 2) {
                if ((diff & i) != 0) {
                    stack.addFirst(j);
                }
            }

            lastSet = this.prev[lastSet];
        }
        stack.addFirst(0);

        while (!stack.isEmpty()) {
            if (!started) {
                out.print(stack.pop());
                started = true;
            } else {
                out.print(" ");
                out.print(stack.pop());
            }
        }

        out.println();
        out.close();
    }

    /*
    private int getMinPath(int set) {
        if (this.dp[set] != Integer.MAX_VALUE) {
            return this.dp[set];
        }

        for (int i = 1, j = 1; i < this.dp.length; i *= 2, j++) {
            if ((set & i) == i) {
                int subPath;
                int possibleMin = getMinPath(set & (set - i)) + (this.distance[0][j] * 2);
                if (possibleMin < this.dp[set]) {
                    this.dp[set] = possibleMin;
                    this.prev[set] = set - i;
                }
            }
        }
        for (int i0 = 1, j0 = 1; i0 < this.dp.length; i0 *= 2, j0++) {
            if ((set & i0) == i0) {
                for (int i1 = i0 * 2, j1 = j0 + 1; i1 < this.dp.length; i1 *= 2, j1++) {
                    if ((set & i1) == i1) {
                        //System.out.println(set + " " + (set & (set - i0 - i1)));
                        int possibleMin = getMinPath(set & (set - i0 - i1)) + this.distance[0][j0] + this.distance[0][j1] + this.distance[j0][j1];
                        if (possibleMin < this.dp[set]) {
                            this.dp[set] = possibleMin;
                            this.prev[set] = set - i0 - i1;
                        }
                    }
                }
                break;
            }
        }

        // System.out.println(this.dp[set] + " " + Integer.toBinaryString(set));
        return this.dp[set];
    } */
}