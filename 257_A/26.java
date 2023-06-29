import static java.util.Arrays.*;
import static java.util.Collections.*;

import java.io.*;
import java.lang.reflect.*;

public class A {

	final int MOD = (int)1e9 + 7;
	final double eps = 1e-12;
	final int INF = (int)1e9;
	
	public A () {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		Integer [] S = sc.nextInts();
		sort(S, reverseOrder()); 
		
		int cnt = K, res;
		for (res = 0; res < N && cnt < M; ++res)
			cnt += S[res] - 1;
		
		exit(cnt < M ? -1 : res);
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
