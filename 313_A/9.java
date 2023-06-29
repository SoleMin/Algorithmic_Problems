import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class A {

    public void processInput() throws IOException {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long res = go(n);

        System.out.printf(Locale.ENGLISH, "%d\n", res);

        in.close();
    }

    public long go(long n) {

        long res = n;

        String str = String.valueOf(n);
        
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length() - 1);
        if (sb.length() > 0 && !sb.toString().equals("-")) {
            res = Math.max(res, Long.valueOf(sb.toString()));
        }
        
        if (str.length() > 1) {
            if (str.charAt(str.length() - 2) != '-') {
                sb = new StringBuilder(str);
                sb.deleteCharAt(str.length() - 2);
                res = Math.max(res, Long.valueOf(sb.toString()));
            }
        }
        
        return res;
    }

    public static void main(String[] args) throws Exception {
        A a = new A();
        a.processInput();
    }
}