import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main implements Runnable {

    PrintWriter out;
    Scanner in;

    public static void main(String[] args) throws IOException {
        new Thread(new Main()).start();
    }

    public void run() {
        try {
            out = new PrintWriter(new BufferedOutputStream(System.out));
            in = new Scanner(System.in);
            solve();
            out.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        if (n >= 0) {
            out.println(n);
        } else {
            String s = String.valueOf(n);
            int l = s.length();
            String s1 = s.substring(0, l - 2);
            if (s.charAt(l - 1) > s.charAt(l - 2)) {
                s1 += s.charAt(l - 2);
            } else {
                s1 += s.charAt(l - 1);
            }
            out.println(Integer.parseInt(s1));
        }
    }
}