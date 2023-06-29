import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Class<?> here = new Object(){}.getClass().getEnclosingClass();
		try {
			String packageName = here.getPackage().getName();
			packageName = "src/" + packageName.replaceAll("\\.", "/") + "/";
			System.setIn(new FileInputStream(packageName + "input.txt"));
//			System.setOut(new PrintStream(new FileOutputStream(packageName + "output.txt")));
		} catch (FileNotFoundException e) {
		} catch (NullPointerException e) {
		}

		Object o = Class.forName(here.getName()).newInstance();
		o.getClass().getMethod("run").invoke(o);
	}

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}


	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	void solve() {
		int n = sc.nextInt();
		int k = sc.nextInt();

		TreeSet<Integer> at = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) at.add(sc.nextInt());
		Integer[] ai = at.toArray(new Integer[0]);
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = ai[i];

		if (k == 1) {
			out.println(n);
			return;
		}

		boolean[] invalid = new boolean[n];

		tr(a);
		int ans = 0;
		for (int i = 0, j = 0; i < n; i++) if (!invalid[i]) {
			++ans;
			long kx = (long)k * a[i];
			while (j < n && a[j] < kx) {
				j++;
			}
			if (j < n && kx == a[j]) {
				invalid[j] = true;
			}
		}
		out.println(ans);

	}


	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		public String next() {
			eat();
			return tokenizer.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}
