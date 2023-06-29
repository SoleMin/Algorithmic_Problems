import java.io.*;
import java.text.DecimalFormat;

public class ProblemD {

    private double survive(int round, int set) {
        if (sur[round][set] >= 0)
            return sur[round][set];
        double res = 0.0;
        int count = 0;
        for(int i=0;i<n;i++) {

            if ((set & (1 << i)) > 0) {
                double res2 = 0.0;
                for(int j=0;j<n;j++)
                    if ((set & (1 << j)) == 0) {
                        res2 += survive(round - 1, set + (1 << j)) * a[i][j];
                        count++;
                    }
                res += res2;
            }

        }
        count = (n-round+1) * (n - round) / 2;
        sur[round][set] = res / count;
        return sur[round][set];
    }

    int n;
    double[][] a, sur;

    public void solve() {
        boolean oj = true;

        try {
            Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("inputD.txt");
            Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("outputD.txt");
            BufferedReader br = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(writer);

            MyTokenizer tok = new MyTokenizer(br.readLine());
            n = (int)tok.getNum();
            a = new double[n][n];

            int all = (1 << n) - 1;

            sur = new double[n][all + 1];
            for(int i=0;i<n;i++) {
                tok = new MyTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    a[i][j] = tok.getNum();
                }
                for(int j=0;j<=all;j++)
                    sur[i][j] = -1;
            }

            DecimalFormat format = new DecimalFormat("0.000000");

            sur[0][all] = 1;
            double[] res = new double[n];
            for(int i=0;i<n;i++) {
                res[i] = survive(n - 1, 1 << i);
                String sres = format.format(res[i]).replace(',','.');
                out.printf("%s ", sres);
            }

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
        ProblemD f = new ProblemD();
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
