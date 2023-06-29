import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P023A {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        String string = inScanner.next();
        int n = string.length();
        for (int l = n - 1; l > 0; l--) {
            Set<String> seen = new HashSet<String>();
            for (int i = 0; i < n - l + 1; i++) {
                String subString = string.substring(i, i + l);
                if (seen.contains(subString)) {
                    System.out.println(l);
                    return;
                }
                seen.add(subString);
            }
        }
        System.out.println("0");
    }
}
