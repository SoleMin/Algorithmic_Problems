import java.io.*;
import java.util.*;

public class A {

	public A () throws IOException {
		int N = sc.nextInt();
		int [] A = new int [N];
		for (int n = 0; n < N; ++n)
			A[n] = sc.nextInt();
		solve(N, A);
	}
	
	public void solve (int N, int [] A) {
		//start();
		Arrays.sort(A);
		int S1 = 0;
		for (int n = 0; n < N; ++n)
			S1 += A[n];
		
		int S2 = 0;
		for (int n = N - 1; n >= 0; --n) {
			S2 += A[n];
			if (S2 > S1 - S2)
				exit(N - n);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	static MyScanner sc;
	static long t;
	
	static void print (Object o) {
		System.out.println(o);
	}
	
	static void exit (Object o) {
		print(o);
		//print2((millis() - t) / 1000.0);
		System.exit(0);
	}
	
	static void run () throws IOException {
		sc = new MyScanner ();
		new A();
	}
	
	public static void main(String[] args) throws IOException {
		run();
	}
	
	static long millis() {
		return System.currentTimeMillis();
	}
	
	static void start() {
		t = millis();
	}
	
	static class MyScanner {
		String next() throws IOException {
			newLine();
			return line[index++];
		}
		
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		String nextLine() throws IOException {
			line = null;
			return r.readLine();
		}

		//////////////////////////////////////////////
		
		private final BufferedReader r;

		MyScanner () throws IOException {
			this(new BufferedReader(new InputStreamReader(System.in)));
		}
		
		MyScanner(BufferedReader r) throws IOException { 
			this.r = r;
			newLine();
		}
		
		private String [] line;
		private int index;

		private void newLine() throws IOException {
			if (line == null || index == line.length) {
				line = r.readLine().split(" ");
				index = 0;
			}
		}		
	}	
}
