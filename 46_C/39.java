import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.math.*;

public class Main {        

    void run() throws IOException {
        int n = in.nextInt();
        char[] c = in.next().toCharArray();
        int[][] t = new int[n][n];
        int[][] h = new int[n][n];
        int allt = 0, allh = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'T') {
                allt++;
            } else {
                allh++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (c[i] == 'T') {
                t[i][i] = 1;
                h[i][i] = 0;
            } else {
                t[i][i] = 0;
                h[i][i] = 1;
            }
            for (int j = i + 1; j < n; j++) {
                if (c[j] == 'T') {
                    t[i][j] = t[i][j - 1] + 1;
                    h[i][j] = h[i][j - 1];
                } else {
                    h[i][j] = h[i][j - 1] + 1;
                    t[i][j] = t[i][j - 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            t[i][i - 1] = allt;
            h[i][i - 1] = allh;
            for (int j = 0; j < i - 1; j++) {
                t[i][j] = allt - t[j + 1][i - 1];
                h[i][j] = allh - h[j + 1][i - 1];
            }
        }
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {                
                if (h[i][j] == t[(j + 1) % n][(i - 1 + n) % n]) {
                    r = min(r, h[i][j]);
                }
                if (t[i][j] == h[(j + 1) % n][(i - 1 + n) % n]) {
                    r = min(r, t[i][j]);
                }
            }
        }
        out.println(r);
       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               out.print(t[i][j] + " ");
            }
            out.println();
        }
        out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(h[i][j] + " ");
            }
            out.println();
        }*/
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

    static PrintWriter out;
    static Scanner in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        //final String FILENAME = "jury"; in = new Scanner (new File (FILENAME + ".in")); out = new PrintWriter (new File(FILENAME + ".out"));
        in = new Scanner (System.in); out = new PrintWriter (System.out);
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
}