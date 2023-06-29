import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        team[] t = new team[n];
        for (int i = 0; i < n; i++)
            t[i] = new team(in.nextInt(), in.nextInt());
        Arrays.sort(t);
        int cnt = 0;
        team tm = t[t.length - k];
        for (int i = t.length - 1; i >= 0; i--)
            if (tm.equal(t[i]))
                cnt++;
        System.out.println(cnt);
    }

    static class team implements Comparable<team> {
        int p, t;

        public team(int pp, int tt) {
            p = pp;
            t = tt;
        }

        @Override
        public int compareTo(team o) {
            if (p == o.p)
                return o.t - t;
            return p - o.p;
        }

        public boolean equal(team a) {
            return a.p == p && a.t == t;
        }
    }
}