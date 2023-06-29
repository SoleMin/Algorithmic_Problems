import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int balance = in.nextInt();
        if (balance >= 0) {
            out.println(balance);
            return;
        }

        balance = -balance;
        int a = balance / 100;

        int b = Math.min(balance % 10, (balance / 10) % 10);

        balance = -(a * 10 + b);

        out.println(balance);
    }
}

