import java.util.*;
import java.io.*;

public class _817C {

    static long sum = 0;

    static long BSearch2(long st, long end, long lim) {

        if (st > end) return 0;
        long mid = (st + end) >> 1;
        if (mid - sumDigit(mid) >= lim) {
            sum = mid;
            return BSearch2(st, mid - 1, lim);
        }
        if (mid - sumDigit(mid) < lim)
            return BSearch2(mid + 1, end, lim);
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long s = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        BSearch2(1, s, n);
        if (sum == 0) System.out.println("0");
        else System.out.println(s - sum + 1);

    }

    static long sumDigit(long z) {
        String s = "" + z;
        int c = 0;
        for (int i = 0; i < s.length(); i++) c += s.charAt(i);
        return c - s.length() * 0x30;
    }
}