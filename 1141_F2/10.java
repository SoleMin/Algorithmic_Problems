import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] a = in.na(n);
		HashMap<Long, ArrayList<Pair>> v = new HashMap<>();
		for(int i = 0; i<n; i++) {
			long s  = 0;
			for(int j = i; j<n; j++) {
				s+=a[j];
				Pair p = new Pair(i+1, j+1);
				if(v.containsKey(s)) {
					v.get(s).add(p);
				}else {
					ArrayList<Pair> xd = new ArrayList<>();
					xd.add(p);
					v.put(s,xd);
				}
			}
		}
		ArrayList<Pair> ans = new ArrayList<>();
		for(Entry<Long,ArrayList<Pair>> e : v.entrySet()) {
			ArrayList<Pair> pairs = e.getValue();
			Collections.sort(pairs);
			Stack<Pair> st = new Stack<>();
			for(int i = 0; i<pairs.size(); i++) {
				Pair cur = pairs.get(i);
				if(st.isEmpty()||st.peek().r<cur.l) {
					st.push(cur);
				}else if(st.peek().r>cur.r) {
						st.pop();
						st.push(cur);
				}
				if(st.size()>ans.size()) ans = new ArrayList<>(st);
			}
		}
		System.out.println(ans.size());
		for(Pair p : ans)
			System.out.println(p.l +" "+p.r);
	}
	static class Pair implements Comparable<Pair>{
		int l,r;
		public Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Pair o) {
			return this.l - o.l;
		}
	}
	static class Reader {
		static BufferedReader br;
		static StringTokenizer st;

		public Reader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nl(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public String[] nS(int n) {
			String[] a = new String[n];
			for (int i = 0; i < n; i++)
				a[i] = next();
			return a;
		}

		public int nextInt() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Integer.parseInt(st.nextToken());
		}

		public double nextDouble() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Double.parseDouble(st.nextToken());
		}

		public Long nextLong() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Long.parseLong(st.nextToken());
		}

		public String next() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return st.nextToken();
		}

		public static void readLine() {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
			}
		}
	}
}