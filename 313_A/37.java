import java.io.*;
import java.util.*;
import java.math.*;

public class A {
    public static void main(String[] args) { 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        Application solver = new Application();
        solver.solve(System.in, out);

        out.close();
    }
}


class Application {
    int max(int a, int b) { return a > b ? a : b; }
    public void solve(InputStream in, PrintWriter out) {
        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        int n1 = n/10;
        int n2 = (n/100)*10+(n%10);
        int m = max(max(n1, n2), n);

        out.println(m);
    }
}
