import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	PrintWriter out;

	public void solution() throws IOException {
		int n = nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
			b[i] = a[i];
		}
		Arrays.sort(a);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) {
				ans++;
			}
		}

		if (ans == 2 || ans == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(bf.readLine());
		}
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

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String args[]) throws IOException {
		new C().solution();
	}
}