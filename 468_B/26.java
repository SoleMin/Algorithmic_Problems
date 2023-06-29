import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		pineapple();
		reader.close();
		writer.close();
	}

	static void pineapple() throws NumberFormatException, IOException {
		int n = nextInt();
		int a = nextInt();
		int b = nextInt();
		TreeSet<Integer> al = new TreeSet<Integer>();
		TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		TreeSet<Integer> used = new TreeSet<Integer>();
		int[] mas = new int[n];

		for (int i = 0; i < n; i++) {
			int t = nextInt();
			al.add(t);
			mas[i] = t;
			mp.put(t, i);
		}

		for (int st : al) {
			if (used.contains(st))
				continue;

			{
				int pr = st;
				int cc = -1;
				TreeSet<Integer> u2 = new TreeSet<Integer>();
				u2.add(pr);
				if (al.contains(a - pr) && !u2.contains(a - pr))
					cc = a - pr;
				else if (al.contains(b - pr) && !u2.contains(a - pr))
					cc = b - pr;
				if (cc != -1) {
					u2.add(cc);
					boolean bGo = true;
					while (bGo) {
						bGo = false;
						int nxt = -1;
						if (al.contains(a - cc) && !u2.contains(a - cc))
							nxt = a - cc;
						else if (al.contains(b - cc) && !u2.contains(b - cc))
							nxt = b - cc;
						if (nxt != -1) {
							bGo = true;
							u2.add(nxt);
							cc = nxt;
							pr = cc;
						}
					}
					st = cc;
				}
			}

			int x = st;
			while (x != -1) {
				int curr = x;
				used.add(curr);
				x = -1;
				int next1 = a - curr;
				if (al.contains(next1)) {
					if (!used.contains(next1)) {
						x = next1;
						int ci = mp.get(curr);
						int ni = mp.get(next1);
						if (ans[ci] == -1 && ans[ni] == -1) {
							ans[ni] = 0;
							ans[ci] = 0;
						}
					}
				}
				int next2 = b - curr;
				if (al.contains(next2)) {
					if (!used.contains(next2)) {
						x = next2;
						int ci = mp.get(curr);
						int ni = mp.get(next2);
						if (ans[ci] == -1 && ans[ni] == -1) {
							ans[ni] = 1;
							ans[ci] = 1;
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (ans[i] == -1) {
				if (2 * mas[i] == a) {
					ans[i] = 0;
					continue;
				}
				if (2 * mas[i] == b) {
					ans[i] = 1;
					continue;
				}
				writer.println("NO");
				return;
			}
		}

		writer.println("YES");
		for (int i = 0; i < n; i++) {
			writer.print(ans[i] + " ");
		}
	}
}