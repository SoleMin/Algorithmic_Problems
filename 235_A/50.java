
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();

		if(n < 3)
			out.println(n);
		else
		{
			if((n & 1) == 1)
				out.println(lcm(n, lcm(n - 1, n - 2)));
			else
				out.println(Math.max(lcm(n - 1, lcm(n - 2, n - 3)), lcm(n, lcm(n - 1, n - 3))));
		}
		out.flush();
		out.close();
	}

	static long gcd(long a, long b) 
	{ 
		while(b != 0)
		{
			a = a%b;
			b ^= a;
			a ^= b;
			b ^= a;
		}
		return a;

	}

	static long lcm(long a, long b) { return a / gcd(a,b) * b; }
}



class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}