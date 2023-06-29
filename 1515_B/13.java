import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p2 {
	final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String ss() throws IOException {return br.readLine();}	
	private static int stoi(String x) {return Integer.parseInt(x);}
	private static int si() throws IOException {return stoi(ss());}
	private static long sl() throws IOException {return Long.parseLong(ss());}	
	private static int[] sia(int len) throws IOException {
		int[] ret = new int[len];
		final StringTokenizer st = new StringTokenizer(ss());
		for (int i = 0; i < len; ++i) {ret[i] = stoi(st.nextToken());}
		return ret;
	}
	private static long[] sla(int len) throws IOException {
		long[] ret = new long[len];
		final StringTokenizer st = new StringTokenizer(ss());
		for (int i = 0; i < len; ++i) {ret[i] = Long.parseLong(st.nextToken());}
		return ret;
	}
	
	public static void main (final String[] args) throws IOException {
		//goal is to always be higher
		Set<Integer> poss = new HashSet<>();
		for (int i = 1; 2 * (i*i) <= 1000000000; ++i) {
			poss.add(2 * (i*i));
			poss.add(4 * (i*i));
		}
		int t = si();
		for (int i = 0; i < t; ++i) {
			int n = si();
			if (poss.contains(n)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
