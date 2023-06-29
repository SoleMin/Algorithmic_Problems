import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author dy
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long N = in.nextLong();
        int K = in.nextInt();
        long pipes = 1;
        if(N == 1){
            out.println(0);return;
        }
        long left = 0, right = K - 1, find = -1;
        while (left <= right){
            long mid = (left + right) / 2;
            if(mid * mid + (1 - 2 * K) * mid + 2 * (N - 1) <= 0){
                find = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        out.println(find);
    }
}
