import java.io.*;
import java.util.*;

public class Solution {

    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter (new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public void solve() throws Exception {
        int n=nextInt();
        String s=next();
        String ss = s + s;
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'T') {
                t++;
            }
        }
        if (t == 1 || t == n - 1) {
            out.println(0);
        } else {
            int sum = 0;
            for (int i = 0; i < t; i++) {
                if (s.charAt(i) == 'T') {
                    sum++;
                }
            }
            
            int max = sum;
            for (int i = 0; i < s.length(); i++) {
                if (ss.charAt(i) == 'T') {
                    if (ss.charAt(i + t) == 'H') {
                        sum--;
                    }
                } else {
                    if (ss.charAt(i + t) == 'T') {
                        sum++;
                        max = Math.max(max, sum);
                    }
                }
            }
           out.println(t - max);
        }
    }

}
