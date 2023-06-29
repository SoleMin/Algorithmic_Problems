import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists()) {
				System.setIn(new FileInputStream("input.txt"));
			}
		} catch (SecurityException e) {
		}
		
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int N = nextInt();
		int T = nextInt();

		Pair[] p = new Pair [N];
		for (int i = 0; i < N; i++)
			p[i] = new Pair(nextInt(), nextInt());
		sort(p);
		int ans = 2;
		for (int i = 1; i < N; i++) {
			int dif = (2 * p[i].x - p[i].a) - (2 * p[i - 1].x + p[i - 1].a);
			if (dif == 2 * T)
				ans++;
			else if (dif > 2 * T)
				ans += 2;
		}
		out.println(ans);
		out.close();
	}
	
	class Pair implements Comparable<Pair> {
		int x, a;
		
		public Pair(int xx, int aa) {
			x = xx;
			a = aa;
		}
		
		@Override
		public int compareTo(Pair p) {
			return x < p.x ? -1 : 1;
		}
	}
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
