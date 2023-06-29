import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class B {

	final int MOD = (int)1e9 + 7;
	final double eps = 1e-12;
	final int INF = (int)1e9;
	
	public B () {
		long N = sc.nextInt();
		long X = sc.nextInt() - 1;
		long Y = sc.nextInt() - 1;
		long C = sc.nextInt();

		long [] A1 = new long [] { X, Y };
		long [] A2 = new long [] { X, Y };
		long [] B1 = new long [] { X, Y };
		long [] B2 = new long [] { X, Y };
		long [] C1 = new long [] { X, Y };
		long [] C2 = new long [] { X, Y };
		long [] D1 = new long [] { X, Y };
		long [] D2 = new long [] { X, Y };
		
		long cnt = 1, T = 0;
		
		while (cnt < C) {
			if (A1[0] > 0) --A1[0]; else --A1[1];
			if (A2[0] > 0) --A2[0]; else ++A2[1];
			
			if (B1[1] > 0) --B1[1]; else --B1[0];
			if (B2[1] > 0) --B2[1]; else ++B2[0];
			
			if (C1[0] < N-1) ++C1[0]; else --C1[1];
			if (C2[0] < N-1) ++C2[0]; else ++C2[1];
			
			if (D1[1] < N-1) ++D1[1]; else --D1[0];
			if (D2[1] < N-1) ++D2[1]; else ++D2[0];
						
			long [] Z = { B1[0] - A1[0],
						  C1[0] - B2[0],
						  C2[0] - D2[0],
						  D1[0] - A2[0] };
			
			for (long z : Z)
				if (z >= 0)
					cnt += (z+1);
			
			if (Arrays.equals(A1, A2)) --cnt;
			if (Arrays.equals(B1, B2)) --cnt;
			if (Arrays.equals(C1, C2)) --cnt;
			if (Arrays.equals(D1, D2)) --cnt;
			
			++T;
		}
		
		exit(T);
	}

	////////////////////////////////////////////////////////////////////////////////////
	
	static MyScanner sc;
	
	static class MyScanner {
		public String next() {
			newLine();
			return line[index++];
		}
		
		public char nextChar() {
			return next().charAt(0);
		}
				
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public String nextLine() {
			line = null;
			return readLine();
		}
		
		public String [] nextStrings() {
			line = null;
			return readLine().split(" ");
		}
		
		public char [] nextChars() {
			return next().toCharArray();
		}

		public Integer [] nextInts() {
			String [] L = nextStrings();
			Integer [] res = new Integer [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Integer.parseInt(L[i]);
			return res;
		}	
		
		public Long [] nextLongs() {
			String [] L = nextStrings();
			Long [] res = new Long [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Long.parseLong(L[i]);
			return res;
		}

		public Double [] nextDoubles() {
			String [] L = nextStrings();
			Double [] res = new Double [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Double.parseDouble(L[i]);
			return res;
		}

		//////////////////////////////////////////////
		
		private boolean eol() {
			return index == line.length;
		}

		private String readLine() {
			try {
				return r.readLine();
			} catch (Exception e) {
				throw new Error(e);
			}
		}
		private final BufferedReader r;

		MyScanner () {
			this(new BufferedReader(new InputStreamReader(System.in)));
		}
		
		MyScanner(BufferedReader r) {
			try {
				this.r = r;
				while (!r.ready())
					Thread.sleep(1);
				start();
			} catch (Exception e) {
				throw new Error(e);
			}
		}
		
		private String [] line;
		private int index;

		private void newLine() {
			if (line == null || eol()) {
				line = readLine().split(" ");
				index = 0;
			}
		}		
	}
	
	static void print (Object o, Object... a) {
		pw.println(build(o, a));
	}

	static void exit (Object o, Object... a) {
		print(o, a);
		exit();
	}

	static void exit () {
		pw.close();
		System.out.flush();
		System.err.println("------------------");
		System.err.println("Time: " + ((millis() - t) / 1000.0));
		System.exit(0);
	}
	
	void NO() {
		throw new Error("NO!");
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	static String build(Object... a) {
		StringBuilder b = new StringBuilder();
		for (Object o : a)
			append(b, o);
		return b.toString().trim();		
	}
	
	static void append(StringBuilder b, Object o) {
		if (o.getClass().isArray()) {
			int L = Array.getLength(o);
			for (int i = 0; i < L; ++i)
				append(b, Array.get(o, i));
		} else if (o instanceof Iterable<?>) {
			for (Object p : (Iterable<?>)o)
				append(b, p);
		} else
			b.append(" ").append(o);		
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		sc = new MyScanner ();
		new B();
		exit();
	}

	static void start() {
		t = millis();
	}

	static PrintWriter pw = new PrintWriter(System.out);
	
	static long t;
	
	static long millis() {
		return System.currentTimeMillis();
	}	
}
