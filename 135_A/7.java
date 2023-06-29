import java.io.*;
import java.util.*;

public class A {

	public A () throws IOException {
		String input = r.readLine();
		int N = Integer.parseInt(input);
		int [] A = new int [N];
		input = r.readLine();
		String [] S = input.split(" ");
		for (int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(S[i]);
		solve(N, A);
	}
	
	public void solve (int N, int [] A) {
		t = millis();
		Arrays.sort(A);
		if (A[N-1] > 1) A[N-1] = 1;
		else A[N-1] = 2;
		Arrays.sort(A);
		System.out.print(A[0]);
		for (int i = 1; i < N; ++i)
			System.out.print(" " + A[i]);
		System.out.println();
	}

	////////////////////////////////////////////////////////////////////////////////////

	static BufferedReader r;
	static long t;
	
	static void print2 (Object o) {
		System.out.println(o);
	}
	
	static void print (Object o) {
		print2(o);
		//print2((millis() - t) / 1000.0);
		System.exit(0);
	}
	
	static void run () throws IOException {
		r = new BufferedReader(new InputStreamReader(System.in));
		new A();
	}
	
	public static void main(String[] args) throws IOException {
		run();
	}
	
	static long millis() {
		return System.currentTimeMillis();
	}
}
