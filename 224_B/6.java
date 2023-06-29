import java.io.*;
import java.util.*;

public class B implements Runnable {

	void Solution() throws IOException {
		int n = nextInt(), k = nextInt();
		int[] mas = new int[n];
		for (int i = 0; i < n; i++)
			mas[i] = nextInt();
		int l = 0, r = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(mas[l], 1);
		int cur = 1;
		while (true) {
			if (cur == k) {
				print(l + 1, r + 1);
				return;
			}
			r++;
			if (r >= n)
				break;
			int kol = map.containsKey(mas[r]) ? map.remove(mas[r]) : 0;
			if (kol == 0) {
				cur++;
				map.put(mas[r], 1);
			} else
				map.put(mas[r], kol + 1);
			while (true) {
				kol = map.remove(mas[l]);
				if (kol == 1) {
					map.put(mas[l], 1);
					break;
				} else
					map.put(mas[l++], kol - 1);
			}
		}
		print(-1, -1);
	}

	public static void main(String[] args) {
		new B().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			Solution();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	void print(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (i != 0)
				out.print(" ");
			out.print(obj[i]);
		}
	}

	void println(Object... obj) {
		print(obj);
		out.println();
	}

	void halt() {
		out.close();
		System.exit(0);
	}

	String nextLine() throws IOException {
		return in.readLine();
	}

	String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(next());
	}
}
