import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.math.*;

public class Main {
    
    void run() throws IOException {
        String s = token();
        HashSet <String> h;
        int n = s.length();
        int r = 0;
        loop: for (int i = 1; i <= n; i++) {
            h = new HashSet();
            for (int j = 0; j < n - i + 1; j++) {
                String t = s.substring(j, j + i);
                if (h.contains(t)) {
                    r = i;
                    continue loop;
                } else {
                    h.add(t);
                }
            }
        }
        System.out.println(r);
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        //final String FILENAME = "dvd";
        //in = new BufferedReader(new FileReader(new File(FILENAME + ".in")));
        //out = new PrintWriter(new File(FILENAME + ".out"));
        in = new BufferedReader(new InputStreamReader(System.in));
        //in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        st = new StringTokenizer(" ");
        new Main().run();
        out.close();
    }

    static BufferedReader in;
    //static Scanner in;
    static PrintWriter out;
    static StringTokenizer st;

    String token() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nint() throws IOException {
        return Integer.parseInt(token());
    }

    long nlong() throws IOException {
        return Long.parseLong(token());
    }

    double ndouble() throws IOException {
        return Double.parseDouble(token());
    }
}