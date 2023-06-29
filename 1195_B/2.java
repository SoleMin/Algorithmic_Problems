import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.ObjectInputStream.GetField;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JLabel;

public class codeforcesreturn {
	static class edge {
		int u;
		int v;

		public edge(int u, int v) {
			this.u = u;
			this.v = v;
		}

	}

	static ArrayList<Integer>[] adjlist;
	static int[][] adjmatrix;
	static int[][] adjmatrix2;
	static boolean[] vis;
	static boolean[] intialvis;
	static boolean[] vis2;
	static int[] counter;
	static int V, E;
	static Stack<Integer> st;
	static ArrayList<Integer> arrylist;
	static boolean flag;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static int[] Arr;
	static PrintWriter pw;
	static boolean ans = true;;

	public static long gcd(long u, long v) {
		if (u == 0)
			return v;
		return gcd(v % u, u);
	}

	public static void bib(int u) {

		vis[u] = true;
		for (int v : adjlist[u]) {
			if (!vis[v]) {
				counter[v] = 1 ^ counter[u];
				bib(v);
			} else if (counter[v] != (1 ^ counter[u]))
				ans = false;

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// FileWriter f = new FileWriter("C:\\Users\\Hp\\Desktop\\out.txt");
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum = n;

		for (long i = 0; i < 1e5; i++) {
			if (i * (i + 1) / 2 - (n - i) == k) {
				System.out.println(n - i);
				break;
			}
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}