/*
bts songs to dance to:
I need U
Run
ON
Filter
I'm fine
 */
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

import java.util.*;
import java.io.*;

public class x1517D2
{
    static final int INF = Integer.MAX_VALUE/3;
    public static void main(String hi[]) throws Exception
    {
        FastScanner infile = new FastScanner();
        int N = infile.nextInt();
        int M = infile.nextInt();
        int K = infile.nextInt();
        int[][] weights1 = new int[N][M-1];
        for(int r=0; r < N; r++)
            weights1[r] = infile.nextInts(M-1);
        int[][] weights2 = new int[N-1][M];
        for(int r=0; r < N-1; r++)
            weights2[r] = infile.nextInts(M);
        //all are -1 if K is odd
        int[][] res = new int[N][M];
        if(K%2 == 1)
        {
            StringBuilder sb = new StringBuilder();
            for(int r=0; r < N; r++)
            {
                for(int c=0; c < M; c++)
                    sb.append("-1 ");
                sb.append("\n");
            }
            System.out.print(sb);
            return;
        }
        int[][] dp = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for(int k=0; k < K/2; k++)
        {
            int[][] next = new int[N][M];
            for(int r=0; r < N; r++)
                Arrays.fill(next[r], INF);
            for(int r=0; r < N; r++)
                for(int c=0; c < M; c++)
                {
                    if(r > 0)
                        next[r-1][c] = min(next[r-1][c], dp[r][c]+weights2[r-1][c]);
                    if(r+1 < N)
                        next[r+1][c] = min(next[r+1][c], dp[r][c]+weights2[r][c]);
                    if(c > 0)
                        next[r][c-1] = min(next[r][c-1], dp[r][c]+weights1[r][c-1]);
                    if(c+1 < M)
                        next[r][c+1] = min(next[r][c+1], dp[r][c]+weights1[r][c]);
                }
            dp = next;
        }
        for(int r=0; r < N; r++)
        {
            for(int x: dp[r])
                sb.append((2*x)+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
class FastScanner
{
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }

    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}
