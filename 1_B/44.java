import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem solution template.
 * @author Andrew Porokhin, andrew.porokhin@gmail.com
 */
public class Problem01B implements Runnable {
    static final long[] x10 = new long[] { 1, 26, 26*26, 26*26*26, 26*26*26*26, 26*26*26*26*26, 26*26*26*26*26*26}; 
    void solve() throws NumberFormatException, IOException {
        // TODO: Write your code here ...
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            String t = nextToken().toUpperCase();
            StringBuffer rowString = new StringBuffer(t.length());
            StringBuffer numb1 = new StringBuffer(t.length());
            StringBuffer numb2 = new StringBuffer(t.length());
            int stage = 0;
            for (int j = 0; j < t.length(); j++) {;
                char charAt = t.charAt(j);
                if (charAt >= 'A') {
                    if (stage == 0) { 
                        rowString.append(charAt);
                    } else {
                        stage++;
                    }
                } else {
                    if (stage == 0 || stage == 2) 
                        stage++;
                    switch (stage) {
                    case 1: numb1.append(charAt); break;
                    case 3: numb2.append(charAt); break;
                    }
                }
            }
            
            if (stage == 1) {
                long result = convertString(rowString);
                System.out.print("R");
                System.out.print(numb1.toString());
                System.out.print("C");
                System.out.println(result);
            } else {
                StringBuffer tmp = convertNumber(Long.parseLong(numb2.toString()));
                System.out.print(tmp.toString());
                System.out.println(numb1.toString());
            }
        }
    }
    
    public StringBuffer convertNumber(long n) {
        StringBuffer sb2 = new StringBuffer();
        long nmod26 = n % 26;
        long ndiv26 = n / 26;
        while (ndiv26 > 0 || nmod26 > 0) {
            long tmp = 0;
            if (nmod26 > 0) {
                sb2.append((char) ('A' + nmod26 - 1));
                tmp = ndiv26;
            } else {
                sb2.append('Z');
                tmp = ndiv26 - 1;
            }
            nmod26 = tmp % 26;
            ndiv26 = tmp / 26;
        }
        
        return sb2.reverse();
    }
    
    public long convertString(StringBuffer sb) {
        long result = 0;
        for (int i = 0; i < sb.length(); i++) {
            long l = (sb.charAt(i) - 'A' + 1) * x10[sb.length() - i - 1];
            result += l;
        }
        return result;
    }
    
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;
    
    public static void main(String[] args) {
        new Problem01B().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
        } catch (Exception e) {
            System.exit(9000);
        } finally {
            out.flush();
            out.close();
        }
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }
}
