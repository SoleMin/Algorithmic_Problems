import java.io.*;
import java.util.*;

public class b {
	public static void main(String[] args) throws Exception {
		
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int sqrt = (int)Math.sqrt(n);
			int sqrt2 = (int)Math.sqrt(n/2);
			if (sqrt*sqrt == n && sqrt%2 == 0) {
				out.println("YES");
			} else if (2*sqrt2*sqrt2 == n) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
		
		out.close();
	}
}
