import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class Main {

    private void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        final int[] p = new int[n];
        final int[] t = new int[n];
        for(int i =0 ; i < n; ++i) {
            p[i] = in.nextInt();
            t[i] = in.nextInt();
        }
        Integer[] ord = new Integer[n];
        for(int i = 0; i < n; ++i)
            ord[i] = i;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n - 1; ++j) {
                if (Less(ord[j], ord[j + 1], p, t)) {
                    Integer tx = ord[j];
                    ord[j] = ord[j + 1];
                    ord[j + 1] = tx;
                }
            }
        }
        
        
        
        for(int i = 0, j = 0; i < n; i = j) {
            for(j = i; j < n && p[ord[i]] == p[ord[j]] && t[ord[i]] == t[ord[j]]; ++j) ;
            int first = i+1;
            int second = j;
            if (first <= k && k <= second) {
                out.print(j - i);
                return ;
            }
        }
        out.print(0);
    }
    private boolean Less(Integer i, Integer j, int[] p, int[] t) {
        return p[i] < p[j] || p[i] == p[j] && t[i] > t[j];
    }
    private void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Main().run();
    }
    FastScanner in;
    PrintWriter out;
    class FastScanner {
        public BufferedReader reader;
        private StringTokenizer tokenizer;
        public FastScanner(String file) {
            try {
                reader = new BufferedReader(new FileReader(new File(file)));
                tokenizer = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        public FastScanner() {
            try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                tokenizer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(nextToken());
        }
        long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
}
