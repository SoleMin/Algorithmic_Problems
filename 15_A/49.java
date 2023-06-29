import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Cottage implements Comparable<Cottage> {
        public int x;
        public double a;

        public Cottage(int x, int a) {
            this.x = x;
            this.a = a;
        }

        public int compareTo(Cottage c) {
            return x - c.x;
        }
    }

    static final double e = 1e-9;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int t = in.nextInt();
        Cottage[] cottages = new Cottage[n];

        for (int i = 0; i < n; i++)
            cottages[i] = new Cottage(in.nextInt(), in.nextInt());

        Arrays.sort(cottages);

        int ans = 2;

        for (int i = 1; i < cottages.length; i++) {
            double diff = cottages[i].x - cottages[i - 1].x - cottages[i - 1].a / 2 - cottages[i].a / 2;
            ans = Math.abs(diff - t) < e ? ans + 1 : diff - t < -e ? ans : ans + 2;
        }

        out.print(ans);
        out.close();
    }
}
