import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;
import static java.util.Arrays.fill;
import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.binarySearch;
 
import static java.lang.Math.min;
import static java.lang.Math.max;
 
import static java.lang.Math.min;
import static java.lang.Math.max;
 
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Main {

	public static void main(String[] args) throws IOException {
		int n = in.nextInt();
		int[] a = in.nextIntArray(n);
		sort(a);
		int ans = 0;
		boolean[] done = new boolean[n];
		for(int i = 0; i < n; i ++) {
			if(done[i])
				continue;
			ans ++;
			for(int j = i + 1; j < n; j ++)
				if(a[j] % a[i] == 0)
					done[j] = true;
		}
		out.write(ans + "\n");
		out.flush();
	}
 
	public static FastReader in = new FastReader();
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void gcj(int cn, Object ans) throws IOException {
		System.out.print("Case #" + cn + ": " + ans + "\n");
	}
	
	public static ArrayList <Integer>[] ALArrayI(int size) {
		ArrayList <Integer>[] l = new ArrayList[size];
		for(int i = 0; i < size; i ++)
			l[i] = new ArrayList <> ();
		return l;
	}
	
	public static ArrayList <Long>[] ALArrayL(int size) {
		ArrayList <Long>[] l = new ArrayList[size];
		for(int i = 0; i < size; i ++)
			l[i] = new ArrayList <> ();
		return l;
	}
	
	public static Integer[] integerList(int fi, int fo) {
		Integer[] l = new Integer[fo - fi];
		for(int i = 0; i < fo - fi; i ++)
			l[i] = fi + i;
		return l;
	}
}
 
class Graph {
	TreeSet <Integer>[] g;
	
	public Graph(int n) {
		g = new TreeSet[n];
		for(int i = 0; i < n; i ++)
			g[i] = new TreeSet <> ();
	}
	
	public void addEdge(int u, int v) {
		g[u].add(v);
	}
	
	public TreeSet <Integer> getAdj(int u) {
		return g[u];
	}
	
	public int nodes() {
		return g.length;
	}
}
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
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
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    public int[] nextIntArray(int n) {
    	int[] a = new int[n];
    	for(int i = 0; i < n; i ++)
    		a[i] = nextInt();
    	return a;
    }
    
    public Integer[] nextIntegerArray(int n) {
    	Integer[] a = new Integer[n];
    	for(int i = 0; i < n; i ++)
    		a[i] = nextInt();
    	return a;
    }
    
    public long[] nextLongArray(int n) {
    	long[] a = new long[n];
    	for(int i = 0; i < n; i ++)
    		a[i] = nextLong();
    	return a;
    }
    
    public double[] nextDoubleArray(int n) {
    	double[] a = new double[n];
    	for(int i = 0; i < n; i ++)
    		a[i] = nextDouble();
    	return a;
    }
    
    public String[] nextStringArray(int n) {
    	String[] a = new String[n];
    	for(int i = 0; i < n; i ++)
    		a[i] = next();
    	return a;
    }
}