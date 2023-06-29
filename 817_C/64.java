import java.io.*;
import java.util.*;

public class ReallyBigNumbers817c {

    static long sd(String s) {
        long c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += s.charAt(i);
        }
        return c - s.length() * 0x30;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        long i = (s / 10 + 1) * 10;
        if (n < 10 || n - sd(n + "") < s) {
            System.out.println(0);
            return;
        }
        while (!(i - sd(""+i) >= s)) {
            i += 10;
        }
        System.out.println(n - i + 1);
    }
}
