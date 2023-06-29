//package codeforces.br25;

import java.io.*;
import java.math.*;
import java.util.*;

public class ProblemA {
    public void solve() {
        boolean oj = true;

        try {
            Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("A.in");
            Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("A.out");
            BufferedReader br = new BufferedReader(reader);
            StreamTokenizer st = new StreamTokenizer(reader);
            PrintWriter out = new PrintWriter(writer);

            int n = Integer.valueOf(br.readLine());
            String s = br.readLine();
            MyTokenizer tok = new MyTokenizer(s);
            int[] a = new int[2];
            int[] ind = new int[2];
            int[] c = new int[2];

            for(int i=0;i<n;i++) {
                int p = (int)tok.getNum();
                c[p%2]++;
                a[p%2] = p;
                ind[p%2] = i;
            }
            int b = ind[0];
            if (c[0] > c[1])
                b = ind[1];
            out.printf("%d", b + 1);

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
