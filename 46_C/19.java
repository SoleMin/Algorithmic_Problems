import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.math.*;

public class Main {        

    void run() throws IOException {
        int n = nint();
        char[] s = token().toCharArray();
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'H') h++;
        }
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = i; j < i + h; j++) {
                if (s[j % n] == 'T') t++;
            }
            r = min(r, t);
        }
        out.println(r);
    }

    class pair implements Comparable <pair> {
        int x, y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;            
        }
        public int compareTo (pair p) {
            if (x != p.x) {
                return x - p.x;
            } else {
                return y - p.y;
            }
        }
    }

//    static PrintWriter out;
  //  static Scanner in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        //final String FILENAME = "jury"; in = new Scanner (new File (FILENAME + ".in")); out = new PrintWriter (new File(FILENAME + ".out"));
    //    in = new Scanner (System.in); out = new PrintWriter (System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        st = new StringTokenizer(" ");
        new Main().run();
        /*out = new PrintWriter (System.out);
        final int NUMBER_OF_TESTS = 35;
        for (int i = 1; i <= NUMBER_OF_TESTS; i++) {
            Scanner test = new Scanner (new File ("tests/" + i + ".in"));
            Scanner right = new Scanner (new File ("tests/" + i + ".out"));
            String get_right = right.nextLine();
            String get_test = new Main().run(test);
            if (get_right.equals(get_test)) {
                out.println("Test #" + i + ": " + "OK!");                
            } else {
                out.println("Test #" + i + ": " + "ERROR!");
                out.println("Expected: " + get_right);
                out.println("Received: " + get_test);
                break;
            }
        }*/
        out.close();
    }

    static BufferedReader in;
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