import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		int height = nextInt();
		int width = nextInt();		
		int k = nextInt();
		int[] r = new int[k];
		int[] c = new int[k];
		for (int i = 0; i < k; i++) {
			r[i] = nextInt() - 1;
			c[i] = nextInt() - 1;			
		}
		int res = 0, R = r[0], C = c[0];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++) {
				int cur = Integer.MAX_VALUE;
				for (int z = 0; z < k; z++)
					cur = Math.min(cur, Math.abs(i - r[z]) + Math.abs(j - c[z]));
				if (res < cur) {
					res = cur;
					R = i;
					C = j;
				}
			}
		out.print((R + 1) + " " + (C + 1));
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(new FileWriter("output.txt"));

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
