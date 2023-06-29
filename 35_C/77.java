import static java.lang.Math.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class Solution implements Runnable {

	public static void main(String... strings) throws InterruptedException {
		new Thread(new Solution()).start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String next() throws Exception {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(new FileWriter("output.txt"));
			solve();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			out.close();
		}
	}
	int n, m, k, xor = 0;
	boolean[][] used;
	HashSet<Long> [] set;
	void solve() throws Exception {
		n = nextInt();
		m = nextInt();
		k = nextInt();
		used = new boolean[n][m];
		set = new HashSet[2];
		for(int i = 0; i < 2; set[i++] = new HashSet<Long>());
		
		for(int i = 0; i < k; i++){
			int x = nextInt()-1, y = nextInt()-1;
			used[x][y] = true;
			set[0].add(10000L*x + y);
		}
		for (;;xor ^= 1){
			set[xor^1].clear();
			int ansx = -1, ansy = -1;
			for (long i : set[xor]){
				int x = (int)(i/10000), y = (int)(i%10000);
				if (ansx < 0){
					ansx = x+1;
					ansy = y+1;
				}
				add(x+1, y);
				add(x-1, y);
				add(x, y+1);
				add(x, y-1);
			}
			if (set[xor^1].size() == 0){
				out.println(ansx + " " + ansy);
				break;
			}
		}
	}
	public void add(int x, int y){
		if (!( x >= 0 && y >= 0 && x < n && y < m && !used[x][y])) return;
		set[xor^1].add(10000L*x + y);
		used[x][y] = true;
	}

}