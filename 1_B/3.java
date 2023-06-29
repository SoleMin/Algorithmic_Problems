import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists())
				System.setIn(new FileInputStream("input.txt"));
		} catch (SecurityException e) {
		}
		new Thread() {
			public void run() {
				try {
					new Main().run();
				} catch (IOException e) {
				}
			}
		}.start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	int MAXDEG = 5;

	private void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int n = nextInt();
		int[] sumDegs = new int[MAXDEG + 1];
		sumDegs[0] = 1;
		int deg = 1;
		for (int i = 1; i <= MAXDEG; i++) {
			deg *= 26;
			sumDegs[i] = sumDegs[i - 1] + deg;
		}
		for (int i = 0; i < n; i++) {
			String s = nextLine();
			String pref = "";
			int endPos = -1;
			for (int j = 0; j < s.length(); j++) {
				if (!isLet(s.charAt(j))) {
					endPos = j;
					break;
				}
				pref += s.charAt(j);
			}
			int num = -1;
			try {
				num = Integer.parseInt(s.substring(endPos));
			} catch (Exception e) {
			}
			if (num != -1) {
				int col = sumDegs[pref.length() - 1];
				int val = 0;
				for (int j = 0; j < pref.length(); j++) {
					val = val * 26 + (pref.charAt(j) - 'A');
				}
				col += val;
				out.println("R" + num + "C" + col);
			} else {
				int row = Integer.parseInt(s.substring(1, s.indexOf('C')));
				int col = Integer.parseInt(s.substring(s.indexOf('C') + 1));
				int len = MAXDEG;
				while (col < sumDegs[len])
					len--;
				len++;
				col -= sumDegs[len - 1];
				String res = "";
				while (col > 0) {
					res = (char) (col % 26 + 'A') + res;
					col /= 26;
				}
				while (res.length() < len)
					res = "A" + res;
				out.println(res + row);
			}
		}
		in.close();
		out.close();
	}

	private boolean isLet(char c) {
		return c >= 'A' && c <= 'Z';
	}

	void chk(boolean b) {
		if (b)
			return;
		System.out.println(new Error().getStackTrace()[1]);
		exit(999);
	}
	void deb(String fmt, Object... args) {
		System.out.printf(Locale.US, fmt + "%n", args);
	}
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
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
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
