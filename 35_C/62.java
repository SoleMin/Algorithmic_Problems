import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nafiur Rahman Khadem Shafin 🙂
 */
public class Main {
	public static void main (String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader (inputStream);
		PrintWriter out = new PrintWriter (outputStream);
		ProblemCFireAgain solver = new ProblemCFireAgain ();
		solver.solve (1, in, out);
		out.close ();
	}
	
	static class ProblemCFireAgain {
		private static final byte[] dx = {-1, 0, 0, 1};
		private static final byte[] dy = {0, -1, 1, 0};
		private static int[][] lvl;
		private static int max;
		private static int n;
		private static int m;
		private static int k;
		private static ProblemCFireAgain.Pair[] bgn;
		private static ProblemCFireAgain.Pair res;
		
		private static void bfs2d () {
			Queue<ProblemCFireAgain.Pair> bfsq = new LinkedList<ProblemCFireAgain.Pair> ();
			for (ProblemCFireAgain.Pair src : bgn) {
				lvl[src.a][src.b] = 0;
				bfsq.add (src);
			}
			while (!bfsq.isEmpty ()) {
				ProblemCFireAgain.Pair op = bfsq.poll ();
				int plvl = lvl[op.a][op.b];
//			System.out.println ("ber hoise "+op+" "+plvl);
				if (plvl>max) {
					res = op;
					max = plvl;
				}
				for (int i = 0; i<4; i++) {
					int newX = op.a+dx[i];
					int newY = op.b+dy[i];
//				System.out.println (newX+" "+newY+" "+n+" "+m);
					if (newX>0 && newX<=n && newY>0 && newY<=m && lvl[newX][newY] == -1) {
						bfsq.add (new ProblemCFireAgain.Pair (newX, newY));
						lvl[newX][newY] = (plvl+1);
//					System.out.println ("dhukse "+newX+" "+newY);
					}
				}
			}
		}
		
		public void solve (int testNumber, InputReader _in, PrintWriter _out) {
			/*
			 * file input-output 😮. Multi source bfs. Same as snackdown problem.
			 * */
			try (InputReader in = new InputReader (new FileInputStream ("input.txt"));
				 PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("output.txt")))) {
				n = in.nextInt ();
				m = in.nextInt ();
				k = in.nextInt ();
				bgn = new ProblemCFireAgain.Pair[k];
				for (int i = 0; i<k; i++) {
					bgn[i] = new ProblemCFireAgain.Pair (in.nextInt (), in.nextInt ());
				}
				max = Integer.MIN_VALUE;
				lvl = new int[n+5][m+5];
				for (int i = 0; i<n+4; i++) {
					Arrays.fill (lvl[i], -1);
				}
				bfs2d ();
//			System.out.println (max);
				out.println (res);
			} catch (Exception e) {
//			e.printStackTrace ();
			}
		}
		
		private static class Pair {
			int a;
			int b;
			
			Pair (int a, int b) {
				this.a = a;
				this.b = b;
			}
			
			
			public String toString () {
				return a+" "+b;
			}
			
			
			public boolean equals (Object o) {
				if (this == o) return true;
				if (!(o instanceof ProblemCFireAgain.Pair)) return false;
				ProblemCFireAgain.Pair pair = (ProblemCFireAgain.Pair) o;
				return a == pair.a && b == pair.b;
			}
			
			
			public int hashCode () {
				return Objects.hash (a, b);
			}
			
		}
		
	}
	
	static class InputReader implements AutoCloseable {
		private BufferedReader reader;
		private StringTokenizer tokenizer;
		
		public InputReader (InputStream stream) {
			reader = new BufferedReader (new InputStreamReader (stream));
			tokenizer = null;
		}
		
		public String next () {
			while (tokenizer == null || !tokenizer.hasMoreTokens ()) {
				try {
					String str;
					if ((str = reader.readLine ()) != null) tokenizer = new StringTokenizer (str);
					else return null;//to detect eof
				} catch (IOException e) {
					throw new RuntimeException (e);
				}
			}
			return tokenizer.nextToken ();
		}
		
		public int nextInt () {
			return Integer.parseInt (next ());
		}
		
		
		public void close () throws Exception {
			reader.close ();
		}
		
	}
}

