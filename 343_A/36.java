import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ProblemA {
	
	static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String[] nmd = in.readLine().split(" ");
		long a = Long.valueOf(nmd[0]);
		long b = Long.valueOf(nmd[1]);

		long cnt = 0;
		while (true) {
			if (a == 0) {
				break;
			}
			if (a >= b) {
				cnt += a / b;
				a = a % b;
			} else {
				if (b % a == 0) {
					cnt += b / a - 1;
					b = a;
				} else {
					cnt += b / a;
					b = b % a;					
				}
			}
		}
		out.println(cnt);
		out.flush();
	}

	
	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}

