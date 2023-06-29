import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Locale;

public class E16 {

	static StreamTokenizer in;
	static PrintWriter out;
	
	static int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	static double nextDouble() throws IOException {
		in.nextToken();
		return in.nval;
	}
	
	static String nextString() throws IOException {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);
		
		n = nextInt();
		t = 1 << n;
		m = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				m[i][j] = nextDouble();
		
		memo = new double[t];
		Arrays.fill(memo, Double.POSITIVE_INFINITY);
		for (int i = 0; i < n; i++) out.print(String.format(Locale.US, "%.6f", solve(1 << i)) + " ");
		out.println();
		
		out.flush();
	}
	
	static int n, t;
	static double[][] m;
	static double[] memo;
	
	static double solve(int mask) {
		if (memo[mask] != Double.POSITIVE_INFINITY) return memo[mask];
		if (mask == t-1) return memo[mask] = 1;
		
		int k = Integer.bitCount(mask);
		k = (k+1)*k/2;
		double res = 0;
		for (int i = 0; i < n; i++) if ((mask&(1 << i)) != 0)
			for (int j = 0; j < n; j++) if ((mask&(1 << j)) == 0)
				res += m[i][j]*solve(mask|(1 << j));
		
		return memo[mask] = res/k;
	}
}



