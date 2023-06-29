import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ElongatedMatrix {
	public static void main(String[] args) {
		InputStream input;
		OutputStream output;
		try {
			input = new FileInputStream("input.txt");
			output = new FileOutputStream("output.txt");
		} catch (FileNotFoundException e) {
			input = System.in;
			output = System.out;
		}
		Kattio io = new Kattio(input, output);
		(new Solve(io)).main();
		io.close();

		if (input instanceof FileInputStream)
			try {
				input.close();
			} catch (IOException e) {

			}
		if (output instanceof FileOutputStream)
			try {
				output.close();
			} catch (IOException e) {

			}
	}
}

class Solve {
	static final int oo = (int) 1e9;
	Kattio io;
	int n, m;
	int[][] a;
	int[][][] dp;
	int[][] diff;
	int[][] slant;

	Solve(Kattio io) {
		this.io = io;
	}

	int getbit(int x, int n) {
		n--;
		return (x >> n) & 1;
	}

	int setbit(int x, int n) {
		n--;
		return x | (1 << n);
	}

	int caldp(int currentRow, int firstRow, int mask) {
		if (dp[currentRow][firstRow][mask] != -1)
			return dp[currentRow][firstRow][mask];
		dp[currentRow][firstRow][mask] = 0;
		if (mask == (1 << n) - 1)
			dp[currentRow][firstRow][mask] = slant[currentRow][firstRow];
		else {
			for (int i = 1; i <= n; i++)
				if (getbit(mask, i) == 0) {
					dp[currentRow][firstRow][mask] = Math.max(
							Math.min(caldp(i, firstRow, setbit(mask, i)), diff[currentRow][i]),
							dp[currentRow][firstRow][mask]);

				}
		}
		return dp[currentRow][firstRow][mask];

	}

	void main() {
		n = io.getInt();
		m = io.getInt();
		a = new int[n+1][m+1];
		dp = new int[n+1][n+1][1<<n];
		
		for (int i=1; i<=n; i++)
			for (int j=1; j<=m; j++)
				a[i][j] = io.getInt();
		
		diff = new int[n+1][n+1];
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++)
			{
				diff[i][j]=oo;
				for (int x=1; x<=m; x++)
					diff[i][j]=Math.min(diff[i][j], Math.abs(a[i][x]-a[j][x]));
			}
		
		slant = new int[n+1][n+1];
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++)
			{ 
				slant[i][j] = oo;
				for (int x=1; x+1<=m; x++)
					slant[i][j] = Math.min(slant[i][j], Math.abs(a[i][x]-a[j][x+1]));
			}
		
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++)
				Arrays.fill(dp[i][j], -1);
		
		int res = 0;
		for (int i=1; i<=n; i++)
			res = Math.max(res, caldp(i,i,setbit(0,i)));
		
		io.print(res);
	}
}

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() {
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}

	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null)
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) {
			}
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}