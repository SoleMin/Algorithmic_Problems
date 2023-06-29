import java.io.*;
import java.util.*;


public class Main {

	class IO {
		BufferedReader reader;
		PrintWriter writer;
		StringTokenizer tokenizer;

		IO() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new BufferedOutputStream(System.out));
			tokenizer = new StringTokenizer("");
		}

		IO(String file) throws FileNotFoundException {
			reader = new BufferedReader(new FileReader(file));
			writer = new PrintWriter(new BufferedOutputStream(System.out));
			tokenizer = new StringTokenizer("");
		}

		String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				String line = reader.readLine();
				if (line == null)
					return null;
				tokenizer = new StringTokenizer(line);
			}
			return tokenizer.nextToken();
		}

		public Integer nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public void write(Object obj) {
			writer.print(obj.toString());
		}

		public void writeSpace(Object obj) {
			writer.print(obj.toString() + " ");
		}

		public void writeLine(Object obj) {
			writer.println(obj.toString());
		}

		public void close() {
			writer.close();
		}
	}

	IO io;

	Main() {
		io = new IO();
	}

	Main(String file) throws FileNotFoundException {
		io = new IO(file);
	}

	void solve() throws IOException {
		long n = io.nextLong(), s = io.nextLong();
		long min = s;
		while (true) {
			min++;
			long sum = 0, tem = min;
			while (tem > 0) {
				sum += tem % 10;
				tem /= 10;
			}
			if (min - sum >= s) break;
		}
		io.write(Math.max(0, n - min + 1));
	}

	void close() {
		io.close();
	}

	public static void main(String args[]) throws IOException {
		// Main solver = new Main("input.txt");
		Main solver = new Main();
		solver.solve();
		solver.close();
	}
}
