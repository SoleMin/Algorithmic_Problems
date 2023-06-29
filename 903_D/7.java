//Educational Codeforces Round 34
import java.io.*;
import java.util.*;
import java.math.*;

public class TaskD {

    public static void main (String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>(n);

        BigInteger s = new BigInteger(""+a[0]);
        BigInteger x = new BigInteger("0");
        h.put(a[0], 1);
        for (int i = 1; i < n; i++) {                        
            x = x.add(new BigInteger(""+(((long)i)*((long)a[i]))));
            x = x.subtract(s);
            s = s.add(new BigInteger(""+a[i]));
            Integer q = null;
            q = h.get(a[i]-1);            
            if (q != null) {
                x = x.subtract(new BigInteger(""+q));
            }
            q = h.get(a[i]+1);            
            if (q != null) {
                x = x.add(new BigInteger(""+q));
            }
            q = h.get(a[i]);            
            if (q != null) {
                h.put(a[i], q + 1);
            } else {
                h.put(a[i], 1);
            }
        }

        pw.println(x);

        pw.close();
    }

    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;
        FastScanner(InputStream i) {
            reader = new BufferedReader(new InputStreamReader(i));
            tokenizer = new StringTokenizer("");
        }
        String next() throws IOException {
            while(!tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}