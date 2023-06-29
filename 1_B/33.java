import java.util.*;
import java.io.*;

public class Solution extends Thread {

	final static int MAXNUM = 1 << 20;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
			int tests = nextInt();
			int num = 1;
			for (int test = 0; test < tests; test++) {
				String s = next();
				if (s.charAt(0) == 'R' && s.charAt(1) >= '0' && s.charAt(1) <= '9' && s.indexOf('C') != -1) {
					String[] sp = s.split("[RC]");
					int r = Integer.parseInt(sp[1]);
					int c = Integer.parseInt(sp[2]);
					s = "";
					while (c > 0) {
						if (c % 26 == 0) {
							s = 'Z' + s;
							c /= 26;
							c --;
						} else {
							s = (char)('A' + c % 26 - 1) + s;
							c /= 26;
						}
					}
					s = s + r;
				} else {
					int pos = 0;
					while (s.charAt(pos) < '0' || s.charAt(pos) > '9') {
						pos ++;
					}
					int r = Integer.parseInt(s.substring(pos));
					int c = 0;
					s = s.substring(0, pos);
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) < 'Z') {
							c = c * 26 + (s.charAt(i) - 'A' + 1);
						} else {
							c = c * 26 + 26;
						}
					}
					s = "R" + r + "C" + c;
				}
				System.out.println(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	String next() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	BufferedReader in;
	StringTokenizer st;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		new Thread(new Solution()).start();
	}
}
