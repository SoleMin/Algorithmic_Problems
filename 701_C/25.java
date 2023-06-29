import java.util.*;
import java.io.*;

public class C{
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Solver solver = new Solver();
		solver.solve(in, out);
		out.close();
	}

	static class Solver{
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			String s = in.next();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < n; ++ i) {
				map.put(s.charAt(i), 0);
			}
			int l = 0, r = 0, cnt = 0, ans = n;
			char c;
			while (l < n) {
				while (r < n && cnt < map.size()) {
					c = s.charAt(r);
					map.put(c, map.get(c) + 1);
					if (map.get(c) == 1) ++cnt;
					++r;
				}
				
				if (cnt == map.size() && r-l < ans)
					ans = r-l;
				
				c = s.charAt(l);
				map.put(c, map.get(c)-1);
				if (map.get(c) == 0) --cnt;
				++l;
			}
			out.println(ans);
		}
	}

	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public InputReader (InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (tokenizer == null || ! tokenizer.hasMoreTokens()) {
				try{
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}