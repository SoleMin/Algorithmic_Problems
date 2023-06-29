import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.StringTokenizer;


public class Solution {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                new Solution();
            }
        }).start();
    }

    Solution() {
        String data = "2\nR1C18\nR1";
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new StringReader(data));
        try {
            int n = Integer.parseInt(in.readLine());
            int[] res = new int[2];
            for (int i = 0; i < n; i++) {
                String s = in.readLine();
                if (isSecondType(s, res)) {
                    pw.println(toFirstType(res));
                } else {
                    pw.println(toSecondType(s));
                }
            }
        } catch (IOException e) {
        } finally {
            pw.flush();
            pw.close();
        }
    }

    private String toSecondType(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') break;
        }
        String first = s.substring(0, i);
        String second = s.substring(i, s.length());
        StringBuilder sb = new StringBuilder();
        sb.append("R");
        sb.append(second);
        sb.append("C");
        sb.append(stringToNum(first));
        return sb.toString();
    }

    private int stringToNum(String first) {
        int k = 0;
        int res = 0;
        int p = 1;
        for (int i = first.length() - 1; i >= 0; i--) {
            int v = first.charAt(i) - 'A' + k;
            k = 1;
            res += p * v;
            p *= 26;
        }
        return res + 1;
    }

    private String toFirstType(int[] res) {
        StringBuilder sb = new StringBuilder();
        sb.append(numToString(res[1]));
        sb.append(res[0]);
        return sb.toString();
    }

    private String numToString(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--;
            char c = (char) (num % 26 + 'A');
            sb.append(c);
            num /= 26;
        }
        return sb.reverse().toString();
    }

    private boolean isSecondType(String s, int[] res) {
        try {
            return doIsSecondType(s, res);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean doIsSecondType(String s, int[] res) {
        StringTokenizer st = new StringTokenizer(s, "RC", true);
        String token = st.nextToken();
        if (!token.equals("R")) return false;
        token = st.nextToken();
        if (!isDigit(token)) return false;
        res[0] = Integer.parseInt(token);
        token = st.nextToken();
        if (!token.equals("C")) return false;
        token = st.nextToken();
        if (!isDigit(token)) return false;
        res[1] = Integer.parseInt(token);
        return true;
    }

    private boolean isDigit(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) < '0' || token.charAt(i) > '9') return false;
        }
        return true;
    }
}
