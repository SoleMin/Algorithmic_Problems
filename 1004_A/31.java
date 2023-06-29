import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	private PrintWriter pw;
	private long mod = 998244353;

	private StringBuilder ans_sb;
	private int sqrt;
	private void soln() {
		int n = nextInt();
		int d = nextInt();
		int[] arr = nextIntArray(n);
		int cnt = 2;
		for(int i=0;i<n-1;i++) {
			int a1 = arr[i];
			int a2 = arr[i+1];
			a1 += d;
			a2 -= d;
			if(a1 < a2) {
				cnt+=2;
			}else if(a1==a2)
				cnt++;
		}
		pw.println(cnt);
	}
	private class Pair implements Comparable<Pair>{
		int x,i;
		public Pair(int a, int b) {
			x = a;
			i = b;
		}
		@Override
		public int compareTo(
				Pair o)
		{
			return this.x - o.x;
		}
	}
	private int cc = 0;
private void dfs(int c, int p, LinkedList<Integer>[] tree, int[] t, int[] tin, int[] tout, int[] arr) {
	//debug(c);
	t[cc] = arr[c];
	tin[c] = cc++;
	Iterator<Integer> it = tree[c].listIterator();
	while(it.hasNext()) {
		int x = it.next();
		if(x != p) {
			dfs(x, c, tree,t,tin,tout,arr);
		}
	}
	tout[c] = cc;
}
public class Segment
	{
		private Node[] tree;
		private int[] lazy;
		private int size;
		private int n;
		private int[] base;

		private class Node
		{
			private int on;
			private int off;
		}

		public Segment(int n, int[] arr)
		{
			this.base=arr;
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
			size = 2 * (int) Math.pow(2, x) - 1;
			tree = new Node[size];
			lazy = new int[size];
			this.n = n;
			//this.set = set1;
			build(0, 0, n - 1);
		}

		public void build(int id, int l, int r)
		{
			if (l == r)
			{
				tree[id] = new Node();
				if(base[l] == 1)
					tree[id].on++;
				else
					tree[id].off++;
				return;
			}
			int mid = ((l + r)>>1);
			build((id<<1)|1, l, mid);
			build((id<<1)+2, mid + 1, r);
			tree[id] = merge(tree[(id<<1)|1], tree[(id<<1)+2]);
			//System.out.println(l+" "+r+" "+tree[id].l+" "+tree[id].r+" "+tree[id].ans);
		}
		public Node merge(Node n1, Node n2) {
			Node ret = new Node();
			if(n1 == null && n2 == null)
				return null;
			else if(n1 == null) {
				ret.on = n2.on;
				ret.off = n2.off;
			}
			else if(n2 == null) {
				ret.on = n1.on;
				ret.off = n1.off;
			}
			else {
				ret.on = n1.on+n2.on;
				ret.off = n2.off + n1.off;
			}
			return ret;
		}
		public int query(int l, int r)
		{
			Node ret = queryUtil(l, r, 0, 0, n - 1);
			if(ret == null) {
				return 0;
			}
			else
				return ret.on;
		}

		private Node queryUtil(int x, int y, int id, int l, int r)
		{
			if (l > y || x > r)
				return null;
			if (x <= l && r <= y)
			{
				//shift(id,l,r);
				return tree[id];
			}
			int mid = ((l + r)>>1);
			shift(id,l,r);
			Node q1 = queryUtil(x, y, (id<<1)|1, l, mid);
			Node q2 = queryUtil(x, y, (id<<1)+2, mid + 1, r);
			return merge(q1, q2);
		}
		
		public void update(int x, int y, int c) {
			update1(x, y, c, 0, 0, n-1);
		}
		
		private void update1(int x, int y, int colour, int id, int l, int r)
		{
			//System.out.println(l+" "+r+" "+x);
			if (x > r || y < l)
				return;
			if (x <= l && r <= y)
			{
				lazy[id]++;
//				lazy[id] %= 2;
				switchNode(tree[id]);
				return;
			}
			int mid = ((l + r)>>1);
			//shift(id);
			if(y<=mid)
				update1(x, y, colour, (id<<1)|1, l, mid);
			else if(x>mid)
				update1(x, y, colour, (id<<1)+2, mid + 1, r);
			else {
				update1(x, y, colour, (id<<1)|1, l, mid);
				update1(x, y, colour, (id<<1)+2, mid + 1, r);
			}
			tree[id] = merge(tree[(id<<1)|1], tree[(id<<1)+2]);	
		}
		private void shift(int id,int l, int r)
		{
			lazy[id] %= 2;
			if(lazy[id] != 0) {
				if(l != r) {
					lazy[(id<<1)|1] += lazy[id];
					lazy[(id<<1)+2] += lazy[id];
					switchNode(tree[(id<<1)+2]);
					switchNode(tree[(id<<1)|1]);
				}
				//switchNode(tree[(id<<1)+2]);
				lazy[id] = 0;
			}
		}
		private void switchNode(Node d) {
			d.on ^= d.off;
			d.off ^= d.on;
			d.on ^= d.off;
		}
	}

	private void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	private long pow(long a, long b, long c) {
		if (b == 0)
			return 1;
		long p = pow(a, b / 2, c);
		p = (p * p) % c;
		return (b % 2 == 0) ? p : (a * p) % c;
	}

	private long gcd(long n, long l) {
		if (l == 0)
			return n;
		return gcd(l, n % l);
	}

	public static void main(String[] args) throws Exception {
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				new Main().solve();
			}
		}, "1", 1 << 26).start();
		//new Main().solve();
	}

	public StringBuilder solve() {
		InputReader(System.in);
		/*
		 * try { InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\in.txt"));
		 * } catch(FileNotFoundException e) {}
		 */
		pw = new PrintWriter(System.out);
		// ans_sb = new StringBuilder();
		soln();

		pw.close();
		// System.out.println(ans_sb);
		return ans_sb;
	}

	public void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	private int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private String nextToken() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	private int[] nextIntArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		return arr;
	}

	private long[] nextLongArray(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextLong();
		}
		return arr;
	}

	private void pArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private void pArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private char nextChar() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		char c1 = (char) c;
		while (!isSpaceChar(c))
			c = read();
		return c1;
	}

	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}