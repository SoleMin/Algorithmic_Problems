import java.util.*;
import java.math.*;

// **** E1. Rotate Columns (easy version) ****

public class E1 {
	static char [] in = new char [1000000];
	public static void main (String [] arg) throws Throwable {
		int t = nextInt();
		C : for (int ii = 0; ii<t; ++ii) {
			int n = nextInt();
			int m = nextInt();
			Pair [] P = new Pair [n*m];
			int [][] g = new int [n][m];
			for (int i = 0; i<n; ++i) { 
				for (int j = 0; j<m; ++j) {
					g[i][j] = nextInt();
					P[j + m*i] = new Pair (i, j, g[i][j]);
				}
			}
			for (int i = 0; i<P.length; ++i) if (P[i] == null) continue C;
			Arrays.sort(P);
			HashSet<Integer> rotcols =new HashSet<Integer>();
			for (int i = 0; i<n; ++i) {
				//System.err.println("Adding " + P[i].j + " , " + P[i].L);
				rotcols.add(P[i].j);
			}
			
			if (n <= 3 || rotcols.size() >= 3) {
				//System.err.println("EASY");
				int sum = 0;
				for (int i = 0; i<n && i < P.length; ++i) sum += P[i].L;
				System.out.println(sum);
			} else {
				// n == 4
				if (P.length > 4) rotcols.add(P[4].j);
				//Integer [] rr = rotcols.toArray(new Integer[0]);
				int [] rot = new int [rotcols.size()];
				int maxmax = 0;
				A : while (true) {
					for (int i = 0; i<rot.length; ++i) {
						rot[i]++;
						if (rot[i] == n) {
							rot[i] = 0;
							if (i == rot.length-1) break A;
						} else {
							break;
						}
					}
					int [] max = new int [n];
					for (int i = 0; i<n; ++i) {
						int j = 0;
						for (int col : rotcols) {
							max[i] = Math.max(max[i], g[(i+rot[j])%n][col]);
							j++;
						}
					}
					int sum = 0;
					for (int m2 : max) sum+= m2;
					maxmax = Math.max(maxmax, sum);
				}
				System.out.println(maxmax);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** HELPER CLASSES ***************/
    //static class HS extends HashSet<Integer>{public HS(){super();}public HS(int a){super(a);}};
	//static class AL extends ArrayList<Integer>{public AL(){super();}public AL(int a){super (a);}};
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;} 
		public int compareTo(Pair p) { return (this.L > p.L) ? -1 : (this.L == p.L) ? this.i - p.i : 1;}
	}
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 33) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static String next() throws Throwable {
		int i = 0; while (i < 33 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 33) { in[cptr++] = (char)i; i = System.in.read();}
		return new String(in, 0,cptr);
	}
	/**** LIBRARIES ****/
	public static long gcdL(long a, long b) {while (b != 0) {long tmp = b;b = (a % b);a = tmp;}return a;}
	public static int gcd(int a, int b) {while (b != 0) {int tmp = b;b = (a % b);a = tmp;}return a;}
	public static int[] sieve(int LIM) {
		int i,count = 0;
		boolean [] b = new boolean [LIM];
		for (i = 2;i<LIM; ++i) if (!b[i]) {count++; for (int j = i<<1; j<LIM; j+=i) b[j] = true;}
		int [] primes = new int[count];
		for (i = 2,count=0;i<LIM;++i) if (!b[i]) primes[count++] = i;
		return primes;
	}
	public static int[] numPrimeFactors(int LIM) {
		int i,count = 0;
		int [] b = new int [LIM];
		for (i = 2;i<LIM; ++i) if (b[i] == 0) {count++; for (int j = i; j<LIM; j+=i) b[j]++;}
		return b;
	}
	public static StringBuilder stringFromArray(int [] a) {
		StringBuilder b = new StringBuilder(9*a.length);
		for (int i = 0; i<a.length; ++i) {
			if (i != 0) b = b.append(' ');
			b = b.append(a[i]);
		}
		return b;
	}
	public static long modPow (long a, long n, long MOD) { long S = 1; for (;n > 0; n>>=1, a=(a*a)%MOD) if ((n & 1) != 0) S = (a*S) % MOD; return S;}
}

/* Full Problem Text:
  
This is an easier version of the next problem.
The difference is only in constraints.
You are given a rectangular n \times m matrix a.
In one move you can choose any column and cyclically shift elements in this column.
You can perform this operation as many times as you want (possibly zero).
You can perform this operation to a column multiple times.
After you are done with cyclical shifts, you compute for every row the maximal value in it.
Suppose that for i-th row it is equal r_i.
What is the maximal possible value of r_1+r_2+...+r_n?

 */