import java.io.*;
import java.util.*;

public class A {

	class Team implements Comparable<Team>{
		int p, t;
		public Team(int p, int t) {
			this.p = p;
			this.t = t;
		}
		public int compareTo(Team other) {
			if (this.p != other.p) return other.p - this.p;
			return this.t - other.t;
		}
	}
	
	public void solve() throws IOException {
		int n = nextInt();
		int K = nextInt() - 1;
		Team[] team = new Team[n];
		for (int i = 0; i < n; i++) 
			team[i] = new Team(nextInt(), nextInt());
		
		Arrays.sort(team);
		int ans = -1;
		int pre = 0;
		for (int i = 1; i < n; i++)
			if (team[i].compareTo(team[i - 1]) != 0) {
				if (K >= pre && K < i) {
					ans = i - pre;
					break;
				}
				pre = i;
			}
		if (ans == -1) ans = n - pre;
		writer.println(ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new A().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			long tbegin = System.currentTimeMillis();
			reader = new BufferedReader(new InputStreamReader(System.in));
			//reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.inp")));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			//writer = new PrintWriter(new FileOutputStream("test.out"));
			solve();
			//reader.close();
			//System.out.println(System.currentTimeMillis() - tbegin + "ms");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
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

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}
