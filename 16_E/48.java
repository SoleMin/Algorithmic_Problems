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
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int N = nextInt();
		double[][] a = new double [N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] = nextDouble();
		
		int NN = 1 << N;
		
		double[] dp = new double [NN];
		dp[NN - 1] = 1.0;
		
		for (int mask = NN - 1; mask > 0; mask--) {
			int b = Integer.bitCount(mask);
			if (b <= 1)
				continue;

			double k = 2.0 / (b * (b - 1));
			
			for (int i = 0; i < N; i++) {
				if ((mask & (1 << i)) == 0)
					continue;
				
				for (int j = i + 1; j < N; j++) {
					if ((mask & (1 << j)) == 0)
						continue;
					
					double p = a[i][j];
					dp[mask & (~(1 << j))] += k * p * dp[mask];
					dp[mask & (~(1 << i))] += k * (1.0 - p) * dp[mask];
				}
			}
		}
		
		out.printf(Locale.US, "%.8f", dp[1]);
		
		for (int i = 1, ind = 2; i < N; ind <<= 1, i++)
			out.printf(Locale.US, " %.8f", dp[ind]);
		out.println();
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
