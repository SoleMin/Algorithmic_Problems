import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AndrewShmig
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
        String n = in.nextLine();

        int a = Integer.parseInt(n);
        int b = Integer.parseInt(n.substring(0, n.length() - 1));
        int c = Integer.parseInt(n.substring(0, n.length() - 2) + n.charAt(n.length() - 1));

        out.println(Math.max(a, Math.max(b, c)));
    }
}

