import java.io.*;
import java.util.*;

public class Main {
//	static Scanner in;
	static PrintWriter out;
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
//		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = new Integer(in.readLine());

		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			int x = 0;
			while (s.charAt(x) - 'A' >= 0 && s.charAt(x) - 'Z' <= 0) x++;
			int y = s.length() - 1;
			while (s.charAt(y) - '0' >= 0 && s.charAt(y) - '9' <= 0) y--;

			if (x > y) {
				int k = 1;
				int a = 1;
				for (int j = 1; j < x; j++) {
					k *= 26;
					a += k;
				}
				for (int j = 0; j < x; j++) {
					a += k*(s.charAt(j) - 'A');
					k /= 26;
				}
				int b = Integer.parseInt(s.substring(x));
				out.println("R" + b + "C" + a);
			} else {
				while (s.charAt(x) - '0' >= 0 && s.charAt(x) - '9' <= 0) x++;
				int b = Integer.parseInt(s.substring(1, x));
				int a = Integer.parseInt(s.substring(x + 1));
				int num = 0;
				int k = 1;
				while (a >= k) {
					a -= k;
					k *= 26;
				}
				k /= 26;
				while (k > 0) {	
					out.print((char)('A' + (a/k)));
					a %= k;
					k /= 26;
				}
				out.println(b);
			}
		}
		out.close();
	}
}