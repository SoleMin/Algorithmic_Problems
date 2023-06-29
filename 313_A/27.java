import java.io.PrintWriter;
import java.util.Scanner;

public class C186D2A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		if (n >= 0) {
			out.println(Math.abs(n));
		} else {
			out.println(Math.max(n/10, (n/100)*10 + n%10));
		}
		out.flush();
	}
}