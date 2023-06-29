

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;



@SuppressWarnings("unused")
public class Fire35C {

	InputStream is;
	PrintWriter out;
	String INPUT = "";


	int mod = (int)(Math.pow(10,9)+7);
	int v = 0;
	int max = 0;
	StringBuilder st = new StringBuilder();
	File outFile = new File("output.txt");
	void solve() throws IOException
	{	

		int n = ni();
		int m = ni();

		boolean visited[][] = new boolean[n][m];
		boolean inq[][] = new boolean[n][m];
		Queue<Integer> x = new LinkedList<>();
		Queue<Integer> y = new LinkedList<>();
		Queue<Integer> lev = new LinkedList<>();

		int a = -1 , b = -1 , max = 0;

		int k = ni();
		while(k-- > 0) {
			int u = ni()-1;
			int v = ni()-1;
			x.add(u);
			y.add(v);
			lev.add(1);
			inq[u][v] = true;	
		}

		while(x.size() != 0) {

			int u = x.poll();
			int v = y.poll();
			int l = lev.poll();
			if(max < l) {
				a = u;
				b = v;
				max = l;
			}
			visited[u][v] = true;
			if(u-1 >= 0 && !visited[u-1][v] && !inq[u-1][v]) {
				x.add(u-1);
				y.add(v);
				lev.add(l+1);
				inq[u-1][v] = true;
			}

			if(u+1 < n && !visited[u+1][v] && !inq[u+1][v]) {
				x.add(u+1);
				y.add(v);
				lev.add(l+1);
				inq[u+1][v] = true;
			}

			if(v-1 >= 0 && !visited[u][v-1] && !inq[u][v-1]) {
				x.add(u);
				y.add(v-1);
				lev.add(l+1);
				inq[u][v-1] = true;
			}

			if(v+1 < m && !visited[u][v+1] && !inq[u][v+1]) {
				x.add(u);
				y.add(v+1);
				lev.add(l+1);
				inq[u][v+1] = true;
			}
			

		}
		a++;
		b++;

		out.println(a+" "+b);
		out.close();
	}


	void run() throws Exception
	{
		is = INPUT.isEmpty() ? new FileInputStream(new File("input.txt")) : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}

	public static void main(String[] args) throws Exception { new Fire35C().run(); }

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }

	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b) && b != ' ')){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}

	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}

	private int[][] na(int n , int m)
	{
		int[][] a = new int[n][m];
		for(int i = 0;i < n;i++) 
			for(int j = 0 ; j<m ; j++) a[i][j] = ni();
		return a;
	}

	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}

		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}

		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	void display2D(int a[][]) {
		for(int i[] : a) {
			for(int j : i) {
				out.print(j+" ");
			}
			out.println();
		}
	}

	int[][] creategraph(int n , int m) {
		int g[][] = new int[n+1][];

		int from[] = new int[m];
		int to[] = new int[m];
		int ct[] = new int[n+1];

		for(int i = 0 ; i<m; i++) {
			from[i] = ni();
			to[i] = ni();
			ct[from[i]]++;
			ct[to[i]]++;
		}

		int parent[] = new int[n+1];

		for(int i = 0 ; i<n+1 ; i++) g[i] = new int[ct[i]];

		for(int i = 0 ; i<m ; i++) {
			g[from[i]][--ct[from[i]]] = to[i];
			g[to[i]][--ct[to[i]]] = from[i];
		}

		return g;
	}

	static long __gcd(long a, long b)
	{

		if(b == 0) 
		{
			return a;
		}
		else
		{
			return __gcd(b, a % b);
		}
	}

	// To compute x^y under modulo m
	static long power(long x, long y, long p)
	{

		// Initialize result
		long res = 1;

		// Update x if it is more than or
		// equal to p
		x = x % p;

		while (y > 0)
		{

			// If y is odd, multiply x
			// with result
			if (y % 2 == 1)
				res = (res * x) % p;

			// y must be even now
			y = y >> 1; // y = y/2
		x = (x * x) % p;
		}

		return res;
	}

	// Function to find modular 
	// inverse of a under modulo m
	// Assumption: m is prime
	static long modInverse(long a, int m)
	{
		if (__gcd(a, m) != 1) {
			//System.out.print("Inverse doesn't exist");
			return -1;
		}

		else {

			// If a and m are relatively prime, then
			// modulo inverse is a^(m-2) mode m
			//			System.out.println("Modular multiplicative inverse is "
			//											+power(a, m - 2, m));
			return power(a, m - 2, m);
		}
	}

	static long nCrModPFermat(int n, int r,
			int p , long fac[])
	{

		// Base case
		if (r == 0)
			return 1;

		// Fill factorial array so that we
		// can find all factorial of r, n
		// and n-r
		long t = (fac[n]* modInverse(fac[r], p))%p;

		return ( (t* modInverse(fac[n-r], p))% p);
	}


	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}


