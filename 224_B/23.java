import java.io.*;
import java.util.*;

public class Main {
	boolean eof;

	public String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "-1";
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(nextToken());
	}

	int NOD(int a, int b) {
		while (a * b > 0) {
			if (a > b) {
				a %= b;
			} else {
				b %= a;
			}
		}
		return a + b;
	}

	void solve() {
		int n = nextInt(), k= nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i){
			a[i] = nextInt() - 1;
		}
		int[] b = new int[100000];
		int p = 0;
		for (int i = 0; i < n; ++i){
			++b[a[i]];
			if (b[a[i]] == 1){
				++p;
			}
			if (k == p){
				int j;
				for (j = 0; j <= i; ++j){
					if (b[a[j]] > 1){
						--b[a[j]];
					} else {
						break;
					}
				}
				out.print((j + 1) + " " + (i + 1));
				return;
			}
		}
		out.print("-1 -1");
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));

			// br = new BufferedReader(new FileReader("input.txt"));
			// out = new PrintWriter(new FileWriter("output.txt"));
			solve();
			br.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
