import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;

public class F547 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = in.nextInt();
		
		long[] sum = new long[arr.length + 1];
		for(int i = 1; i < sum.length; i++)
			sum[i] = sum[i-1] + arr[i-1];
		
		HashMap<Long, ArrayList<Pair>> map = new HashMap<>();
		
		for(int i = 0; i < sum.length; i++) {
			for(int j = i+1; j < sum.length; j++) {
				long diff = sum[j] - sum[i];
				
				if(!map.containsKey(diff))
					map.put(diff, new ArrayList<>());
				
				ArrayList<Pair> list = map.get(diff);
				list.add(new Pair(i, j));
			}
		}
		
		for(long key : map.keySet()) {
			ArrayList<Pair> list1 = map.get(key);
			Collections.sort(list1);
			
			ArrayList<Pair> list2 = new ArrayList<>();
			
			int end = 0;
			for(Pair p : list1) {
				if(end <= p.a) {
					list2.add(p);
					end = p.b;
				}
			}
			
			map.put(key, list2);
		}
		
		long maxKey = -1;
		int max = -1;
		for(long key : map.keySet()) {
			if(map.get(key).size() > max) {
				max = map.get(key).size();
				maxKey = key;
			}
		}
		
		ArrayList<Pair> list = map.get(maxKey);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size());
		sb.append("\n");
		
		for(Pair p : list) {
			sb.append((1 + p.a) + " " + p.b);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Pair implements Comparable<Pair> {
		int a, b;
		
		public Pair(int x, int y) {
			a = x;
			b = y;
		}
		
		public int compareTo(Pair other) {
			if(b != other.b) {
				return b - other.b;
			}
			return other.a - a;
		}
		
		public String toString() {
			return "(" + a + ", " + b + ")";
		}
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		public String next() {
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

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}
/*
7
4 1 2 2 1 5 3
outputCopy
3
7 7
2 3
4 5
inputCopy
11
-5 -4 -3 -2 -1 0 1 2 3 4 5
outputCopy
2
3 4
1 1
inputCopy
4
1 1 1 1
outputCopy
4
4 4
1 1
2 2
3 3
*/