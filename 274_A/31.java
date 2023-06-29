


import static java.util.Arrays.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class A {

	final int MOD = (int)1e9 + 7;
	final double eps = 1e-12;
	final int INF = (int)1e9;
	
	public A () {
		int N = sc.nextInt();
		int K = sc.nextInt();
		Long [] A = sc.nextLongs();

		sort(A);
		TreeSet<Long> S = new TreeSet<Long>();
		
		for (long a : A) {
			if (a % K == 0 && S.contains(a/K))
				continue;
			S.add(a);
		}
		
		int res = S.size();
		exit(res);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/* Dear hacker, don't bother reading below this line, unless you want to help me debug my I/O routines :-) */
	
	static MyScanner sc = new MyScanner();
	
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

		public String [] next (int N) {
			String [] res = new String [N];
			for (int i = 0; i < N; ++i)
				res[i] = sc.next();
			return res;
		}
		
		public Integer [] nextInt (int N) {
			Integer [] res = new Integer [N];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextInt();
			return res;
		}		
		
		public Long [] nextLong (int N) {
			Long [] res = new Long [N];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextLong();
			return res;
		}		
		
		public Double [] nextDouble (int N) {
			Double [] res = new Double [N];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextDouble();
			return res;
		}		
		
		public String [][] nextStrings (int N) {
			String [][] res = new String [N][];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextStrings();
			return res;
		}
		
		public Integer [][] nextInts (int N) {
			Integer [][] res = new Integer [N][];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextInts();
			return res;
		}
		
		public Long [][] nextLongs (int N) {
			Long [][] res = new Long [N][];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextLongs();
			return res;
		}
		
		public Double [][] nextDoubles (int N) {
			Double [][] res = new Double [N][];
			for (int i = 0; i < N; ++i)
				res[i] = sc.nextDoubles();
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
	
	static void print(Object o, Object... a) {
		printDelim(" ", o, a);
	}
	
	static void cprint(Object o, Object... a) {
		printDelim("", o, a);
	}
	
	static void printDelim (String delim, Object o, Object... a) {
		pw.println(build(delim, o, a));
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
	
	static String build(String delim, Object o, Object... a) {
		StringBuilder b = new StringBuilder();
		append(b, o, delim);
		for (Object p : a)
			append(b, p, delim);
		return b.toString().trim();		
	}
	
	static void append(StringBuilder b, Object o, String delim) {
		if (o.getClass().isArray()) {
			int L = Array.getLength(o);
			for (int i = 0; i < L; ++i)
				append(b, Array.get(o, i), delim);
		} else if (o instanceof Iterable<?>) {
			for (Object p : (Iterable<?>)o)
				append(b, p, delim);
		} else
			b.append(delim).append(o);		
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new A();
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
