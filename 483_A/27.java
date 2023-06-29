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
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.border.Border;

public class a {

	public static long mod = (long) Math.pow(10, 9) + 7;

	private static class node implements Comparable<node> {
		int x;
		int y;

		node(int x, int c) {
			this.x = x;
			this.y = c;

		}

		@Override
		public int compareTo(node o) {
			if (o.x < x)
				return 1;
			else if (o.x > x)
				return -1;
			else if (o.y < y)
				return 1;
			else if (o.y > y)
				return -1;
			else
				return 0;
		}

	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;

		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder qq = new StringBuilder();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		// int n = Integer.parseInt(in.readLine());
		String y[] = in.readLine().split(" ");
		long n = Long.parseLong(y[0]);
		long m = Long.parseLong(y[1]);

		if (m - n < 2) {
			System.out.println(-1);
		} else if (m - n == 2) {

			if (gcd(n, m) != 1)

				System.out.println(n + " " + (n + 1) + " " + (n + 2));

			else
				System.out.println(-1);
		} else {
			if (n % 2 == 0)
				System.out.println(n + " " + (n + 1) + " " + (n + 2));
			else
				System.out.println((n + 1) + " " + (n + 2) + " " + (n + 3));
		}

		out.close();

	}
}