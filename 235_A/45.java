import java.lang.*;
import java.util.*;
import java.io.*;


public class Challenge {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {
	
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		
		if (n == 1) {
			out.println("1");
		} else if (n == 2) {
			out.println("2");
		} else if (n == 3) {
			out.println("6");
		} else if (n%2 > 0) {
			out.println(1L * n * (n-1) * (n-2));
		} else if (n%3 == 0) {
			out.println(1L * (n-1) * (n-2) * (n-3));
		} else {
			out.println(1L * n * (n-1) * (n-3));
		}
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
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
	
	public long nextLong() {
		return Long.parseLong(next());
	}
}
