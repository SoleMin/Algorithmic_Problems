import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		String[]a = new String[n], b = new String[n];
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			a[i] = next();
			if (!map.containsKey(a[i]))
				map.put(a[i], 0);
			map.put(a[i], map.get(a[i])+1);
		}
		int  ans = 0;
		for (int i = 0; i < n; i++) {
			b[i] = next();
			if (!map.containsKey(b[i]))
				ans++;
			else {
				map.put(b[i], map.get(b[i])-1);
				if (map.get(b[i])==0)
					map.remove(b[i]);
			}
		}
		System.out.println(ans);
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}