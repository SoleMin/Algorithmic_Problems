import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.border.Border;

public class a {

	public static long mod = (long) Math.pow(10, 9) + 7;
	public static int k = 0;

	private static class node implements Comparable<node> {
		int l;
		int r;
		int index;
		int index2;
		int buffer;

		node(int l, int r, int i, int b, int i2) {
			this.l = l;
			this.r = r;
			index = i;
			buffer = b;
			index2 = i2;

		}

		@Override
		public int compareTo(node o) {
			if (k == 0) {
				if (o.l < l)
					return 1;
				else if (o.l > l)
					return -1;
				else if (o.buffer != -1) {
					return 1;
				} else
					return -1;
			} else if (k == 1) {
				if (r != o.r)
					return r - o.r;
				return o.index - index;
			} else if (k == 2) {
				return r - o.r;
			} else {
				if (o.index < index)
					return 1;
				else
					return -1;
			}

		}
	}

	// private static class point implements Comparable<point> {
	// int l;
	// int r;
	// int index;
	// int buffer;
	//
	// point(int l, int r, int i, int b) {
	// this.l = l;
	// this.r = r;
	// index = i;
	// buffer = b;
	//
	// }
	//
	// @Override
	// public int compareTo(point o) {
	// if (o.l < l)
	// return 1;
	// else if (o.l > l)
	// return -1;
	// else if (o.r < r)
	// return 1;
	// else if (o.r > r)
	// return -1;
	// return 0;
	// }
	//
	// }

	public static class point implements Comparable<point> {
		long x;
		long y;

		point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(point o) {
			return (int) (x - o.x);

		}
	}

	public static int ch(long y) {
		int r = Long.bitCount(y);
		return r;
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;

		return gcd(y, x % y);
	}

	public static int min[];
	public static int max[];

	public static void build(int s, int e, int p, int a[]) {
		if (s == e) {
			min[p] = a[s];
			max[p] = a[s];
			return;
		}

		int mid = (s + e) / 2;
		build(s, mid, p * 2, a);
		build(mid + 1, e, p * 2 + 1, a);
		min[p] = Math.min(min[p * 2], min[p * 2 + 1]);
		max[p] = Math.max(max[p * 2], max[p * 2 + 1]);
	}

	public static int getMin(int s, int e, int p, int from, int to) {
		if (s > to || e < from)
			return Integer.MAX_VALUE;
		if (s >= from && e <= to)
			return min[p];
		int mid = (s + e) / 2;

		int a = getMin(s, mid, p * 2, from, to);
		int b = getMin(mid + 1, e, p * 2 + 1, from, to);
		return Math.min(a, b);

	}

	public static int getMax(int s, int e, int p, int from, int to) {
		if (s > to || e < from)
			return Integer.MIN_VALUE;
		if (s >= from && e <= to)
			return max[p];
		int mid = (s + e) / 2;

		int a = getMax(s, mid, p * 2, from, to);
		int b = getMax(mid + 1, e, p * 2 + 1, from, to);
		return Math.max(a, b);

	}

	public static boolean ch[];
	public static ArrayList<Integer> prime;
	public static Queue<Integer> pp;

	public static void sieve(int k) {
		ch[0] = ch[1] = true;

		for (int i = 2; i <= k; i++) {
			if (!ch[i]) {
				prime.add(i);
				pp.add(i);
				for (int j = i + i; j <= k; j += i) {
					ch[j] = true;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder qq = new StringBuilder();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String y[] = in.readLine().split(" ");
		int n = Integer.parseInt(y[0]);
		int a = Integer.parseInt(y[1]);
		int b = Integer.parseInt(y[2]);

		int arr[] = new int[n];
		HashMap<Integer, Integer> mp = new HashMap();
		y = in.readLine().split(" ");
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(y[i]);
			if (arr[i] >= a && arr[i] >= b) {
				flag = false;
			}
			mp.put(arr[i], i);
		}

		if (!flag) {
			System.out.println("NO");
			return;
		}
		boolean ch[] = new boolean[n];
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {
			int k = i;

			while (true&&!ch[k]) {
				
				if (mp.containsKey(a - arr[k]) && !ch[mp.get(a - arr[k])]
						&& mp.containsKey(b - arr[k])
						&& !ch[mp.get(b - arr[k])]) {
					break;
				} else if (mp.containsKey(a - arr[k])
						&& !ch[mp.get(a - arr[k])]) {
					//System.out.println(arr[k]);
					ch[k] = true;
					ans[k] = 0;
					ch[mp.get(a - arr[k])] = true;
					ans[mp.get(a - arr[k])] = 0;
					int s = b - (a - arr[k]);
					if (mp.containsKey(s)) {
						k = mp.get(s);
					} else
						break;
					
				} else if (mp.containsKey(b - arr[k])
						&& !ch[mp.get(b - arr[k])]) {
					ans[k] = 1;
					ans[mp.get(b - arr[k])] = 1;
					ch[k] = true;
					ch[mp.get(b - arr[k])] = true;

					int s = a - (b - arr[k]);
					if (mp.containsKey(s)) {
						k = mp.get(s);
					} else
						break;
				} else {
					// System.out.println(arr[i] + " " + i);
					System.out.println("NO");
					return;
				}
			}
		}

		qq.append("YES\n");
		for (int i = 0; i < ans.length; i++) {
			qq.append(ans[i] + " ");
		}
		System.out.println(qq);

	}
}