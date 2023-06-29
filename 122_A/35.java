import java.io.PrintWriter;
import java.util.Scanner;

public class n122A {
    Scanner in;
    PrintWriter out;

    void solve() {
        int n = in.nextInt();
        boolean good = false;
        if (n % 4 == 0) {
            good = true;
        }
        if (n % 7 == 0) {
            good = true;
        }
        if (n % 44 == 0) {
            good = true;
        }
        if (n % 47 == 0) {
            good = true;
        }
        if (n % 74 == 0) {
            good = true;
        }
        if (n % 77 == 0) {
            good = true;
        }
        if (n % 444 == 0) {
            good = true;
        }
        if (n % 447 == 0) {
            good = true;
        }
        if (n % 474 == 0) {
            good = true;
        }
        if (n % 477 == 0) {
            good = true;
        }
        if (n % 744 == 0) {
            good = true;
        }
        if (n % 747 == 0) {
            good = true;
        }
        if (n % 774 == 0) {
            good = true;
        }
        if (n % 777 == 0) {
            good = true;
        }
        if (good) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }

    void run() {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        try {
            solve();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new n122A().run();

    }

}
