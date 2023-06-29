
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class Main {

    static int N;
    static int [][] dp;
    static int M = (int)(1e9 + 7);
    static ArrayList<Integer> l;

    static int f(int idx, int b) {
        if(idx == l.size())
            return 1;
        if(dp[idx][b] != -1)
            return dp[idx][b];
        long ret = f(idx + 1, b + l.get(idx));
        if(b > 0)
            ret += f(idx, b - 1);
        return dp[idx][b] = (int) (ret % M);
    }

    public static void main(String[] args) throws IOException{
	    Scanner sc = new Scanner();
	    N = sc.nextInt();
        int [] val = new int[N];
        for(int i = 0; i < N; ++i)
            if(sc.next().charAt(0) == 's')
                val[i] = 0;
            else
                val[i] = 1;
        l = new ArrayList<Integer>();
        l.add(val[0]);

        for(int i = 1; i < N; ++i)
            if(val[i] == val[i - 1] && val[i] == 1) {
                int prev = l.get(l.size() - 1);
                l.set(l.size() - 1, ++prev);
            } else if(val[i - 1] == 0){
                l.add(val[i]);
            }

//        System.out.println(l);
        dp = new int[l.size() + 1][N + 1];
        for(int i = 0; i <= l.size(); ++i)
            Arrays.fill(dp[i], -1);
        System.out.println(f(0, 0));

    }


    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

    }
}
