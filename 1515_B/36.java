import java.io.*;
import java.util.*;

public class B {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		readInput();
		out.close();
	}

	static boolean sq(long x) {
		long l = 1;
		long r = (int)Math.sqrt(1e16)+1;
		while (l+1<r) {
			long m = (l+r)>>1;
			if (m * m > x) r = m;
			else l = m;
		}
		return l*l == x;
	}
	
	static boolean solve(long x) {
		if ((x&1)==1) return false;
		if ((x & (x-1)) == 0) return true;
		long num = 2;
		while (num < x && x % num == 0) {
			if (sq(x/num)) return true;
			num*=2;
		}
		return false;
	}
	
	public static void readInput() throws IOException {
		// br = new BufferedReader(new FileReader(".in"));
		// out = new PrintWriter(new FileWriter(".out"));
		int t = Integer.parseInt(br.readLine());
		while (t-->0) {
			int x = Integer.parseInt(br.readLine());
			out.println(solve(x) ? "YES":"NO");
		}
	}
}
