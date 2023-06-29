import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	BufferedReader in;
	StringTokenizer str = null;
	PrintWriter out;
	
	private String next() throws Exception{
		while (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	private double nextDouble() throws Exception{
		return Double.parseDouble(next());
	}

	final int oo = Integer.MAX_VALUE;
	
	int [][]s;
	int n, ALL;
	public void run() throws Exception{
		in =  new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		n = nextInt();
		char []a = next().toCharArray();
		s = new int[n][52];
		boolean []set = new boolean[52];

		for(int i = 0; i < n; ++i) {
			int pos = get(a[i]);
			if (!set[pos]) {
				++ALL;
				set[pos] = true;
			}
			for(int j = 0; j < 52; ++j) {
				if (i > 0) {
					s[i][j] += s[i-1][j];	
				}
				if (j == pos) {
					s[i][j]++;
				}
			}
		}

		int ret = oo;
		for(int i = 0; i < n; ++i) {
			ret = Math.min(ret, get(i));
		}

		out.println(ret);
		out.close();
	}

	private int get(int i) {
		int lo = i - 1, hi = n;
		while(hi - lo > 1) {
			int m = lo + (hi - lo) / 2;
			int c = 0;
			for(int j = 0; j < 52; ++j) {
				if (sum(j, i, m) > 0) {
					++c;
				}
			}
			if (c < ALL) {
				lo = m;
			} else {
				hi = m;
			}
		}

		if (hi != n) {
			return hi - i + 1;
		}
		return oo;
	}

	private int sum(int pos, int l, int r) {
		int ret = s[r][pos];
		if (l > 0) ret -= s[l - 1][pos];
		return ret;
	}

	private int get(char x) {
		if ('a' <= x && x <= 'z') return (int)(x - 'a');
		return (int)(x - 'A' + 26);
	}

	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
