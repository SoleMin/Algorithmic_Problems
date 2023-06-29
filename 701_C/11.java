import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class C364C {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;

	static int n;
	static int[] a;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n = nextInt();
		int ans = n, cc, cur = 0;
		a = new int [52];
		char[] c = next().toCharArray();
		int l = 0, len = 0;
		for (int i = 0; i < n; ++i) {
			if (Character.isUpperCase(c[i])) {
				cur = 26 + c[i] - 'A';
			} else
				cur = c[i] - 'a';
			if (a[cur] == 0) {
				a[cur]++;
				len++;
				ans = i - l + 1;
			} else {
				a[cur]++;
				for (; l < i; ++l) {
					if (Character.isUpperCase(c[l])) {
						cc = 26 + c[l] - 'A';
					} else
						cc = c[l] - 'a';
					
					if (a[cc] > 1) {
						--a[cc];
					} else break;
				}
				if (i - l + 1 < ans) {
					ans = i - l + 1;
				}
			}
		}
	
		/*int l = 0, r = n - 1;
		for (l = 0; l < n; ++l) {
			if (Character.isUpperCase(c[l])) {
				if (a[26 + c[l] - 'A'] > 1) {
					a[26 + c[l] - 'A']--;
				} else break;
			} else {
				if (a[c[l] - 'a'] > 1) {
					a[c[l] - 'a']--;
				} else break;
				
			}
		}
		for (r = n - 1; r >= 0; --r) {
			if (Character.isUpperCase(c[r])) {
				if (a[26 + c[r] - 'A'] > 1) {
					a[26 + c[r] - 'A']--;
				} else break;
			} else {
				if (a[c[r] - 'a'] > 1) {
					a[c[r] - 'a']--;
				} else break;
				
			}
		}*/
		pw.print(ans);
		pw.close();
	}
	
	private static int sumf(int[] fen, int id) {
		int summ = 0;
		for (; id >= 0; id = (id & (id + 1)) - 1) 
 			summ += fen[id];
		return summ;
	}

	private static void addf(int[] fen, int id) {
		for (; id < fen.length; id |= id + 1) 
			fen[id]++;
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}