

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    static InputStreamReader in = new InputStreamReader(System.in);
    static BufferedReader bf = new BufferedReader(in);
    static StreamTokenizer st = new StreamTokenizer(bf);
    static Scanner sc = new Scanner(System.in);

    static class Sort implements Comparable<Sort> {
        int x, a;

        public int compareTo(Sort arg0) {
            if (this.x > arg0.x)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        double t = nextInt();
        Sort[] p = new Sort[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Sort();
            p[i].x = nextInt();
            p[i].a = nextInt();
        }
        int ans = 2;
        Arrays.sort(p);
        for (int i = 1; i < p.length; i++) {
            double k = p[i].x - p[i].a / 2.0 - p[i - 1].x - p[i - 1].a / 2.0;
            if (t == k)
                ans++;
            else if (k > t)
                ans += 2;
        }
        System.out.println(ans);
    }

    private static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

}
