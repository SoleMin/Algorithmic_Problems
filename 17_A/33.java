import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists()) {
				System.setIn(new FileInputStream("input.txt"));
			}
		} catch (SecurityException e) {
		}
		
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	boolean[] erat = new boolean [1000 + 1];
	int[] primes = new int [1000 + 1];
	int pNum = 0;
	
	void run() throws IOException {
		
		for (int i = 2; i <= 1000; i++) {
			if (!erat[i]) {
				primes[pNum++] = i;
				for (int j = i * i; j <= 1000; j += i)
					erat[j] = true;
			}
		}
		
		int[] cnt = new int [1000 + 1];
		cnt[2] = 0;
		
		for (int i = 3; i <= 1000; i++) {
			cnt[i] = cnt[i - 1];
			if (!erat[i]) {
				int r = i - 1;
				for (int j = 1; j < pNum; j++) {
					if (r == primes[j - 1] + primes[j]) {
						cnt[i]++;
						break;
					}
				}
			}
		}

		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int n = nextInt();
		int k = nextInt();
		
		out.println(k <= cnt[n] ? "YES" : "NO");
		
		out.close();
	}
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
