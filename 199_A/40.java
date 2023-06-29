import java.io.*;
import java.util.*;


public class A {
    public static void main(String[] args) throws Exception {
        new A().solve();
    }
    void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        if (n == 0) {
            System.out.println("0 0 0");
            return;
        }
        int p2 = 0;
        int p1 = 1;
        while (true) {
            int now = p2 + p1;
            if (n == now) {
                System.out.println("0 " + p1 + " " + p2);
                return;
            } else {
                p2 = p1;
                p1 = now;
            }
        }
    }
}
