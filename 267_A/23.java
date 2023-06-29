import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangeAddition {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		sc = new StringTokenizer(br.readLine());
		int tc = nxtInt();
		while (tc-- > 0) {
			int a = nxtInt();
			int b = nxtInt();
			int ans = 0;
			while (a != b) {
				if (a == 0 || b == 0)
					break;
				if (a > b) {
					int div = a / b;
					a -= b * div;
					ans += div;
				} else {
					int div = b / a;
					b -= a * div;
					ans += div;
				}
			}
			out.println(ans + (a == b ? 1 : 0));
		}
		br.close();
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	static StringTokenizer sc;

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			sc = new StringTokenizer(s.trim());
		}
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}
}