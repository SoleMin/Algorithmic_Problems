import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class F {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int t = 1;
		// t=sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n + 1];
			int m = sc.nextInt();
			while (m-- > 0) {
				arr[sc.nextInt()]++;
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				min = Math.min(arr[i], min);
			}
			System.out.println(min);
		}
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
