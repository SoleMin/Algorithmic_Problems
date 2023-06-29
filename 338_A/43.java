import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C {
    private static BufferedReader in;
    private static StringTokenizer st;
    private static PrintWriter out;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int mod = (int) (1e9+9);
        int correct = n - n / k;
        int carry = n % k;
        long ans;
        if(correct >= m){
            ans = m;
        }else{
            m -= correct;
            int block = n / k;
            BigInteger pow = BigInteger.valueOf(2).modPow(BigInteger.valueOf(m + 1), BigInteger.valueOf(mod));
            ans = (pow.longValue() - 2 + mod) % mod;
            ans = (ans * (long) k) % mod;
            ans = (ans + (long)(block - m)* (long)(k-1) + carry) % mod;
        }
        System.out.println(ans);
        
    }

    static String next() throws IOException{
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    static int nextInt() throws NumberFormatException, IOException{
        return Integer.parseInt(next());
    }
    static long nextLong() throws NumberFormatException, IOException{
        return Long.parseLong(next());
    }
    
    static double nextDouble() throws NumberFormatException, IOException{
        return Double.parseDouble(next());
    }

}
