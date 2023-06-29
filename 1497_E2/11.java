//stan hu tao
//join nct ridin by first year culture reps
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class x1497E
{
    static final int MAX = 10000000;
    public static void main(String hi[]) throws Exception
    {
        int[] prime = new int[MAX+1];
        for(int d=2; d <= MAX; d++)
            if(prime[d] == 0)
                for(int v=d; v <= MAX; v+=d)
                    if(prime[v] == 0)
                        prime[v] = d;
        FastScanner infile = new FastScanner();
        int T = infile.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[MAX+1];
        int[] ts = new int[MAX+1];
        int time = 0;
        while(T-->0)
        {
            int N = infile.nextInt();
            int K = infile.nextInt();
            int[] arr = infile.nextInts(N);
            for(int i=0; i < N; i++)
            {
                int key = 1;
                while(arr[i] > 1)
                {
                    int p = prime[arr[i]];
                    int cnt = 0;
                    while(arr[i]%p == 0)
                    {
                        arr[i] /= p;
                        cnt ^= 1;
                    }
                    if(cnt == 1)
                        key *= p;
                }
                arr[i] = key;
            }
            int[][] right = new int[N][K+1];
            for(int k=0; k <= K; k++)
            {
                int dex = 0;
                int cnt = 0;
                for(int i=0; i < N; i++)
                {
                    while(dex < N && cnt <= k)
                    {
                        if(ts[arr[dex]] == time && freq[arr[dex]] >= 1 && cnt+1 > k)
                            break;
                        if(ts[arr[dex]] == time && freq[arr[dex]] >= 1)
                            cnt++;
                        if(ts[arr[dex]] < time)
                        {
                            ts[arr[dex]] = time;
                            freq[arr[dex]] = 0;
                        }
                        freq[arr[dex]]++;
                        dex++;
                    }
                    right[i][k] = dex;
                    if(freq[arr[i]] >= 2)
                        cnt--;
                    freq[arr[i]]--;
                }
                time++;
            }
            int[][] dp = new int[N+1][K+1];
            for(int i=1; i <= N; i++)
                Arrays.fill(dp[i], N);
            for(int i=0; i < N; i++)
                for(int a=0; a <= K; a++)
                {
                    dp[i+1][a] = min(dp[i+1][a], dp[i][a]+1);
                    for(int b=0; b <= K-a; b++)
                        dp[right[i][b]][a+b] = min(dp[right[i][b]][a+b], dp[i][a]+1);
                }
            int res = dp[N][0];
            for(int k=1; k <= K; k++)
                res = min(res, dp[N][k]);
            sb.append(res+"\n");
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