import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;

	private void solution() throws IOException {
		int n = nextInt();
		int[] mas = new int[n];
		for (int i = 0; i < n; i++) {
			mas[i] = nextInt();
		}

		Arrays.sort(mas);

		if (mas[n - 1] == 1) {
			mas[n - 1] = 2;
		} else {
			mas[n - 1] = 1;
		}
		Arrays.sort(mas);
		for (int i = 0; i < n; i++) {
			System.out.print(mas[i] + " ");
		}

	}

	String nextToken() throws IOException {
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

	public static void main(String args[]) throws IOException {
		new C().solution();
	}
}