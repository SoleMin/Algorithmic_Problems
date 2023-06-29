import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static Scanner sc;
    static PrintWriter out;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        if (true) {
            t = sc.nextInt();
        }
        for(int i=0; i<t; i++) {
            new Main().solve();
        }
        out.flush();
    }

    public void solve() {
        long n = sc.nextInt();
        if(n % 2 == 1) {
            out.println("NO");
            return;
        }
        for(long i=1; i*i*2 <= n; i++) {
            if(i * i * 2 == n || i * i * 4 == n) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");

    }

}
