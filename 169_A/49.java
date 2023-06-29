import java.io.*;
import java.util.*;
import java.math.*;
public class A {
	@SuppressWarnings("unchecked")
	private static void solve() throws IOException {
		ArrayList<Num> c = new ArrayList<Num>();
		n = nextInt();
		a = nextInt();
		b = nextInt();
		for(int i = 0;  i < n; i++) {
			int next = nextInt();
			boolean found = false;
			for(int j = 0; j < c.size(); j++) {
				if(c.get(j).num == next) {
					c.get(j).freq++;
					found = true;
					break;
				}
			}
			if(!found)
				c.add(new Num(next));
		}
		Collections.sort(c);
		int below = 0;
		int above = n;
		boolean f = false;
		for(int i = 0; i < c.size(); i++) {
			below += c.get(i).freq;
			above -= c.get(i).freq;
			if(below == b && above == a) {
				if(i == c.size())
					break;
				System.out.println(c.get(i+1).num - c.get(i).num);
				f = true;
				break;
			}
		}
		if(!f)
			System.out.println(0);
	}
	
	static int n;
	static int a;
	static int b;
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(239);
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
class Num implements Comparable<Num> {
	int num;
	int freq;
	Num(int n) {
		num = n;
		freq = 1;
	}
	public int compareTo(Num other) {
		return this.num - other.num;
	}
}