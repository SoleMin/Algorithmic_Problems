import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCount = in.nextInt();
        for (int test = 0; test < testCount; test++) {
            String src = in.next();
            if (src.matches("^R\\d+C\\d+$")) {
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(src);
                m.find();
                int r = Integer.parseInt(m.group(0));
                m.find();
                int c = Integer.parseInt(m.group(0));
                System.out.println(toBase26(c) + r);
            } else {
                Pattern p = Pattern.compile("[A-Z]+");
                Matcher m = p.matcher(src);
                m.find();
                String c = m.group(0);
                p = Pattern.compile("\\d+");
                m = p.matcher(src);
                m.find();
                int r = Integer.parseInt(m.group(0));
                System.out.println("R" + r + "C" + toBase10(c));
            }
        }
    }
    private static String toBase26(int n) {
        String res = "";
        do {
            n -= 1;
            res = (char)('A' + (n % 26)) + res;
            n /= 26;            
        } while (n > 0);
        return res;
    }
    private static int toBase10(String x) {
        int n = 0;
        char[] digits = x.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            n *= 26;
            n += digits[i] - 'A' + 1;
        }
        return n;
    }
}

