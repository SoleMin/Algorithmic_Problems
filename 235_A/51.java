import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author BSRK Aditya (bsrkaditya@gmail.com)
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
        long n = in.nextLong();

        if(n == 1) out.println("1");
        else if(n == 2) out.println("2");
        else if(n%2 == 1) out.println(n*(n-1)*(n-2));
        else if(n%6 == 0) out.println((n-1)*(n-2)*(n-3));
        else out.println(n*(n-1)*(n-3));
	}
}

