import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
	static String file = "";
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Locale.setDefault(Locale.US);

		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		long a = nextLong();
		long b = nextLong();
		if (a % 2 == 1 && b - a == 2 || b - a == 1 || a == b) {
			pw.print(-1);
		} else {
			if (a % 2 == 1)
				a++;
			pw.print(a + " " + (a + 1) + " " + (a + 2));
		}
		pw.close();
	}

	private static double yuza(double x1, double y1, double x2, double y2,
			double x3, double y3) {
		return (x1 * (y3 - y2) + x2 * (y1 - y3) + x3 * (y2 - y1));
	}

	private static void ffile() throws IOException {
		br = new BufferedReader(new FileReader(file + "in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter(file + "out")));
	}

	private static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	private static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	private static double nextDouble() throws NumberFormatException,
			IOException {
		return Double.parseDouble(next());
	}

	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
