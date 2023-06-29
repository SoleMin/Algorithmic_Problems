import java.io.*;
import java.util.*;

public class Main {
//	static Scanner in;
	static PrintWriter out;
	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}

	public static void main(String[] args) throws Exception {
//		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

		int n = next();
		int t = 2*next();

		int[] x = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = 2* next() + 2000;
			a[i] = next();
		}

		int[] srt = new int[n];
		for (int i = 0; i < n; i++) srt[i] = 10000 * x[i] + a[i];
		Arrays.sort(srt);
		for (int i = 0; i < n; i++) {
			x[i] = srt[i] / 10000;
			a[i] = srt[i] % 10000;
		}

		int answ = 2;
		for (int i = 0; i < n - 1; i++) {
			if (x[i + 1] - x[i] > a[i] + a[i + 1] + t) answ++;
			if (x[i + 1] - x[i] >= a[i] + a[i + 1] + t) answ++;
		}

		out.println(answ);

		out.close();
	}
}