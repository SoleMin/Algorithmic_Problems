
import com.sun.org.apache.xpath.internal.axes.SubContextList;
import java.util.Scanner;

/**
 *
 * @author Madi
 */
public class Round42CC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'H') {
                k++;
            }
        }

        s = s + s.substring(0, k);
        String ss = "";

        int max = 0;
        for (int i = 0; i < s.length() - k; i++) {
            ss = s.substring(i, i + k);
            int count = 0;
            for (int j = 0; j < ss.length(); j++) {
                if (ss.charAt(j) == 'H') {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        
        System.out.println(k - max);
    }
}
