import java.util.*;
public class Main {
    public static boolean flag = false;
    public static int n, k;
    public static void generate(String s) {
        if (s.length() < n) {
            generate(s + "0");
            generate(s + "1");
        } else {
            if (get(s) == k) {
                System.out.println(s);
            }
        }
    }
    public static int get(String s) {
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (unique(s.substring(j, j + i), s)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static boolean unique(String s, String t) {
        int cnt = 0;
        for (int i = 0; i <= t.length() - s.length(); i++) {
            if (t.substring(i, i + s.length()).equals(s)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        int diff = (n - k) / 2;
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % (diff + 1) == 0) {
                sub.append('1');
            } else {
                sub.append('0');
            }
        }
        System.out.println(sub.toString());
    }
}