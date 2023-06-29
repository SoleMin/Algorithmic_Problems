import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Date 22.11.2011
 * Time 17:49:45
 * Author Woodey
 * $
 */

public class A15 {
	
	final double eps = 10e-9;
	
	class Pair implements Comparable<Pair>{
		int x;
		int length;
		
		Pair(int x, int length) {
			this.x = x;
			this.length = length;
		}

		public int compareTo(Pair p) {
			return x - p.x;
		}
	}
	
	private void Solution() throws IOException {
		int n = nextInt(), t = nextInt(), ans = 2;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i ++) {
			int x = nextInt(), length = nextInt();
			pairs[i] = new Pair(x, length);
		}
		Arrays.sort(pairs);
		for (int i = 0; i < n-1; i ++) {
			double place = pairs[i+1].x - pairs[i].x - (double) pairs[i+1].length/2 - (double) pairs[i].length/2;
			if (place > t)
				ans += 2; else
					if ((int) (place+eps) == t)
						ans ++;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new A15().run();
	}

	BufferedReader in;
	StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			Solution();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(in.readLine());
		return tokenizer.nextToken();
	}
}
