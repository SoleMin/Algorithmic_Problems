//package codeforces.br23;

import java.io.*;

/**
 * User: Kandy
 * Date: 12.07.2010
 * Time: 21:51:52
 */
public class ProblemA {
    public void solve() {
        boolean oj = true;

        try {
            Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("A.in");
            Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("A.out");
            BufferedReader br = new BufferedReader(reader);
            StreamTokenizer st = new StreamTokenizer(reader);
            PrintWriter out = new PrintWriter(writer);

            String s = br.readLine();
            int n = s.length();

            int max = 0;
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++) {
                    int len = j - i + 1;
                    int count = 0;
                    for (int k = 0; k < n - len + 1; k++) {
                        boolean eq = true;
                        for(int l = 0; l < len;l++) {
                            if (s.charAt(i + l) != s.charAt(k + l)) {
                                eq = false;
                                break;
                            }
                        }
                        if (eq) {
                            count++;
                        }
                    }
                    if (count >= 2 && len > max) {
                        max = len;
                    }
                }

            out.printf("%d", max);

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
            while (cur < s.length() && (s.charAt(cur) >= '0' && s.charAt(cur) <= '9' || s.charAt(cur) == '.' || s.charAt(cur) == '-')) {
                snum += s.charAt(cur);
                cur++;
            }
            return Double.valueOf(snum);
        }

        public String getString() {
            skip();
            String s2 = "";
            while (cur < s.length() && (((s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z')) || ((s.charAt(cur) >= 'A' && s.charAt(cur) <= 'Z')))) {
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
