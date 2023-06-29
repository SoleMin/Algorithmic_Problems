import java.io.*;
import java.util.*;

public class Solution implements Runnable {

	Scanner input;
	PrintWriter output;
	
	private void solve() throws Exception
	{
		int n = nextInt();
		int m = nextInt();
		int k = nextInt();
		int[] r = new int[k];
		int[] c = new int[k];
		for (int i = 0; i < k; i++)
		{
			r[i] = nextInt();
			c[i] = nextInt();
		}
		int best = -1;
		int bestr = -1;
		int bestc = -1;
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				int d = n + m;
				for (int q = 0; q < k; q++)
				{
					d = Math.min(d, Math.abs(i - r[q]) + Math.abs(j - c[q]));
				}
				if (d < best) continue;
				best = d;
				bestr = i;
				bestc = j;
			}
		}
		out(bestr + " " + bestc);
	}

	private int nextInt() throws Exception
	{
		return input.nextInt();
	}
	
	private void out(String s)
	{
		output.println(s);
	}

	public void run() {
		try {
			solve();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			output.close();
		}
	}
	
	public Solution() throws IOException {
		input = new Scanner(new FileReader("input.txt"));
		output = new PrintWriter("output.txt");
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		new Thread(new Solution()).start();
	}
}
