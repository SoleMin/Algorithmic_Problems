import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = in.nextLine();

        int ans = 0;

        outer: for (int i = s.length() - 1; i >= 1; i--)
            for (int j = 0; j < s.length() - i; j++) {
                String sub = s.substring(j, j + i);
                String str = s.substring(j + 1);

                if (str.contains(sub)) {
                    ans = i;
                    break outer;
                }
            }

        out.print(ans);
        out.close();
    }
}
