import java.util.*;
import java.io.*;

public class A0023 {

    public static void main(String args[]) throws Exception {
        new A0023();
    }

    A0023() throws Exception {
        PandaScanner sc = null;
        PrintWriter out = null;
        try {
            sc = new PandaScanner(System.in);
            out = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }

        String s = sc.next();
        int i = s.length() - 1;
        Test: for (; i > 0; i--) {
            HashSet<String> set = new HashSet<String>();
            for (int j = 0; j + i <= s.length(); j++) {
                String ss = s.substring(j, j + i);
                if (set.contains(ss)) {
                    break Test;
                }
                set.add(ss);
            }
        }
        out.println(i);

        out.close();
        System.exit(0);
    }


    //The PandaScanner class, for Panda fast scanning!
    public class PandaScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream in;

        PandaScanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(this.in = in));
        }

        public String next() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
                return next();
            }
            return st.nextToken();
        }

        public boolean hasNext() throws Exception {
            return (st != null && st.hasMoreTokens()) || in.available() > 0;
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
