import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class a {
    public static class Pair implements Comparable<Pair> {
        int f, s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            return s - o.s;
        }

    };

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s[] = in.readLine().split(" ");
        long r = Long.parseLong(s[0]);
        long l = Long.parseLong(s[1]);
        if (r % 2 == 0) {
            if (l - r+1 < 3) {
                out.println(-1);
            } else {
                out.println(r + " " + (r + 1) + " " + (r + 2));
            }
        } else {
            if (l - r+1 < 4) {
                out.println(-1);
            } else {
                out.println((r + 1) + " " + (r + 2) + " " + (r + 3));
            }

        }
        out.close();

    }

}