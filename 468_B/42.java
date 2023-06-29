import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer str = null;
	PrintWriter out;
	
	private String next() throws Exception{
		while (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	private double nextDouble() throws Exception{
		return Double.parseDouble(next());
	}

	Map<Integer, Integer> map;
	int []p, rank;

	public void run() throws Exception{
		in =  new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		map = new HashMap<Integer, Integer>();

		int n = nextInt();
		int x = nextInt(), y = nextInt();
		int []a = new int[n];
		p = new int[n];
		for(int i = 1; i < n; ++i) p[i] = i;
		rank = new int[n];

		for(int i = 0; i < n; ++i) {
			a[i] = nextInt();
			map.put(a[i], i);
		}
		int mask[] = new int[n];
		for(int i = 0; i < n; ++i) {
			if (map.containsKey(x - a[i])) {
				union(map.get(x - a[i]), i);
				mask[i] |= 1;	
			} 
			if (map.containsKey(y - a[i])) {
				union(map.get(y - a[i]), i);
				mask[i] |= 2;
			} 
		}

		int []b = new int[n];
		Arrays.fill(b, 3);
		for(int i = 0; i < n; ++i) b[find(i)] &= mask[i];
		for(int i = 0; i < n; ++i) {
			if (b[i] == 0) {
				out.println("NO");
				out.close();
				return;
			}
		}

		out.println("YES");
		for(int i = 0; i < n; ++i) {
			out.print((b[find(i)] & 1) == 1 ? 0 : 1);
			if (i != n - 1) out.print(" ");
		}
		out.println();
		out.close();
	}

	private int find(int x) {
		if (x != p[x])
			return p[x] = find(p[x]);
		return x;
	}
	private void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (rank[a] < rank[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		p[b] = a;
		if (rank[a] == rank[b]) ++rank[a];
	}
		
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
