//package codeforces.br17;

import java.io.*;
import java.text.DecimalFormat;

public class ProblemA {
    public void solve() {
        boolean oj = true;

        try {
            Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("A.in");
            Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("A.out");
            BufferedReader br = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(writer);

            MyTokenizer tok = new MyTokenizer(br.readLine());

            int n = (int)tok.getNum();
            int k = (int)tok.getNum();

            boolean[] isPrime = new boolean[n + 1];
            for(int i=1;i<=n;i++)
                isPrime[i] = true;
            isPrime[1] = false;
            isPrime[2] = true;
            for(int i=2;i*i<=n;i++)
                for(int j=2*i;j<=n;j+=i)
                    isPrime[j] = false;
            int[] primes = new int[n];
            int cur = 0;
            for(int i=2;i<=n;i++)
                if (isPrime[i]) {
                    primes[cur] = i;
                    cur++;
                }
            int count = 0;
            for(int i=0;i<cur-1;i++) {
                if (primes[i] + primes[i+1] + 1 <= n && isPrime[primes[i] + primes[i+1] + 1])
                    count++;
            }
            if (count >= k)
                out.printf("YES");
            else
                out.printf("NO");

            
            br.close();
            out.close();
            reader.close();
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

    public static void main(String[] args) {
        ProblemA f = new ProblemA();
        f.solve();
    }

    private class MyTokenizer {
        private String s;
        private int cur;

        public MyTokenizer(String s) {
            this.s = s;
            cur = 0;
        }

        public void skip() {
            while (cur < s.length() && (s.charAt(cur) == ' ' || s.charAt(cur) == '\n')) {
                cur++;
            }
        }

        public double getNum() {
            skip();
            String snum = "";
            while (cur < s.length() && (s.charAt(cur) >= '0' && s.charAt(cur) <= '9' || s.charAt(cur) == '.')) {
                snum += s.charAt(cur);
                cur++;
            }
            return Double.valueOf(snum);
        }

        public String getString() {
            skip();
            String s2 = "";
            while (cur < s.length() && (s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z')) {
                s2 += s.charAt(cur);
                cur++;
            }
            return s2;
        }

        public char getCurrentChar() throws Exception {
            if (cur < s.length())
                return s.charAt(cur);
            else
                throw new Exception("Current character out of string length");
        }

        public void moveNextChar() {
            if (cur < s.length())
                cur++;
        }

        public boolean isFinished() {
            return cur >= s.length();
        }
    }
}
