import java.io.BufferedReader;
import static java.lang.Math.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CodeforcesA implements Runnable {
	public static final String taskname = "A";
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;

	public static void main(String[] args) {
		new Thread(new CodeforcesA()).start();
	}
	
	static class Square implements Comparable<Square>{
		int x, a;
		public Square(int x, int a) {
			this.x = x;
			this.a = a;
		}
		@Override
		public int compareTo(Square o) {
			return x - o.x;
		}
		
		int distance(Square a, int t) {
			double dist = a.x - x - this.a / 2.0 - a.a / 2.0;
			if(dist > t) return 2;
			else if(abs(dist - t) < 1e-9) return 1;
			return 0;
		}
		
		public String toString() {
			return x + " " + a;
		}
	}
	

	void solve() throws IOException {
		int n = nextInt(), t = nextInt();
		Square[] x = new Square[n];
		for(int i = 0; i < n; ++i) {
			x[i] = new Square(nextInt(), nextInt());
		}
		Arrays.sort(x);
		long res = 2;
		for(int i = 0; i < n - 1; ++i) {
			res += x[i].distance(x[i + 1], t);
		}
		out.println(res);
			
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			//in = new BufferedReader(new FileReader(new File("input.txt")));
			 out = new PrintWriter(System.out);
			//out = new PrintWriter(new File("output.txt"));
			solve();
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String nextLine() throws IOException {
		tok = null;
		return in.readLine();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

}
