import java.io.PrintWriter;
import java.util.Scanner;


public class HexadecimalTheorem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		out.printf("%d %d %d%n", 0, 0, n);
		out.flush();
	}

}
