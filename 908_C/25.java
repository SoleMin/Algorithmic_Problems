import static java.lang.Math.*;

public class C {

	public C () {
		int N = sc.nextInt(); int R = sc.nextInt();
		int [] X = sc.nextInts();

		double [] res = new double [N];
		for (int i : rep(N)) {
			res[i] = R;
			for (int j : rep(i)) {
				int D = abs(X[i] - X[j]);
				if (D <= 2*R) {
					double H = sqrt(4.0*R*R - 1.0*D*D);
					res [i] = max(res[i], res[j] + H);
				}
			}
		}
		exit(res);
	}

	private static int [] rep(int N) { return rep(0, N); }
	private static int [] rep(int S, int T) { if (T <= S) return new int [0]; int [] res = new int [T-S]; for (int i = S; i < T; ++i) res[i-S] = i; return res; }
	////////////////////////////////////////////////////////////////////////////////////
	private final static IOUtils.MyScanner sc = new IOUtils.MyScanner();
	private static void exit (Object o, Object ... A) { IOUtils.print(o, A); IOUtils.exit(); }
	private static class IOUtils {
		public static class MyScanner {
			public String next() { newLine(); return line[index++]; }
			public int nextInt() { return Integer.parseInt(next()); }
			public String nextLine() { line = null; return readLine(); }
			public String [] nextStrings() { return split(nextLine()); }
			public int [] nextInts() {
				String [] L = nextStrings();
				int [] res = new int [L.length];
				for (int i = 0; i < L.length; ++i)
					res[i] = Integer.parseInt(L[i]);
				return res;
			}
			//////////////////////////////////////////////
			private boolean eol() { return index == line.length; }
			private String readLine() {
				try {
					return r.readLine();
				} catch (Exception e) {
					throw new Error (e);
				}
			}
			private final java.io.BufferedReader r;
			private MyScanner () { this(new java.io.BufferedReader(new java.io.InputStreamReader(System.in))); }
			private MyScanner (java.io.BufferedReader r) {
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
					line = split(readLine());
					index = 0;
				}
			}
			private String [] split(String s) { return s.length() > 0 ? s.split(" ") : new String [0]; }
		}
		private static String build(Object o, Object ... A) { return buildDelim(" ", o, A); }
		private static String buildDelim(String delim, Object o, Object ... A) {
			StringBuilder b = new StringBuilder();
			append(b, o, delim);
			for (Object p : A)
				append(b, p, delim);
			return b.substring(delim.length());
		}
		//////////////////////////////////////////////////////////////////////////////////
		private static void start() { if (t == 0) t = millis(); }
		private static void append(StringBuilder b, Object o, String delim) {
			if (o.getClass().isArray()) {
				int len = java.lang.reflect.Array.getLength(o);
				for (int i = 0; i < len; ++i)
					append(b, java.lang.reflect.Array.get(o, i), delim);
			} else if (o instanceof Iterable<?>)
				for (Object p : (Iterable<?>) o)
					append(b, p, delim);
			else {
				if (o instanceof Double)
					o = new java.text.DecimalFormat("#.############").format(o);
				b.append(delim).append(o);
			}
		}
		private static java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
		private static void print(Object o, Object ... A) { pw.println(build(o, A)); }
		private static void err(Object o, Object ... A) { System.err.println(build(o, A)); }
		private static void exit() {
			IOUtils.pw.close();
			System.out.flush();
			err("------------------");
			err(IOUtils.time());
			System.exit(0);
		}
		private static long t;
		private static long millis() { return System.currentTimeMillis(); }
		private static String time() { return "Time: " + (millis() - t) / 1000.0; }
	}
	public static void main (String[] args) { new C(); IOUtils.exit(); }
}
