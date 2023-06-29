
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.lang.Character.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class A {
    public void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++)
            ss[i] = s.substring(i);
        sort(ss);
        int res = 0;
        for (int i = 1; i < n; i++)
            res = max(res, count(ss[i - 1], ss[i]));
        System.out.println(res);
    }

    int count(String s, String t) {
        int ret = 0;
        for (int i = 0; i < min(s.length(), t.length()); i++)
            if (s.charAt(i) != t.charAt(i))
                return ret;
            else
                ret++;
        return ret;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String... args) {
        new A().run();
    }
}
