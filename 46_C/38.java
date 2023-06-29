import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.*;

public class Main implements Runnable {
	BufferedReader in;
	PrintStream out;  
	StringTokenizer st = new StringTokenizer("");
	static boolean local = false;
	
	public static void main(String [] args) throws Exception {
		if (args.length > 0) local = true;
		new Thread(new Main()).start();
	}

	void printExit(String s) {
		out.println(s);
		System.exit(0);
	}

	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = local ? new BufferedReader(new FileReader("input.txt")) : new BufferedReader(new InputStreamReader(System.in));
			out = local ? new PrintStream(new File("output.txt")) : new PrintStream(System.out);
			int n = nextInt();
			char [] c = in.readLine().toCharArray();
			int t = 0;
			for (int i = 0; i < n; i++)
				if (c[i] == 'T') t++;

			int ans = n;
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < t; j++)
					if (c[(i + j) % n] == 'H')
						cnt++;
				ans = min(ans, cnt);
			}

			out.println(ans);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	boolean seekForToken() {
 		try {
			while (!st.hasMoreTokens()) {
				String s = in.readLine();
				if (s == null) {
				 	return false;
				}
			 	st = new StringTokenizer(s);
			}
			return true;
		}
		catch (IOException e) {
		 	e.printStackTrace();
		 	return false;
		}
 	}

 	int nextInt() {
		return Integer.parseInt(nextToken());
 	}

 	long nextLong() {
		return Long.parseLong(nextToken());
 	}

 	double nextDouble() {
		return Double.parseDouble(nextToken());
 	}

 	BigInteger nextBigInteger() {
 	 	return new BigInteger(nextToken());
 	}

 	String nextToken() {
 	 	seekForToken();
 	 	return st.nextToken();
 	}

}
