import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		(new Main()).solve();
	}

	public Main() {
	}
	
	MyReader in = new MyReader();
	PrintWriter out = new PrintWriter(System.out);
	
	void solve() throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// Scanner in = new Scanner(System.in);

		//Scanner in = new Scanner(new FileReader("forbidden-triples.in"));
		//PrintWriter out = new PrintWriter("forbidden-triples.out");
		long n = in.nextLong();
		long k = in.nextLong();
		long sum = 1;
		long count = 0;
		
		long index = k - 1;
		
		long[] delta = {1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10, 1, 0};
		
		while (index > 0) {
			if (index + sum <= n) {
				for (int d = 0; d < delta.length; d++) {
					if (delta[d] < index) {
						long m = (2 * index - delta[d])*(delta[d] + 1)/2;
						if (m + sum <= n) {
							sum += m;
							index -= (delta[d] + 1);
							count += (delta[d] + 1);
						}
					}
				}
			} else {
				index = n - sum;
			}
		}
		if (sum == n) {
			out.println(count);
		} else {
			out.println(-1);
		}
		
		
		out.close();
	}	

};

class MyReader {
	private BufferedReader in;
	String[] parsed;
	int index = 0;

	public MyReader() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public int nextInt() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Integer.parseInt(parsed[index++]);
	}

	public long nextLong() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Long.parseLong(parsed[index++]);
	}
	
	public String nextString() throws IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return parsed[index++];
	}

	private void read() throws IOException {
		parsed = in.readLine().split(" ");
		index = 0;
	}

	public String readLine() throws IOException {
		return in.readLine();
	}
};