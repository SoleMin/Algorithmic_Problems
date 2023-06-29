import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution implements Runnable {
	
	public static void main(String[] args) {
		(new Thread(new Solution())).start();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String sti(String s) {
		int res = 0;
		int q = 1;
		int qq = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) qq += q;
			res = res * 26 + s.charAt(i) - 'A';
			q *= 26;
		}
		return Integer.toString(qq + res + 1);
	}
	
	String its(String s) {
		int q = Integer.parseInt(s);
		String res = "";
		int w = 26;
		int l = 1;
		while (q > w) {
			q -= w;
			l++;
			w *= 26;
		}
		q--;
		if (q == 0) return "A";
		while (q > 0) {
			res = "" + (char)('A' + q % 26) + res;
			l--;
			q /= 26;
		}
		for (; l > 0; l--) res = "A" + res;
		return res;
	}
	        
	void solve() throws IOException {
		int n = nextInt();
		for (int i = 0; i < n; i++) {
			String s = nextToken();
			int j = 0;
			while (!Character.isDigit(s.charAt(j))) j++;
			int q = j + 1;
			while (q < s.length() && Character.isDigit(s.charAt(q))) q++;
			if (q == s.length()) {
				out.println("R" + s.substring(j) + "C" + sti(s.substring(0, j)));
			} else {
				String w = s.substring(j, q);
				while (!Character.isDigit(s.charAt(q))) q++;
				out.println(its(s.substring(q)) + w);
			}
		}
	}
	
	public void run() {
		try {
//			in = new BufferedReader(new FileReader(new File("input.txt")));
//			out = new PrintWriter(new File("output.txt"));
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
	}

}
