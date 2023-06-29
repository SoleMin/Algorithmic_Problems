import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		Locale.setDefault(Locale.US);
		try {
			run1();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	int nextInt(StreamTokenizer st) throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	private List<Integer> kmp(String x, String a) {
		String s = a + "$" + x;
		int[] oppa = new int[s.length()];
		oppa[0] = 0;
		int tmp = 0;
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < s.length(); i++) {
			while (tmp != 0 && s.charAt(tmp) != s.charAt(i)) {
				// System.out.println(i + " " + tmp);
				tmp = oppa[tmp - 1];
			}
			if (s.charAt(tmp) == s.charAt(i))
				tmp++;
			oppa[i] = tmp;
			if (tmp == a.length()) {
				res.add(i - a.length() - a.length());
			}
		}
		return res;
	}

	double nextDouble(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.nval;
	}

	String nextLine(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.sval;
	}

	public void run1() throws IOException {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(new FileReader("input.txt"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] arr = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a - 1][b - 1] = true;
			arr[b - 1][a - 1] = true;
		}
		long[][] res = new long[n][1 << n];
		for (int mask = 1; mask < (1 << n); mask++) {
			int min = -1;
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) != 0) {
					if (min == -1) {
						min = i;
						if (mask == (1 << min))
							res[min][mask] = 1;
					}
					for (int j = min + 1; j < n; j++)
						if ((mask & (1 << j)) == 0 && arr[i][j]) {
							res[j][mask | (1 << j)] += res[i][mask];
						}
				}
			}
		}
		long r = 0;
		for (int mask = 1; mask < (1 << n); mask++)
			if (Integer.bitCount(mask) != 2)
				for (int j = 0; j < n; j++) {
					int i = 0;
					while ((mask & (1 << i)) == 0)
						i++;
					if (arr[i][j])
						r += res[j][mask];
				}
		System.out.println(r / 2);
	}
}