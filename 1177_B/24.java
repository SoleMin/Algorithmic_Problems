import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class P1177A {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(r.readLine());
        if (n < 10) {
            System.out.print(n);
            return;
        }
        
        int len = 1;
        long edge = 10;
        long prev = 0;
        long prepow = 0;
        while (edge - 1 < n) {
            prepow = (long)Math.pow(10, len);
            long pow = prepow * 10;
            prev = edge;
            edge = edge + (pow - prepow) * (len + 1);
            len += 1;
        }

        long b = n - prev;
        long c = b / len;
        int rem = (int)(b % len);
        String s = Long.toString(prepow + c).charAt(rem) + "";

        System.out.print(s);
    }
}
