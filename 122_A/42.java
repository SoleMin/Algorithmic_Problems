import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Саша
 * Date: 08.08.12
 * Time: 14:12
 */
public class LuckyDivision {

    public final String check (String s) {
        String result = "NO";
        StringTokenizer stringTokenizer = new StringTokenizer(s, "47");
        if(!stringTokenizer.hasMoreTokens()) return "YES";
        int S = Integer.parseInt(s);
        generateSimpleAndDivide(S, 4, 4, 7);
        generateSimpleAndDivide(S, 7, 4, 7);
        if(lucky) return "YES";
        return result;
    }
    public static final void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(new LuckyDivision().check(scanner.next()));
    }

    public void generateSimpleAndDivide(int divided, int n, int n1, int n2) {
        if(lucky || n >= divided) return;
        if(divided % n == 0) lucky = true;
        generateSimpleAndDivide(divided, Integer.parseInt(n + "" + n1), n1, n2);
        generateSimpleAndDivide(divided, Integer.parseInt(n + "" + n2), n1, n2);
    }
    private boolean lucky = false;
}
