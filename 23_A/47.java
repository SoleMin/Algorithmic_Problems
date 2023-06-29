import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String ...args) throws Throwable {
        Scanner in = new Scanner(System.in);
        String init = in.nextLine();
        HashSet<String> h = new HashSet<String>();
        for (int len = init.length() - 1; len >= 1; --len)  {
            h.clear();
            for (int pos = 0; pos + len <= init.length(); ++pos) {
                String now = init.substring(pos, pos + len);
                if (h.contains(now)) {
                    System.out.println(len);
                    return;
                }
                h.add(now);
            }

        }

        System.out.println(0);
    }
}
        