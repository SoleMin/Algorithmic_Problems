import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class solver {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    
    public static void main(String[] args) {
        new solver().solve();
    }
    
    public void solve() {
    
        int n = in.nextInt();
        int[]tab = new int[n];
        
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            tab[i] = in.nextInt();
            sum += tab[i];
        }
        
        Arrays.sort(tab);
        int v1 = 0;
        int count = 0;
        
        for (int i = tab.length - 1; i >= 0; i--) {
            v1 += tab[i];
            count++;
            if (v1 > getSum(i, tab)) {
                break;
            }
        }
        
        out.println(count);
        
        in.close();
        out.close();
    }
    
    public int getSum(int index, int[]tab) {
        int sum = 0;
        for (int i = 0; i < index; i++) sum += tab[i];
        return sum;
    }
    
    public int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }
}


class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                System.err.println(e);
                return "";
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

    float nextFloat() {
        return Float.parseFloat(next());
    }

    BigInteger nextBigInt() {
        return new BigInteger(next());
    }

    void close() {
        try {
            br.close();
        } catch (IOException e) {
        }
    }
}