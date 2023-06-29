import java.util.*;
import java.math.*;
import java.io.PrintStream;
import static java.lang.Math.*;

public class Task275A {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        long l = in.nextLong();
        long r = in.nextLong();

        if (l % 2 == 1) {
            l++;
        }

        if (r - l < 2) {
            out.print(-1);
        }
        else {
            out.print(l + " " + (l + 1) + " " + (l + 2));
        }
    }

}