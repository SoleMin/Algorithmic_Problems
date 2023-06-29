import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class D implements Runnable{
	public static void main (String[] args) {new Thread(null, new D(), "_cf", 1 << 28).start();}

	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");
		
		int n = fs.nextInt();
		Pair[] a = new Pair[n], b = new Pair[n];
		for(int i = 0; i < n; i++) {
			a[i] = new Pair(fs.nextInt(), i+1);
			b[i] = new Pair(a[i].val, a[i].id);
		}
		Arrays.sort(a);
		
		Fenwick_Tree ft = new Fenwick_Tree(n), ftFreq = new Fenwick_Tree(n);
		BigInteger res = BigInteger.ZERO;
		int[] update = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
//			System.out.println(sum + " " + a[i].val);
			if(i + 1 == n || (i + 1 < n && a[i+1].val != a[i].val)) {
				update[i] = sum+1;
				sum = 0;
			}
			else {
				sum++;
			}
		}
//		System.out.println(Arrays.toString(update));
		for(int i = 0; i < n; i++) {
			int pos = a[i].id;
			long val = a[i].val;
			long right = ft.sum(n) - ft.sum(pos);
			long freq = ftFreq.sum(n) - ftFreq.sum(pos);
			
//			System.out.println(a[i].val + " " + a[i].id + " " + right + " " + freq);
			
			res = add(res, right - (val * freq));
//			res += right - (val * freq);
			
			long left = ft.sum(pos);
			freq = ftFreq.sum(pos);
			res = add(res, (val * freq) - left);
//			res += (val * freq) - left;
			
//			System.out.println(a[i].val + " " + a[i].id + " " + left + " " + freq);
//			System.out.println();
			
			if(update[i] > 0) {
				ft.update(pos, val);
				ftFreq.update(pos, 1);
				int ptr = i-1;
				while(ptr >= 0 && update[ptr] == 0) {
					ft.update(a[ptr].id, val);
					ftFreq.update(a[ptr].id, 1);
					ptr--;
				}
			}
		}
		
		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i = n-1; i >= 0; i--) {
			if(!freq.containsKey(b[i].val+1)) {
				if(!freq.containsKey(b[i].val)) freq.put(b[i].val, 0);
				freq.put(b[i].val, freq.get(b[i].val)+1);
				continue;
			}
			long fr = freq.get(b[i].val+1);
//			System.out.println(i + " " + b[i].val + " " + fr);
			res = sub(res, fr * (b[i].val+1) - (fr * (b[i].val)));
//			res -= (fr*(b[i].val+1)) - (fr*b[i].val);
			if(!freq.containsKey(b[i].val)) freq.put(b[i].val, 0);
			freq.put(b[i].val, freq.get(b[i].val)+1);
 		}
		
//		System.out.println(res);
		freq.clear();
		
		for(int i = 0; i < n; i++) {
			if(!freq.containsKey(b[i].val+1)) {
				if(!freq.containsKey(b[i].val)) freq.put(b[i].val, 0);
				freq.put(b[i].val, freq.get(b[i].val)+1);
				continue;
			}
			long fr = freq.get(b[i].val+1);
//			System.out.println(i + " " + b[i].val + " " + fr);
			res = add(res, (fr*(b[i].val+1)) - (fr*b[i].val));
//			res += (fr*(b[i].val+1)) - (fr*b[i].val);
			if(!freq.containsKey(b[i].val)) freq.put(b[i].val, 0);
			freq.put(b[i].val, freq.get(b[i].val)+1);
 		}
		
		out.println(res);
		
		out.close();
	}
	
	BigInteger add (BigInteger a, long b) {
		BigInteger res = a.add(BigInteger.valueOf(b));
		return res;
	}
	
	BigInteger sub (BigInteger a, long b) {
		BigInteger res = a.subtract(BigInteger.valueOf(b));
		return res;
	}
	
	class Pair implements Comparable<Pair> {
		int val, id;
		Pair (int a, int b) {
			val = a;
			id = b;
		}
		
		public int compareTo (Pair o) {
			if(val == o.val) return Integer.compare(id, o.id);
			return Integer.compare(o.val, val);
		}
	}
	
	class Fenwick_Tree {
		
		long[] bit;
		int n;
		
		public Fenwick_Tree(int a) {
			n = a + 1;
			bit = new long[n];
		}
		
		//Remember that when querying a sum to query the 1-based index of the value.
		
		void update (int index, long val) {
			while(index < n) {
				bit[index] += val;
				index += (index & (-index));
			}
		}
		
		long sum (int index) {
			long sum = 0;
			while(index > 0) {
				sum += bit[index];
				index -= (index & (-index));
			}
			return sum;
		}
	}

	
	void sort (int[] a) {
		int n = a.length;
		for(int i = 0; i < 1000; i++) {
			Random r = new Random();
			int x = r.nextInt(n), y = r.nextInt(n);
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		Arrays.sort(a);
	}
	
	class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				//				br = new BufferedReader(new FileReader("cases.in"));
				st = new StringTokenizer("");
			} catch (Exception e){e.printStackTrace();}
		}
		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}
		public int nextInt() {return Integer.parseInt(next());}
		public long nextLong() {return Long.parseLong(next());}
		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			try {line = br.readLine();}
			catch (Exception e) {e.printStackTrace();}
			return line;
		}
		public Integer[] nextIntegerArray(int n) {
			Integer[] a = new Integer[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
		public char[] nextCharArray() {return nextLine().toCharArray();}
	}

}