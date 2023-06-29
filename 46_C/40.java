
import java.util.Scanner;

/**
 *
 * @author igor_kz
 */
public class C46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        String s = in.next();
        int cH = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++)
            if (s.charAt(i) == 'H') cH++;
        String ss = "";
        for (int i = 0 ; i < cH ; i++)
            ss += "H";
        for (int i = 0 ; i < n - cH ; i++)
            ss += "T";
        int res = Integer.MAX_VALUE;
        for (int i = 0 ; i < n ; i++) {
            int cur = countDifference(ss , s);
            res = Math.min(res , cur);
            ss = ss.substring(1) + ss.charAt(0);
        }
        System.out.println(res);
    }

    public static int countDifference(String ss, String s) {
        int cnt = 0;
        for (int i = 0 ; i < ss.length() ; i++)
            if (ss.charAt(i) != s.charAt(i)) cnt++;
        return cnt / 2;
    }
}
